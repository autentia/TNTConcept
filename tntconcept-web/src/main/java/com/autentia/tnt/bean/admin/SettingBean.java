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

package com.autentia.tnt.bean.admin;

import java.math.*;
import java.util.*;

import javax.faces.model.*;

import org.apache.commons.logging.*;

import com.autentia.tnt.bean.*;
import com.autentia.tnt.businessobject.*;
import com.autentia.tnt.dao.*;
import com.autentia.tnt.dao.search.*;
import com.autentia.tnt.manager.admin.SettingManager;
import com.autentia.tnt.manager.security.AuthenticationManager;
import com.autentia.tnt.manager.security.Permission;
import com.autentia.tnt.upload.*;
import com.autentia.tnt.util.*;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import org.acegisecurity.acls.domain.BasePermission;


/**
 * UI bean for Setting objects.
 * @author stajanov code generator
 */
public class SettingBean extends BaseBean 
{
  /** Serial version field */
  private static final long serialVersionUID = -1L;
  
  
  private GeneralSettingsBean				mySettings				= new GeneralSettingsBean();
  
  /**
	 * @return
	 */
	public String saveSettings() {
		mySettings.save();
		// Show message to user
	    FacesUtils.addInfoMessage(null,"settings.saveOK");
		return null;
	}
  
	public GeneralSettingsBean getMySettings() {
		return mySettings;
	}

	public void setMySettings(GeneralSettingsBean mySettings) {
		this.mySettings = mySettings;
	}
	
	
	public boolean isWorkingHoursAvailable(){
		User actualUser = AuthenticationManager.getDefault().getCurrentPrincipal().getUser();
		
		return  actualUser.getRole().getId().equals(ConfigurationUtil.getDefault().getRoleAdminId());
			
	}
/* generated by stajanov (do not edit/delete) */


















  /** Logger */
  private static final Log log = LogFactory.getLog(SettingBean.class);

 /** Active search object */
  private SettingSearch search = new SettingSearch();

  /** Manager */
  private static SettingManager manager = SettingManager.getDefault();
  
  /** Upload service */
  private static final Uploader uploader = UploaderFactory.getInstance("setting");
    
                                                          
  /** Active Setting object */
  private Setting setting;
  
  /** Default sort column */
  private String sortColumn = "name";
    
  /** Default sort order */
  private boolean sortAscending = true;

      /** Quick search letter for ABC pager control */
    private Character letter;
  
  /**
   * List settings. Order depends on Faces parameter sort.
   * @return the list of all settings sorted by requested criterion
   */
  public List<Setting> getAll(){
    return manager.getAllEntities(search, new SortCriteria(sortColumn, sortAscending) );      
  }

  // Getters to list possible values of related entities
        
  // Getters to list possible values of enum fields
                        
  public String getTypeFormatted(){
    if(this.getType()!=null) {
      return FacesUtils.formatMessage("SettingType."+this.getType().name());
    } else {
      return "";
    }
  }

  /**
   * Get the list of all Type values
   * @return the list of all Type values
   */
  public List<SelectItem> getTypes(){
    ArrayList<SelectItem> ret = new ArrayList<SelectItem>();
    SettingType[] vals = SettingType.values();
    for( SettingType val : vals ){
      ret.add( new SelectItem( val, FacesUtils.formatMessage("SettingType."+val.name()) ) );
    }
    return ret;
  }
                              

  // Methods to create/remove instances of one-to-many entities (slave entities)
  
  /**
   * Whether or not create button is available for user
   * @return true if user can create objects of type Setting
   */
  public boolean isCreateAvailable()
  {
    return SpringUtils.isRolePermissionGranted(Permission.Entity_Create(Setting.class));
  }

  /**
   * Whether or not edit button is available for user
   * @return true if user can edit current object
   */
  public boolean isEditAvailable()
  {
    return SpringUtils.isAclPermissionGranted(setting,BasePermission.WRITE);
  }

  /**
   * Whether or not delete button is available for user
   * @return true if user can delete current object
   */
  public boolean isDeleteAvailable()
  {
    return (setting.getId()!=null) &&
	   SpringUtils.isAclPermissionGranted(setting,BasePermission.DELETE);
  }

  /**
   * Go to create page
   * @return forward to CREATE page
   */
  public String create(){
    setting = new Setting();
       
    return NavigationResults.CREATE;
  }

  /**
   * Go to detail page
   * @return forward to DETAIL page
   */
  public String detail(){
    Integer id = Integer.parseInt( FacesUtils.getRequestParameter(ROW_ID) );
    setting = manager.getEntityById(id);

    return SpringUtils.isAclPermissionGranted( setting, BasePermission.WRITE )
	    ? NavigationResults.EDIT
	    : NavigationResults.DETAIL;
  }

  /**
   * Save bean and stay on it
   * @return forward to list page
   */
  public String save(){
  
      doBeforeSave();
  
      if( setting.getId()==null ){
        manager.insertEntity(setting);
      } else {
        manager.updateEntity(setting);
      }
      

                                                                                                                      
      // Calls an after save action
      String result = doAfterSave(NavigationResults.LIST);

      // Unselect object
      setting = null;

      return result;
  }
    
  /**
   * Delete bean and go back to beans list
   * @return forward to LIST page
   */
  public String delete(){
    manager.deleteEntity(setting);
    setting = null;
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
  public boolean isSettingSelected(){
    return setting!=null;
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
  public SettingSearch getSearch(){
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
        
    
    
    
    
    public String getSearchValue(){
        return search.getValue();
    }
    public void setSearchValue( String val ){
        if( search.isValueSet() ) {
          search.setValue( val );
        }
    }
    public boolean isSearchValueValid(){
        return search.isValueSet();
    }
    public void setSearchValueValid( boolean val ){
        if( val ){
          search.setValue( search.getValue() );
        } else {
          search.unsetValue();
        }
    }
        
    
    
        
    
    public SettingType getSearchType(){
        return search.getType();
    }
    public void setSearchType( SettingType val ){
        if( search.isTypeSet() ) {
          search.setType( val );
        }
    }
    public boolean isSearchTypeValid(){
        return search.isTypeSet();
    }
    public void setSearchTypeValid( boolean val ){
        if( val ){
          search.setType( search.getType() );
        } else {
          search.unsetType();
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
      	UIComponent comp = FacesUtils.getComponent("settings:list");
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
                                                          
  // Getters and setters to manipulate active Setting object
  public java.lang.Integer getId() {
      return setting.getId();
  }
      
    
    
    public String getName() {
    return setting.getName();
  }
  public void setName( String name ) {
    setting.setName( name );
  }
        
    
    
    public String getValue() {
    return setting.getValue();
  }
  public void setValue( String value ) {
    setting.setValue( value );
  }
        
    
  
  
    public SettingType getType() {
    return setting.getType();
  }
  public void setType( SettingType type ) {
    setting.setType( type );
  }
        
    
    
    public Integer getOwnerId() {
    return setting.getOwnerId();
  }
  public void setOwnerId( Integer ownerId ) {
    setting.setOwnerId( ownerId );
  }
        
    
    
    public Integer getDepartmentId() {
    return setting.getDepartmentId();
  }
  public void setDepartmentId( Integer departmentId ) {
    setting.setDepartmentId( departmentId );
  }
        
    
    
    public Date getInsertDate() {
    return setting.getInsertDate();
  }

    public Date getUpdateDate() {
    return setting.getUpdateDate();
  }

/* generated by stajanov (do not edit/delete) */
}
