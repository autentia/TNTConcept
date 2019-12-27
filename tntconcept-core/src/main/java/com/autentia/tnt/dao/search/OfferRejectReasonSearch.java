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


package com.autentia.tnt.dao.search;

import java.util.ArrayList;
import java.util.Date;

import com.autentia.tnt.dao.SearchCriteria;



public class OfferRejectReasonSearch extends SearchCriteria 
{

/* OfferRejectReason - generated by stajanov (do not edit/delete) */















  @Override
  public String getHQL() {
    StringBuilder ret = new StringBuilder();
    int iArgNum = 0;
            
    
  
        
    if( isTitleSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getTitle()==null ){
	ret.append( "title is NULL" );
      } else {
	ret.append( "title like :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isDescriptionSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getDescription()==null ){
	ret.append( "description is NULL" );
      } else {
	ret.append( "description = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isOwnerIdSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getOwnerId()==null ){
	ret.append( "ownerId is NULL" );
      } else {
	ret.append( "ownerId = :arg"+(iArgNum++) );
      }
    }

              
    
  
        
    if( isDepartmentIdSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getDepartmentId()==null ){
	ret.append( "departmentId is NULL" );
      } else {
	ret.append( "departmentId = :arg"+(iArgNum++) );
      }
    }

              
    
      if( isStartInsertDateSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( startInsertDate == null ){
        ret.append( "insertDate=:arg"+(iArgNum++) );
      } else {
        ret.append( "insertDate>=:arg"+(iArgNum++) );
      }
    }
    if( isEndInsertDateSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( endInsertDate == null ){
        ret.append( "insertDate=:arg"+(iArgNum++) );
      } else {
        ret.append( "insertDate<=:arg"+(iArgNum++) );
      }
    }

              
    
      if( isStartUpdateDateSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( startUpdateDate == null ){
        ret.append( "updateDate=:arg"+(iArgNum++) );
      } else {
        ret.append( "updateDate>=:arg"+(iArgNum++) );
      }
    }
    if( isEndUpdateDateSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( endUpdateDate == null ){
        ret.append( "updateDate=:arg"+(iArgNum++) );
      } else {
        ret.append( "updateDate<=:arg"+(iArgNum++) );
      }
    }

                      customGetHQL(ret,iArgNum);
    return ret.toString();
  }

  @Override
  public Object[] getArguments(){
    ArrayList<Object> ret = new ArrayList<Object>();
            
  
      if( isTitleSet() && getTitle()!=null ){
        ret.add( title );
    }

              
  
      if( isDescriptionSet() && getDescription()!=null ){
        ret.add( description );
    }

              
  
      if( isOwnerIdSet() && getOwnerId()!=null ){
        ret.add( ownerId );
    }

              
  
      if( isDepartmentIdSet() && getDepartmentId()!=null ){
        ret.add( departmentId );
    }

              
  
      if( isStartInsertDateSet() ){
        ret.add( startInsertDate );
    }
    if( isEndInsertDateSet() ){
        ret.add( endInsertDate );
    }

              
  
      if( isStartUpdateDateSet() ){
        ret.add( startUpdateDate );
    }
    if( isEndUpdateDateSet() ){
        ret.add( endUpdateDate );
    }

                      customGetArguments(ret);
    return ret.toArray();
  }

  @Override
  public void reset(){
            
  
      unsetTitle();
  
              
  
      unsetDescription();
  
              
  
      unsetOwnerId();
  
              
  
      unsetDepartmentId();
  
              
  
      unsetStartInsertDate();
    unsetEndInsertDate();

              
  
      unsetStartUpdateDate();
    unsetEndUpdateDate();

                      customReset();
  }
    
  @Override
  public String toString() {
    StringBuilder ret = new StringBuilder();
    ret.append("OfferRejectReasonSearch{");
            
  
  
          if( isTitleSet() ){
          ret.append( "(title" );
          ret.append( "="+title );
          ret.append( ")" );
      }

    
              
  
  
          if( isDescriptionSet() ){
          ret.append( "(description" );
          ret.append( "="+description );
          ret.append( ")" );
      }

    
              
  
  
          if( isOwnerIdSet() ){
          ret.append( "(ownerId" );
          ret.append( "="+ownerId );
          ret.append( ")" );
      }

    
              
  
  
          if( isDepartmentIdSet() ){
          ret.append( "(departmentId" );
          ret.append( "="+departmentId );
          ret.append( ")" );
      }

    
              
  
  
    if( isStartInsertDateSet() ){
        ret.append( "(startInsertDate" );
        ret.append( "="+startInsertDate );
        ret.append( ")" );
    }
    if( isEndInsertDateSet() ){
        ret.append( "(endInsertDate" );
        ret.append( "="+endInsertDate );
        ret.append( ")" );
    }

              
  
  
    if( isStartUpdateDateSet() ){
        ret.append( "(startUpdateDate" );
        ret.append( "="+startUpdateDate );
        ret.append( ")" );
    }
    if( isEndUpdateDateSet() ){
        ret.append( "(endUpdateDate" );
        ret.append( "="+endUpdateDate );
        ret.append( ")" );
    }

                      customToString(ret);
    ret.append("}");
    return ret.toString();
  }

  // Getters and setters
        
  
  
    
    
    public boolean isTitleSet(){
        return titleSet;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle( String title ){
        this.title = title;
        this.titleSet = true;
    }
    public void unsetTitle(){
        this.titleSet = false;
    }
          
  
  
    
    
    public boolean isDescriptionSet(){
        return descriptionSet;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription( String description ){
        this.description = description;
        this.descriptionSet = true;
    }
    public void unsetDescription(){
        this.descriptionSet = false;
    }
          
  
  
    
    
    public boolean isOwnerIdSet(){
        return ownerIdSet;
    }
    public Integer getOwnerId(){
        return ownerId;
    }
    public void setOwnerId( Integer ownerId ){
        this.ownerId = ownerId;
        this.ownerIdSet = true;
    }
    public void unsetOwnerId(){
        this.ownerIdSet = false;
    }
          
  
  
    
    
    public boolean isDepartmentIdSet(){
        return departmentIdSet;
    }
    public Integer getDepartmentId(){
        return departmentId;
    }
    public void setDepartmentId( Integer departmentId ){
        this.departmentId = departmentId;
        this.departmentIdSet = true;
    }
    public void unsetDepartmentId(){
        this.departmentIdSet = false;
    }
          
  
  
    public boolean isStartInsertDateSet(){
        return startInsertDateSet;
    }
    public Date getStartInsertDate(){
        return startInsertDate;
    }
    public void setStartInsertDate( Date startInsertDate ){
        this.startInsertDate = startInsertDate;
        this.startInsertDateSet = true;
    }
    public void unsetStartInsertDate(){
        this.startInsertDateSet = false;
    }
    public boolean isEndInsertDateSet(){
        return endInsertDateSet;
    }
    public Date getEndInsertDate(){
        return endInsertDate;
    }
    public void setEndInsertDate( Date endInsertDate ){
        this.endInsertDate = endInsertDate;
        this.endInsertDateSet = true;
    }
    public void unsetEndInsertDate(){
        this.endInsertDateSet = false;
    }

          
  
  
    public boolean isStartUpdateDateSet(){
        return startUpdateDateSet;
    }
    public Date getStartUpdateDate(){
        return startUpdateDate;
    }
    public void setStartUpdateDate( Date startUpdateDate ){
        this.startUpdateDate = startUpdateDate;
        this.startUpdateDateSet = true;
    }
    public void unsetStartUpdateDate(){
        this.startUpdateDateSet = false;
    }
    public boolean isEndUpdateDateSet(){
        return endUpdateDateSet;
    }
    public Date getEndUpdateDate(){
        return endUpdateDate;
    }
    public void setEndUpdateDate( Date endUpdateDate ){
        this.endUpdateDate = endUpdateDate;
        this.endUpdateDateSet = true;
    }
    public void unsetEndUpdateDate(){
        this.endUpdateDateSet = false;
    }

          
  // Fields
        
  
      private boolean titleSet;
        private String title;

          
  
      private boolean descriptionSet;
        private String description;

          
  
      private boolean ownerIdSet;
        private Integer ownerId;

          
  
      private boolean departmentIdSet;
        private Integer departmentId;

          
  
      private boolean startInsertDateSet;
        private Date startInsertDate;
    private boolean endInsertDateSet;
        private Date endInsertDate;

          
  
      private boolean startUpdateDateSet;
        private Date startUpdateDate;
    private boolean endUpdateDateSet;
        private Date endUpdateDate;

          
  // Returns if there are a search condition active
  public boolean isSearchActive() {
    return customIsSearchActive()||titleSet||descriptionSet||ownerIdSet||departmentIdSet||startInsertDateSet||endInsertDateSet||startUpdateDateSet||endUpdateDateSet;
  }


/* OfferRejectReason - generated by stajanov (do not edit/delete) */

  private void customGetHQL(StringBuilder ret, int iArgNum)
	{
	}

	private boolean customIsSearchActive()
	{
		return false;
	}

	private void customToString(StringBuilder ret)
	{
	}

	private void customReset()
	{
	}

	private void customGetArguments(ArrayList ret)
	{
	}
  
}
