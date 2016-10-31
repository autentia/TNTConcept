/**
 * TNTConcept Easy Enterprise Management by Autentia Real Bussiness Solution S.L.
 * Copyright (C) 2007 Autentia Real Bussiness Solution S.L.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.autentia.tnt.bean.holiday;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.mail.MessagingException;

import com.autentia.tnt.mail.DefaultMailService;
import com.autentia.tnt.util.ConfigurationUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.autentia.tnt.bean.BaseBean;
import com.autentia.tnt.bean.NavigationResults;
import com.autentia.tnt.businessobject.HolidayState;
import com.autentia.tnt.businessobject.RequestHoliday;
import com.autentia.tnt.businessobject.User;
import com.autentia.tnt.dao.SortCriteria;
import com.autentia.tnt.dao.search.RequestHolidaySearch;
import com.autentia.tnt.manager.admin.UserManager;
import com.autentia.tnt.manager.holiday.RequestHolidayManager;
import com.autentia.tnt.manager.holiday.UserHolidaysStateManager;
import com.autentia.tnt.manager.security.AuthenticationManager;
import com.autentia.tnt.manager.security.Permission;
import com.autentia.tnt.upload.Uploader;
import com.autentia.tnt.upload.UploaderFactory;
import com.autentia.tnt.util.FacesUtils;
import com.autentia.tnt.util.SpringUtils;

import org.acegisecurity.acls.domain.BasePermission;

public class RequestHolidayBean extends BaseBean {

    private static AuthenticationManager authMgr = AuthenticationManager.getDefault();
  
/* requestHoliday - generated by stajanov (do not edit/delete) */

    /**
     * Logger
     */
    private static final Log log = LogFactory.getLog(RequestHolidayBean.class);

    /**
     * Active search object
     */
    private RequestHolidaySearch search = new RequestHolidaySearch();

    /**
     * Manager
     */
    private static RequestHolidayManager manager = RequestHolidayManager.getDefault();

    /**
     * Upload service
     */
    private static final Uploader uploader = UploaderFactory.getInstance("requestHoliday");


    /**
     * Active RequestHoliday object
     */
    private RequestHoliday requestHoliday;

    /**
     * Default sort column
     */
    private String sortColumn = "beginDate";

    /**
     * Default sort order
     */
    private boolean sortAscending = false;


    // Getters to list possible values of related entities

    /**
     * Get the list of all userRequests
     *
     * @return the list of all userRequests
     */
    public List<SelectItem> getUserRequests() {
        List<User> refs = UserManager.getDefault().getAllEntities(null, new SortCriteria("name"));

        ArrayList<SelectItem> ret = new ArrayList<SelectItem>();
        for (User ref : refs) {
            ret.add(new SelectItem(ref, ref.getName()));
        }
        return ret;
    }

    // Getters to list possible values of enum fields

    public String getStateFormatted() {
        if (this.getState() != null) {
            return FacesUtils.formatMessage("HolidayState." + this.getState().name());
        } else {
            return "";
        }
    }

    /**
     * Get the list of all State values
     *
     * @return the list of all State values
     */
    public List<SelectItem> getStates() {
        ArrayList<SelectItem> ret = new ArrayList<SelectItem>();
        HolidayState[] vals = HolidayState.values();
        for (HolidayState val : vals) {
            ret.add(new SelectItem(val, FacesUtils.formatMessage("HolidayState." + val.name())));
        }
        return ret;
    }


    // Methods to create/remove instances of one-to-many entities (slave entities)

    /**
     * Whether or not create button is available for user
     *
     * @return true if user can create objects of type RequestHoliday
     */
    public boolean isCreateAvailable() {
        return SpringUtils.isRolePermissionGranted(Permission.Entity_Create(RequestHoliday.class));
    }

    /**
     * Whether or not edit button is available for user
     *
     * @return true if user can edit current object
     */
    public boolean isEditAvailable() {
        return SpringUtils.isAclPermissionGranted(requestHoliday, BasePermission.WRITE);
    }

    /**
     * Whether or not delete button is available for user
     *
     * @return true if user can delete current object
     */
    public boolean isDeleteAvailable() {
        return (requestHoliday.getId() != null) &&
                SpringUtils.isAclPermissionGranted(requestHoliday, BasePermission.DELETE);
    }

    /**
     * Go to create page
     *
     * @return forward to CREATE page
     */
    public String create() {
        requestHoliday = new RequestHoliday();
        //Inicializa el estado a pendiente
        this.setState(HolidayState.PENDING);
        if (getUserRequest() == null) {
            setUserRequest(authMgr.getCurrentPrincipal().getUser());
        }
        return NavigationResults.CREATE;
    }

    /**
     * Go to detail page
     *
     * @return forward to DETAIL page
     */
    public String detail() {
        Integer id = Integer.parseInt(FacesUtils.getRequestParameter(ROW_ID));
        requestHoliday = manager.getEntityById(id);

        return SpringUtils.isAclPermissionGranted(requestHoliday, BasePermission.WRITE)
                ? NavigationResults.EDIT
                : NavigationResults.DETAIL;
    }

    /**
     * Save bean and stay on it
     *
     * @return forward to list page
     */
    public String save() {
        String result = doBeforeSave();

        if (result != null) {
            return result;
        }

        if (requestHoliday.getId() == null) {
            manager.insertEntity(requestHoliday);
        } else {
            manager.updateEntity(requestHoliday);
        }

        // Calls an after save action
        result = doAfterSave(NavigationResults.LIST);
        sendEmail();

        // Unselect object
        requestHoliday = null;

        return result;
    }

    protected void sendEmail() {
        final DefaultMailService mailService = (DefaultMailService) SpringUtils.getSpringBean("mailService");

        final Collection<String> mailSendToHolidayApprovers = ConfigurationUtil.getDefault().getMailSendToHolidayApprovers();

        for (String sendTo : mailSendToHolidayApprovers) {
            final String name = this.search.getUserRequest().getName();
            String subject = "Solicitud de vacaciones para " + name;

            DateFormat dateFormat = new SimpleDateFormat( "dd-MM-yyyy" +
                    "" );
            final String beginDate = dateFormat.format(this.requestHoliday.getBeginDate());
            final String finalDate = dateFormat.format(this.requestHoliday.getFinalDate());

            final String newLine = "</div><div>";
            String messageBody = ("<div>Usuario: ")
                    .concat("<b>" + name + "</b>")
                    .concat(newLine)
                    .concat("Fecha de inicio: ")
                    .concat("<b>" + beginDate + "</b>")
                    .concat(newLine)
                    .concat("Fecha de fin: ")
                    .concat("<b>" + finalDate + "</b>")
                    .concat(newLine)
                    .concat("Comentarios: ")
                    .concat(this.requestHoliday.getUserComment())
                    .concat(newLine);
            try {
                mailService.sendHtml(sendTo, subject, messageBody);
            } catch (MessagingException e) {
                log.error("Send mail", e);
            }
        }
    }

    private boolean validateHasEnoughAvaliableFreeHoliday() {
        User user = AuthenticationManager.getDefault().getCurrentPrincipal().getUser();
        int requestedDays = UserHolidaysStateManager.getDefault().getWorkingDays(this.getBeginDate(), this.getFinalDate());
        int freeDays = UserHolidaysStateManager.getDefault().getFreeDays(user, this.getChargeYear());

        if (log.isDebugEnabled()) {
            log.debug("Solicito " + requestedDays + " dias. Le quedan libres " + freeDays + " dias");
        }

        return (requestedDays <= freeDays);
    }

    /**
     * Delete bean and go back to beans list
     *
     * @return forward to LIST page
     */
    public String delete() {
        manager.deleteEntity(requestHoliday);
        requestHoliday = null;
        return NavigationResults.LIST;
    }

    /**
     * Go back to beans list
     *
     * @return forward to LIST page
     */
    public String list() {
        return NavigationResults.LIST;
    }

    /**
     * Reset search criteria
     *
     * @return forward to LIST page
     */
    public String reset() {
        search.reset();
        return list();
    }

    /**
     * Go to search page
     *
     * @return forward to SEARCH page
     */
    public String search() {
        return NavigationResults.SEARCH;
    }

    /**
     * Check if we have an active object.
     *
     * @return true is an object is selected
     */
    public boolean isRequestHolidaySelected() {
        return requestHoliday != null;
    }

    // Getters and setters to manipulate sorting
    public boolean isSortAscending() {
        return sortAscending;
    }

    public void setSortAscending(boolean sortAscending) {
        this.sortAscending = sortAscending;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    // Getters and setters to handle search
    public RequestHolidaySearch getSearch() {
        return search;
    }


    public Date getSearchStartBeginDate() {
        return search.getStartBeginDate();
    }

    public void setSearchStartBeginDate(Date val) {
        if (val != null) {
            search.setStartBeginDate(val);
        } else {
            search.unsetStartBeginDate();
        }
    }

    public boolean isSearchStartBeginDateValid() {
        return search.isStartBeginDateSet();
    }

    public void setSearchStartBeginDateValid(boolean val) {
        if (val) {
            search.setStartBeginDate(search.getStartBeginDate());
        } else {
            search.unsetStartBeginDate();
        }
    }

    public Date getSearchEndBeginDate() {
        return search.getEndBeginDate();
    }

    public void setSearchEndBeginDate(Date val) {
        if (val != null) {
            search.setEndBeginDate(val);
        } else {
            search.unsetEndBeginDate();
        }
    }

    public boolean isSearchEndBeginDateValid() {
        return search.isEndBeginDateSet();
    }

    public void setSearchEndBeginDateValid(boolean val) {
        if (val) {
            search.setEndBeginDate(search.getEndBeginDate());
        } else {
            search.unsetEndBeginDate();
        }
    }


    public Date getSearchStartFinalDate() {
        return search.getStartFinalDate();
    }

    public void setSearchStartFinalDate(Date val) {
        if (val != null) {
            search.setStartFinalDate(val);
        } else {
            search.unsetStartFinalDate();
        }
    }

    public boolean isSearchStartFinalDateValid() {
        return search.isStartFinalDateSet();
    }

    public void setSearchStartFinalDateValid(boolean val) {
        if (val) {
            search.setStartFinalDate(search.getStartFinalDate());
        } else {
            search.unsetStartFinalDate();
        }
    }

    public Date getSearchEndFinalDate() {
        return search.getEndFinalDate();
    }

    public void setSearchEndFinalDate(Date val) {
        if (val != null) {
            search.setEndFinalDate(val);
        } else {
            search.unsetEndFinalDate();
        }
    }

    public boolean isSearchEndFinalDateValid() {
        return search.isEndFinalDateSet();
    }

    public void setSearchEndFinalDateValid(boolean val) {
        if (val) {
            search.setEndFinalDate(search.getEndFinalDate());
        } else {
            search.unsetEndFinalDate();
        }
    }


    public HolidayState getSearchState() {
        return search.getState();
    }

    public void setSearchState(HolidayState val) {
        if (search.isStateSet()) {
            search.setState(val);
        }
    }

    public boolean isSearchStateValid() {
        return search.isStateSet();
    }

    public void setSearchStateValid(boolean val) {
        if (val) {
            search.setState(search.getState());
        } else {
            search.unsetState();
        }
    }


    public String getSearchUserComment() {
        return search.getUserComment();
    }

    public void setSearchUserComment(String val) {
        if (search.isUserCommentSet()) {
            search.setUserComment(val);
        }
    }

    public boolean isSearchUserCommentValid() {
        return search.isUserCommentSet();
    }

    public void setSearchUserCommentValid(boolean val) {
        if (val) {
            search.setUserComment(search.getUserComment());
        } else {
            search.unsetUserComment();
        }
    }


    public String getSearchObservations() {
        return search.getObservations();
    }

    public void setSearchObservations(String val) {
        if (search.isObservationsSet()) {
            search.setObservations(val);
        }
    }

    public boolean isSearchObservationsValid() {
        return search.isObservationsSet();
    }

    public void setSearchObservationsValid(boolean val) {
        if (val) {
            search.setObservations(search.getObservations());
        } else {
            search.unsetObservations();
        }
    }


    public Date getSearchStartChargeYear() {
        return search.getStartChargeYear();
    }

    public void setSearchStartChargeYear(Date val) {
        if (val != null) {
            search.setStartChargeYear(val);
        } else {
            search.unsetStartChargeYear();
        }
    }

    public boolean isSearchStartChargeYearValid() {
        return search.isStartChargeYearSet();
    }

    public void setSearchStartChargeYearValid(boolean val) {
        if (val) {
            search.setStartChargeYear(search.getStartChargeYear());
        } else {
            search.unsetStartChargeYear();
        }
    }

    public Date getSearchEndChargeYear() {
        return search.getEndChargeYear();
    }

    public void setSearchEndChargeYear(Date val) {
        if (val != null) {
            search.setEndChargeYear(val);
        } else {
            search.unsetEndChargeYear();
        }
    }

    public boolean isSearchEndChargeYearValid() {
        return search.isEndChargeYearSet();
    }

    public void setSearchEndChargeYearValid(boolean val) {
        if (val) {
            search.setEndChargeYear(search.getEndChargeYear());
        } else {
            search.unsetEndChargeYear();
        }
    }


    public Integer getSearchDepartmentId() {
        return search.getDepartmentId();
    }

    public void setSearchDepartmentId(Integer val) {
        if (search.isDepartmentIdSet()) {
            search.setDepartmentId(val);
        }
    }

    public boolean isSearchDepartmentIdValid() {
        return search.isDepartmentIdSet();
    }

    public void setSearchDepartmentIdValid(boolean val) {
        if (val) {
            search.setDepartmentId(search.getDepartmentId());
        } else {
            search.unsetDepartmentId();
        }
    }


    public Date getSearchStartInsertDate() {
        return search.getStartInsertDate();
    }

    public void setSearchStartInsertDate(Date val) {
        if (val != null) {
            search.setStartInsertDate(val);
        } else {
            search.unsetStartInsertDate();
        }
    }

    public boolean isSearchStartInsertDateValid() {
        return search.isStartInsertDateSet();
    }

    public void setSearchStartInsertDateValid(boolean val) {
        if (val) {
            search.setStartInsertDate(search.getStartInsertDate());
        } else {
            search.unsetStartInsertDate();
        }
    }

    public Date getSearchEndInsertDate() {
        return search.getEndInsertDate();
    }

    public void setSearchEndInsertDate(Date val) {
        if (val != null) {
            search.setEndInsertDate(val);
        } else {
            search.unsetEndInsertDate();
        }
    }

    public boolean isSearchEndInsertDateValid() {
        return search.isEndInsertDateSet();
    }

    public void setSearchEndInsertDateValid(boolean val) {
        if (val) {
            search.setEndInsertDate(search.getEndInsertDate());
        } else {
            search.unsetEndInsertDate();
        }
    }


    public Date getSearchStartUpdateDate() {
        return search.getStartUpdateDate();
    }

    public void setSearchStartUpdateDate(Date val) {
        if (val != null) {
            search.setStartUpdateDate(val);
        } else {
            search.unsetStartUpdateDate();
        }
    }

    public boolean isSearchStartUpdateDateValid() {
        return search.isStartUpdateDateSet();
    }

    public void setSearchStartUpdateDateValid(boolean val) {
        if (val) {
            search.setStartUpdateDate(search.getStartUpdateDate());
        } else {
            search.unsetStartUpdateDate();
        }
    }

    public Date getSearchEndUpdateDate() {
        return search.getEndUpdateDate();
    }

    public void setSearchEndUpdateDate(Date val) {
        if (val != null) {
            search.setEndUpdateDate(val);
        } else {
            search.unsetEndUpdateDate();
        }
    }

    public boolean isSearchEndUpdateDateValid() {
        return search.isEndUpdateDateSet();
    }

    public void setSearchEndUpdateDateValid(boolean val) {
        if (val) {
            search.setEndUpdateDate(search.getEndUpdateDate());
        } else {
            search.unsetEndUpdateDate();
        }
    }


    public User getSearchUserRequest() {
        return search.getUserRequest();
    }

    public void setSearchUserRequest(User val) {
        if (search.isUserRequestSet()) {
            search.setUserRequest(val);
        }
    }

    public boolean isSearchUserRequestValid() {
        return search.isUserRequestSet();
    }

    public void setSearchUserRequestValid(boolean val) {
        if (val) {
            search.setUserRequest(search.getUserRequest());
        } else {
            search.unsetUserRequest();
        }
    }


    // Getters and setters to handle uploads

    // Getters and setters to manipulate active RequestHoliday object
    public java.lang.Integer getId() {
        return requestHoliday.getId();
    }


    public Date getBeginDate() {
        return requestHoliday.getBeginDate();
    }

    public void setBeginDate(Date beginDate) {
        requestHoliday.setBeginDate(beginDate);
    }


    public Date getFinalDate() {
        return requestHoliday.getFinalDate();
    }

    public void setFinalDate(Date finalDate) {
        requestHoliday.setFinalDate(finalDate);
    }


    public HolidayState getState() {
        return requestHoliday.getState();
    }

    public void setState(HolidayState state) {
        requestHoliday.setState(state);
    }


    public String getUserComment() {
        return requestHoliday.getUserComment();
    }

    public void setUserComment(String userComment) {
        requestHoliday.setUserComment(userComment);
    }


    public String getObservations() {
        return requestHoliday.getObservations();
    }

    public void setObservations(String observations) {
        requestHoliday.setObservations(observations);
    }


    public Date getChargeYear() {
        return requestHoliday.getChargeYear();
    }

    public void setChargeYear(Date chargeYear) {
        requestHoliday.setChargeYear(chargeYear);
    }


    public Integer getDepartmentId() {
        return requestHoliday.getDepartmentId();
    }

    public void setDepartmentId(Integer departmentId) {
        requestHoliday.setDepartmentId(departmentId);
    }


    public Date getInsertDate() {
        return requestHoliday.getInsertDate();
    }

    public void setInsertDate(Date insertDate) {
        requestHoliday.setInsertDate(insertDate);
    }


    public Date getUpdateDate() {
        return requestHoliday.getUpdateDate();
    }

    public void setUpdateDate(Date updateDate) {
        requestHoliday.setUpdateDate(updateDate);
    }


    public User getUserRequest() {
        return requestHoliday.getUserRequest();
    }

    public void setUserRequest(User userRequest) {
        requestHoliday.setUserRequest(userRequest);
    }
        
/* requestHoliday - generated by stajanov (do not edit/delete) */

    /**
     * List requestHolidays. Order depends on Faces parameter sort.
     *
     * @return the list of all requestHolidays sorted by requested criterion
     */
    public List<RequestHoliday> getAllMine() {
        search.setUserRequest(authMgr.getCurrentPrincipal().getUser());
        return manager.getAllEntities(search, new SortCriteria(sortColumn, sortAscending));
    }

    /**
     * List requestHolidays. Order depends on Faces parameter sort.
     *
     * @return the list of all requestHolidays sorted by requested criterion
     */
    public List<RequestHoliday> getAll() {
        //return manager.getAllEntities(search, new SortCriteria(sortColumn, sortAscending) );
        return getAllMine();
    }

    /**
     * Método que se ejecuta antes de Save() y que cada implementación
     * podrá sobre escribir con funcionalidad adicional.
     *
     * @param result
     * @return
     */
    @Override
    public String doBeforeSave() {
        String result = super.doBeforeSave();

        if (result != null) {
            return result;
        }


        if (this.getBeginDate().after(this.getFinalDate())) {
            FacesUtils.addErrorMessage(null, "invalidRequestDateInterval");
            result = "invalidRequestDateInterval";
        }


        // Verificamos que no solicite más días de los que le quedan
        if (!this.validateHasEnoughAvaliableFreeHoliday()) {
            FacesUtils.addErrorMessage(null, "myHolidays.error.noHasEnoughAvaliableFreeHoliday");
            result = "notHasEnoughAvaliableFreeHoliday";
        }

        return result;
    }

    public boolean isAccepted() {
        return this.getState() == HolidayState.ACCEPT;
    }

}
