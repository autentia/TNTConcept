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

package com.autentia.tnt.bean.contacts;

import java.util.Date;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.autentia.tnt.bean.BaseBean;
import com.autentia.tnt.bean.NavigationResults;
import com.autentia.tnt.businessobject.OrganizationISOCategory;
import com.autentia.tnt.dao.SortCriteria;
import com.autentia.tnt.dao.search.OrganizationISOCategorySearch;
import com.autentia.tnt.manager.contacts.OrganizationISOCategoryManager;
import com.autentia.tnt.manager.security.Permission;
import com.autentia.tnt.upload.Uploader;
import com.autentia.tnt.upload.UploaderFactory;
import com.autentia.tnt.util.FacesUtils;
import com.autentia.tnt.util.SpringUtils;

import org.acegisecurity.acls.domain.BasePermission;


public class OrganizationISOCategoryBean extends BaseBean {


/* OrganizationISOCategory - generated by stajanov (do not edit/delete) */


















  /** Logger */
  private static final Log log = LogFactory.getLog(OrganizationISOCategoryBean.class);

 /** Active search object */
  private OrganizationISOCategorySearch search = new OrganizationISOCategorySearch();

  /** Manager */
  private static OrganizationISOCategoryManager manager = OrganizationISOCategoryManager.getDefault();
  
  /** Upload service */
  private static final Uploader uploader = UploaderFactory.getInstance("organizationISOCategory");
    
                                                  
  /** Active OrganizationISOCategory object */
  private OrganizationISOCategory organizationISOCategory;
  
  /** Default sort column */
  private String sortColumn = "name";
    
  /** Default sort order */
  private boolean sortAscending = false;

      /** Quick search letter for ABC pager control */
    private Character letter;
  
  /**
   * List organizationISOCategorys. Order depends on Faces parameter sort.
   * @return the list of all organizationISOCategorys sorted by requested criterion
   */
  public List<OrganizationISOCategory> getAll(){
    return manager.getAllEntities(search, new SortCriteria(sortColumn, sortAscending) );      
  }

  // Getters to list possible values of related entities
        
  // Getters to list possible values of enum fields
                                      

  // Methods to create/remove instances of one-to-many entities (slave entities)
  
  /**
   * Whether or not create button is available for user
   * @return true if user can create objects of type OrganizationISOCategory
   */
  public boolean isCreateAvailable()
  {
    return SpringUtils.isRolePermissionGranted(Permission.Entity_Create(OrganizationISOCategory.class));
  }

  /**
   * Whether or not edit button is available for user
   * @return true if user can edit current object
   */
  public boolean isEditAvailable()
  {
    return SpringUtils.isAclPermissionGranted(organizationISOCategory,BasePermission.WRITE);
  }

  /**
   * Whether or not delete button is available for user
   * @return true if user can delete current object
   */
  public boolean isDeleteAvailable()
  {
    return (organizationISOCategory.getId()!=null) &&
	   SpringUtils.isAclPermissionGranted(organizationISOCategory,BasePermission.DELETE);
  }

  /**
   * Go to create page
   * @return forward to CREATE page
   */
  public String create(){
    organizationISOCategory = new OrganizationISOCategory();
       
    return NavigationResults.CREATE;
  }

  /**
   * Go to detail page
   * @return forward to DETAIL page
   */
  public String detail(){
    Integer id = Integer.parseInt( FacesUtils.getRequestParameter(ROW_ID) );
    organizationISOCategory = manager.getEntityById(id);

    return SpringUtils.isAclPermissionGranted( organizationISOCategory, BasePermission.WRITE )
	    ? NavigationResults.EDIT
	    : NavigationResults.DETAIL;
  }

  /**
   * Save bean and stay on it
   * @return forward to list page
   */
  public String save(){
  
      doBeforeSave();
  
      if( organizationISOCategory.getId()==null ){
        manager.insertEntity(organizationISOCategory);
      } else {
        manager.updateEntity(organizationISOCategory);
      }
      

                                                                                                      
      // Calls an after save action
      String result = doAfterSave(NavigationResults.LIST);

      // Unselect object
      organizationISOCategory = null;

      return result;
  }
    
  /**
   * Delete bean and go back to beans list
   * @return forward to LIST page
   */
  public String delete(){
    manager.deleteEntity(organizationISOCategory);
    organizationISOCategory = null;
    return NavigationResults.LIST;
  }

  /**
   * Go back to beans list
   * @return forward to LIST page
   */
  public String list(){
    return NavigationResults.LIST;
  }

  /**
   * Reset search criteria
   * @return forward to LIST page
   */
  public String reset(){
  	search.reset();
	return list();    
  }

  /**
   * Go to search page
   * @return forward to SEARCH page
   */
  public String search(){
    return NavigationResults.SEARCH;
  }

  /** 
   * Check if we have an active object.
   * @return true is an object is selected
   */
  public boolean isOrganizationISOCategorySelected(){
    return organizationISOCategory!=null;
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
  public OrganizationISOCategorySearch getSearch(){
    return search;
  }
      
    
    
    
    
    public String getSearchName(){
        return search.getName();
    }
    public void setSearchName( String val ){
        if( search.isNameSet() ) {
          search.setName( val );
        }
    }
    public boolean isSearchNameValid(){
        return search.isNameSet();
    }
    public void setSearchNameValid( boolean val ){
        if( val ){
          search.setName( search.getName() );
        } else {
          search.unsetName();
        }
    }
        
    
    
    
    
    public String getSearchDescription(){
        return search.getDescription();
    }
    public void setSearchDescription( String val ){
        if( search.isDescriptionSet() ) {
          search.setDescription( val );
        }
    }
    public boolean isSearchDescriptionValid(){
        return search.isDescriptionSet();
    }
    public void setSearchDescriptionValid( boolean val ){
        if( val ){
          search.setDescription( search.getDescription() );
        } else {
          search.unsetDescription();
        }
    }
        
    
    
    
    
    public Integer getSearchOwnerId(){
        return search.getOwnerId();
    }
    public void setSearchOwnerId( Integer val ){
        if( search.isOwnerIdSet() ) {
          search.setOwnerId( val );
        }
    }
    public boolean isSearchOwnerIdValid(){
        return search.isOwnerIdSet();
    }
    public void setSearchOwnerIdValid( boolean val ){
        if( val ){
          search.setOwnerId( search.getOwnerId() );
        } else {
          search.unsetOwnerId();
        }
    }
        
    
    
    
    
    public Integer getSearchDepartmentId(){
        return search.getDepartmentId();
    }
    public void setSearchDepartmentId( Integer val ){
        if( search.isDepartmentIdSet() ) {
          search.setDepartmentId( val );
        }
    }
    public boolean isSearchDepartmentIdValid(){
        return search.isDepartmentIdSet();
    }
    public void setSearchDepartmentIdValid( boolean val ){
        if( val ){
          search.setDepartmentId( search.getDepartmentId() );
        } else {
          search.unsetDepartmentId();
        }
    }
        
    
        
      
    public Date getSearchStartInsertDate(){
        return search.getStartInsertDate();
    }
    public void setSearchStartInsertDate( Date val ){
        if( val!=null ){
          search.setStartInsertDate( val );
        } else {
          search.unsetStartInsertDate();
        }
    }
    public boolean isSearchStartInsertDateValid(){
        return search.isStartInsertDateSet();
    }
    public void setSearchStartInsertDateValid( boolean val ){
        if( val ){
          search.setStartInsertDate( search.getStartInsertDate() );
        } else {
          search.unsetStartInsertDate();
        }
    }
    public Date getSearchEndInsertDate(){
        return search.getEndInsertDate();
    }
    public void setSearchEndInsertDate( Date val ){
        if( val!=null ){
          search.setEndInsertDate( val );
        } else {
          search.unsetEndInsertDate();
        }
    }
    public boolean isSearchEndInsertDateValid(){
        return search.isEndInsertDateSet();
    }
    public void setSearchEndInsertDateValid( boolean val ){
        if( val ){
          search.setEndInsertDate( search.getEndInsertDate() );
        } else {
          search.unsetEndInsertDate();
        }
    }

        
    
        
      
    public Date getSearchStartUpdateDate(){
        return search.getStartUpdateDate();
    }
    public void setSearchStartUpdateDate( Date val ){
        if( val!=null ){
          search.setStartUpdateDate( val );
        } else {
          search.unsetStartUpdateDate();
        }
    }
    public boolean isSearchStartUpdateDateValid(){
        return search.isStartUpdateDateSet();
    }
    public void setSearchStartUpdateDateValid( boolean val ){
        if( val ){
          search.setStartUpdateDate( search.getStartUpdateDate() );
        } else {
          search.unsetStartUpdateDate();
        }
    }
    public Date getSearchEndUpdateDate(){
        return search.getEndUpdateDate();
    }
    public void setSearchEndUpdateDate( Date val ){
        if( val!=null ){
          search.setEndUpdateDate( val );
        } else {
          search.unsetEndUpdateDate();
        }
    }
    public boolean isSearchEndUpdateDateValid(){
        return search.isEndUpdateDateSet();
    }
    public void setSearchEndUpdateDateValid( boolean val ){
        if( val ){
          search.setEndUpdateDate( search.getEndUpdateDate() );
        } else {
          search.unsetEndUpdateDate();
        }
    }

          
      /** Handle an ABC pager letter click: filter objects by specified starting letter */
    public void letterClicked()
    {
      if( letter!=null ){
      	UIComponent comp = FacesUtils.getComponent("organizationISOCategorys:list");
        HtmlDataTable tabla = (HtmlDataTable) comp;
        tabla.setFirst(0);
      	
        search.setName( letter+"%" );
      } else {
        search.unsetName();
      }
    }

    public Character getLetter()
    {
      return letter;
    }

    public void setLetter( Character letter )
    {
      this.letter = letter;
    }
  
  // Getters and setters to handle uploads
                                                  
  // Getters and setters to manipulate active OrganizationISOCategory object
  public java.lang.Integer getId() {
      return organizationISOCategory.getId();
  }
      
    
    
    public String getName() {
    return organizationISOCategory.getName();
  }
  public void setName( String name ) {
    organizationISOCategory.setName( name );
  }
        
    
    
    public String getDescription() {
    return organizationISOCategory.getDescription();
  }
  public void setDescription( String description ) {
    organizationISOCategory.setDescription( description );
  }
        
    
    
    public Integer getOwnerId() {
    return organizationISOCategory.getOwnerId();
  }
  public void setOwnerId( Integer ownerId ) {
    organizationISOCategory.setOwnerId( ownerId );
  }
        
    
    
    public Integer getDepartmentId() {
    return organizationISOCategory.getDepartmentId();
  }
  public void setDepartmentId( Integer departmentId ) {
    organizationISOCategory.setDepartmentId( departmentId );
  }
        
    
    
    public Date getInsertDate() {
    return organizationISOCategory.getInsertDate();
  }

    public Date getUpdateDate() {
    return organizationISOCategory.getUpdateDate();
  }
          
/* OrganizationISOCategory - generated by stajanov (do not edit/delete) */
}
