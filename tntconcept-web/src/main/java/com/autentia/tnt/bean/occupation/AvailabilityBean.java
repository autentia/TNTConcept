/**
 * TNTConcept Easy Enterprise Management by Autentia Real Bussiness Solution S.L.
 * Copyright (C) 2007 Autentia Real Bussiness Solution S.L.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.autentia.tnt.bean.occupation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.autentia.jsf.component.ocupation.OcupationModel;
import com.autentia.tnt.bean.BaseBean;
import com.autentia.tnt.businessobject.Holiday;
import com.autentia.tnt.businessobject.HolidayState;
import com.autentia.tnt.businessobject.Occupation;
import com.autentia.tnt.businessobject.RequestHoliday;
import com.autentia.tnt.businessobject.User;
import com.autentia.tnt.dao.SortCriteria;
import com.autentia.tnt.dao.search.HolidaySearch;
import com.autentia.tnt.dao.search.OccupationSearch;
import com.autentia.tnt.dao.search.RequestHolidaySearch;
import com.autentia.tnt.dao.search.UserSearch;
import com.autentia.tnt.manager.activity.OccupationManager;
import com.autentia.tnt.manager.admin.UserManager;
import com.autentia.tnt.manager.holiday.HolidayManager;
import com.autentia.tnt.manager.holiday.RequestHolidayManager;
import com.autentia.tnt.util.DateUtils;
import com.autentia.tnt.util.FacesUtils;

public class AvailabilityBean extends BaseBean {

	private static final long serialVersionUID = 1L;
	private final UserManager userMgr = UserManager.getDefault();
	private Date selectedDate = null;

	public AvailabilityBean() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());

		cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
		cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));

		selectedDate = cal.getTime();
	}

	public List<Availability> getAll() {

		List<Availability> ret = new ArrayList<Availability>();

		UserSearch searchUser = new UserSearch();
		searchUser.setActive(true);
		SortCriteria sCriteria = new SortCriteria("name");

		List<User> users = userMgr.getAllEntities(searchUser, sCriteria);

		for (User user : users) {

			OcupationModelImpl model = new OcupationModelImpl();

			Availability availability = new Availability();
			availability.setUser(user);
			availability.setModel(model);

			fillModelHolidays(user, model);
			fillAvailability(user, model);
			ret.add(availability);

		}

		return ret;
	}

	private void fillAvailability(User user, OcupationModel model) {
		Calendar calendarFirstDayOfMonth = Calendar.getInstance();
		Calendar calendarLastDayOfMonth = Calendar.getInstance();
		
		Date firstDayOfMonth = DateUtils.getFirstDayOfMonth(selectedDate);
		Date lastDayOfMonth = DateUtils.getLastDayOfMonth(selectedDate);
		
		calendarFirstDayOfMonth.setTime(firstDayOfMonth);
		calendarLastDayOfMonth.setTime(lastDayOfMonth);

		calendarFirstDayOfMonth.add(Calendar.MONTH, -1);
		calendarLastDayOfMonth.add(Calendar.MONTH, 1);

		OccupationManager ocManager = OccupationManager.getDefault();
		OccupationSearch ocSearch = new OccupationSearch();
		ocSearch.setStartOccupationDate(calendarFirstDayOfMonth.getTime());
		ocSearch.setEndOccupationDate(calendarLastDayOfMonth.getTime());
		ocSearch.setUser(user);

		for (Occupation oc : ocManager.getAllEntities(ocSearch, null)) {
			OcupationEntryImpl oce = new OcupationEntryImpl();
			oce.setStart(DateUtils.minHourInDate(oc.getStartDate()));
			oce.setEnd(DateUtils.maxHourInDate(oc.getEndDate()));
			oce.setVacances(false);
			oce.setDescription(oc.getProject().getName() + "(" + oc.getProject().getClient().getName() + "). "
					+ oc.getDescription());
			oce.setDuration(oc.getDuration());
			model.addOcupationEntry(oce);
		}
	}

	/**
	 * Fill holidays in listOccupations for that user.
	 * 
	 * @param user
	 * @param model
	 */

	private void fillModelHolidays(User user, OcupationModel model) {
		Calendar calendarFirstDayOfMonth = Calendar.getInstance();
		Calendar calendarLastDayOfMonth = Calendar.getInstance();

		Date firstDayOfMonth = DateUtils.getFirstDayOfMonth(selectedDate);
		Date lastDayOfMonth = DateUtils.getLastDayOfMonth(selectedDate);
		
		calendarFirstDayOfMonth.setTime(firstDayOfMonth);
		calendarLastDayOfMonth.setTime(lastDayOfMonth);

		calendarFirstDayOfMonth.add(Calendar.MONTH, -1);
		calendarLastDayOfMonth.add(Calendar.MONTH, 1);

		RequestHolidayManager rhManager = RequestHolidayManager.getDefault();
		RequestHolidaySearch rhSearch = new RequestHolidaySearch();
		rhSearch.setUserRequest(user);
		rhSearch.setState(HolidayState.ACCEPT);
		rhSearch.setStartBeginDate(calendarFirstDayOfMonth.getTime());
		rhSearch.setEndBeginDate(calendarLastDayOfMonth.getTime());
		rhSearch.setStartFinalDate(calendarFirstDayOfMonth.getTime());
		rhSearch.setEndFinalDate(calendarLastDayOfMonth.getTime());

		List<RequestHoliday> listH = rhManager.getAllEntities(rhSearch, null);

		for (RequestHoliday rH : listH) {
			OcupationEntryImpl oc = new OcupationEntryImpl();
			oc.setStart(DateUtils.minHourInDate(rH.getBeginDate()));
			oc.setEnd(DateUtils.maxHourInDate(rH.getFinalDate()));
			oc.setVacances(true);
			oc.setHoliday(false);
			oc.setDescription(FacesUtils.getMessage("activity.acceptedHolidays"));
			model.addOcupationEntry(oc);
		}

		HolidaySearch monthSearch = new HolidaySearch();
		HolidayManager holidayManager = HolidayManager.getDefault();

		monthSearch.setStartDate(calendarFirstDayOfMonth.getTime());
		monthSearch.setEndDate(calendarLastDayOfMonth.getTime());

		List<Holiday> allHolidays = holidayManager.getAllEntities(monthSearch, null);

		for (Holiday holiday : allHolidays) {
			OcupationEntryImpl oc = new OcupationEntryImpl();
			oc.setStart(DateUtils.minHourInDate(holiday.getDate()));
			oc.setEnd(DateUtils.maxHourInDate(holiday.getDate()));
			oc.setVacances(false);
			oc.setHoliday(true);
			oc.setDescription(holiday.getDescription());

			model.addOcupationEntry(oc);
		}
	}

	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}

}