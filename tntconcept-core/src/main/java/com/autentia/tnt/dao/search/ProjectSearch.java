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

import java.util.*;
import java.math.*;

import org.hibernate.type.*;

import com.autentia.tnt.businessobject.*;
import com.autentia.tnt.dao.*;

/**
 * Class to search for Project objects
 * 
 * @author stajanov code generator
 */
public class ProjectSearch extends SearchCriteria {
  /* generated by stajanov (do not edit/delete) */

  @Override
  public String getHQL() {
    StringBuilder ret = new StringBuilder();
    int iArgNum = 0;

    if (isStartStartDateSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (startStartDate == null) {
        ret.append("startDate=:arg" + (iArgNum++));
      } else {
        ret.append("startDate>=:arg" + (iArgNum++));
      }
    }
    if (isEndStartDateSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (endStartDate == null) {
        ret.append("startDate=:arg" + (iArgNum++));
      } else {
        ret.append("startDate<=:arg" + (iArgNum++));
      }
    }

    if (isStartEndDateSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (startEndDate == null) {
        ret.append("endDate=:arg" + (iArgNum++));
      } else {
        ret.append("endDate>=:arg" + (iArgNum++));
      }
    }
    if (isEndEndDateSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (endEndDate == null) {
        ret.append("endDate=:arg" + (iArgNum++));
      } else {
        ret.append("endDate<=:arg" + (iArgNum++));
      }
    }

    if (isOpenSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (getOpen() == null) {
        ret.append("open is NULL");
      } else {
        ret.append("open = :arg" + (iArgNum++));
      }
    }

    if (isNameSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (getName() == null) {
        ret.append("name is NULL");
      } else {
        ret.append("name like :arg" + (iArgNum++));
      }
    }

    if (isDescriptionSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (getDescription() == null) {
        ret.append("description is NULL");
      } else {
        ret.append("description = :arg" + (iArgNum++));
      }
    }


    if( isBillingTypeSet() ){
        ret.append( (ret.length()==0) ? "WHERE " : " AND " );
        if( getBillingType()==null ){
            ret.append( "billingType is NULL" );
        } else {
            ret.append( "billingType = :arg"+(iArgNum++) );
        }
    }
              

        
    if( isOwnerIdSet() ){
      ret.append( (ret.length()==0) ? "WHERE " : " AND " );
      if( getOwnerId()==null ){
        ret.append( "ownerId is NULL" );
      } else {
        ret.append("ownerId = :arg" + (iArgNum++));
      }
    }

    if (isDepartmentIdSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (getDepartmentId() == null) {
        ret.append("departmentId is NULL");
      } else {
        ret.append("departmentId = :arg" + (iArgNum++));
      }
    }

    if (isStartInsertDateSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (startInsertDate == null) {
        ret.append("insertDate=:arg" + (iArgNum++));
      } else {
        ret.append("insertDate>=:arg" + (iArgNum++));
      }
    }
    if (isEndInsertDateSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (endInsertDate == null) {
        ret.append("insertDate=:arg" + (iArgNum++));
      } else {
        ret.append("insertDate<=:arg" + (iArgNum++));
      }
    }

    if (isStartUpdateDateSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (startUpdateDate == null) {
        ret.append("updateDate=:arg" + (iArgNum++));
      } else {
        ret.append("updateDate>=:arg" + (iArgNum++));
      }
    }
    if (isEndUpdateDateSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (endUpdateDate == null) {
        ret.append("updateDate=:arg" + (iArgNum++));
      } else {
        ret.append("updateDate<=:arg" + (iArgNum++));
      }
    }

    if (isClientSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (getClient() == null) {
        ret.append("client is NULL");
      } else {
        ret.append("client = :arg" + (iArgNum++));
      }
    }

    if (isOfferSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (getOffer() == null) {
        ret.append("offer is NULL");
      } else {
        ret.append("offer = :arg" + (iArgNum++));
      }
    }

    if (isOrderSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (getOrder() == null) {
        ret.append("order is NULL");
      } else {
        ret.append("order like :arg" + (iArgNum++));

      }
    }

    if (isEstimatedCostSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      if (getEstimatedCost() == null) {
        ret.append("estimated cost is NULL");
      } else {
        ret.append("estimated cost = :arg" + (iArgNum++));
      }
    }

    if (isRolesSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      ret.append("roles.id IN (:arg" + (iArgNum++) + ")");
    }

    if (isCostsSet()) {
      ret.append((ret.length() == 0) ? "WHERE " : " AND ");
      ret.append("costs.id IN (:arg" + (iArgNum++) + ")");
    }

    customGetHQL(ret, iArgNum);
    return ret.toString();
  }

  @Override
  public Object[] getArguments() {
    ArrayList<Object> ret = new ArrayList<Object>();

    if (isStartStartDateSet()) {
      ret.add(startStartDate);
    }
    if (isEndStartDateSet()) {
      ret.add(endStartDate);
    }

    if (isStartEndDateSet()) {
      ret.add(startEndDate);
    }
    if (isEndEndDateSet()) {
      ret.add(endEndDate);
    }

    if (isOpenSet() && getOpen() != null) {
      ret.add(open);
    }

    if (isNameSet() && getName() != null) {
      ret.add(name);
    }

    if (isDescriptionSet() && getDescription() != null) {
      ret.add(description);
    }

    if( isBillingTypeSet() && getBillingType()!=null ){
          ret.add( billingType );
    }
  
    if( isOwnerIdSet() && getOwnerId()!=null ){
        ret.add( ownerId );
    }

    if (isDepartmentIdSet() && getDepartmentId() != null) {
      ret.add(departmentId);
    }

    if (isStartInsertDateSet()) {
      ret.add(startInsertDate);
    }
    if (isEndInsertDateSet()) {
      ret.add(endInsertDate);
    }

    if (isStartUpdateDateSet()) {
      ret.add(startUpdateDate);
    }
    if (isEndUpdateDateSet()) {
      ret.add(endUpdateDate);
    }

    if (isClientSet() && getClient() != null) {
      ret.add(client);
    }

    if (isOfferSet() && getOffer() != null) {
      ret.add(offer);
    }

    if (isOrderSet() && getOrder() != null) {
      ret.add(order);
    }

      if (isEstimatedCostSet() && getEstimatedCost() != null) {
        ret.add(estimatedCost);
      }

      if (isRolesSet()) {
        List<Integer> params = new ArrayList<Integer>();
        for (ITransferObject to : roles) {
          params.add(to.getId());
        }
        ret.add(params);
      }

      if (isCostsSet()) {
        List<Integer> params = new ArrayList<Integer>();
        for (ITransferObject to : costs) {
          params.add(to.getId());
        }
        ret.add(params);
      }

      customGetArguments(ret);
      return ret.toArray();
    }

  @Override
  public void reset() {

    unsetStartStartDate();
    unsetEndStartDate();

    unsetStartEndDate();
    unsetEndEndDate();

              
  
      unsetOpen();
  
              
  
      unsetName();
  
              
  
      unsetDescription();
  

  
      unsetBillingType();
  
              
  
      unsetOwnerId();
  
              
  
      unsetDepartmentId();
  
              
  
      unsetStartInsertDate();
    unsetEndInsertDate();

    unsetStartUpdateDate();
    unsetEndUpdateDate();

    unsetClient();

    unsetOffer();

    unsetOrder();

    unsetEstimatedCost();

    unsetRoles();

    unsetCosts();

    customReset();
  }

  @Override
  public String toString() {
    StringBuilder ret = new StringBuilder();
    ret.append("ProjectSearch{");

    if (isStartStartDateSet()) {
      ret.append("(startStartDate");
      ret.append("=" + startStartDate);
      ret.append(")");
    }
    if (isEndStartDateSet()) {
      ret.append("(endStartDate");
      ret.append("=" + endStartDate);
      ret.append(")");
    }

    if (isStartEndDateSet()) {
      ret.append("(startEndDate");
      ret.append("=" + startEndDate);
      ret.append(")");
    }
    if (isEndEndDateSet()) {
      ret.append("(endEndDate");
      ret.append("=" + endEndDate);
      ret.append(")");
    }

              
  
  
          if( isOpenSet() ){
          ret.append( "(open" );
          ret.append( "="+open );
          ret.append( ")" );
      }

    
              
  
  
          if( isNameSet() ){
          ret.append( "(name" );
          ret.append( "="+name );
          ret.append( ")" );
      }

    
              
  
  
          if( isDescriptionSet() ){
          ret.append( "(description" );
          ret.append( "="+description );
          ret.append( ")" );
      }

    
              
  
          if( isBillingTypeSet() ){
          ret.append( "(billingType" );
          ret.append( "="+billingType );
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

    if (isNameSet()) {
      ret.append("(name");
      ret.append("=" + name);
      ret.append(")");
    }

    if (isDescriptionSet()) {
      ret.append("(description");
      ret.append("=" + description);
      ret.append(")");
    }

    if (isOwnerIdSet()) {
      ret.append("(ownerId");
      ret.append("=" + ownerId);
      ret.append(")");
    }

    if (isDepartmentIdSet()) {
      ret.append("(departmentId");
      ret.append("=" + departmentId);
      ret.append(")");
    }

    if (isStartInsertDateSet()) {
      ret.append("(startInsertDate");
      ret.append("=" + startInsertDate);
      ret.append(")");
    }
    if (isEndInsertDateSet()) {
      ret.append("(endInsertDate");
      ret.append("=" + endInsertDate);
      ret.append(")");
    }

    if (isStartUpdateDateSet()) {
      ret.append("(startUpdateDate");
      ret.append("=" + startUpdateDate);
      ret.append(")");
    }
    if (isEndUpdateDateSet()) {
      ret.append("(endUpdateDate");
      ret.append("=" + endUpdateDate);
      ret.append(")");
    }

    if (isClientSet()) {
      ret.append("(client");
      ret.append("=" + client);
      ret.append(")");
    }

    if (isOfferSet()) {
      ret.append("(offer");
      ret.append("=" + offer);
      ret.append(")");
    }

    if (isOrderSet()) {
      ret.append("(order");
      ret.append("=" + order);
    }

    if (isEstimatedCostSet()) {
      ret.append("(estimated cost");
      ret.append("=" + estimatedCost);
      ret.append(")");
    }

    if (isRolesSet()) {
      ret.append("(roles={");
      for (Object o : roles.toArray()) {
        ret.append("," + o);
      }
      ret.append("})");
    }

    if (isCostsSet()) {
      ret.append("(costs={");
      for (Object o : costs.toArray()) {
        ret.append("," + o);
      }
      ret.append("})");
    }

    customToString(ret);
    ret.append("}");
    return ret.toString();
  }

  // Getters and setters

  public boolean isStartStartDateSet() {
    return startStartDateSet;
  }

  public Date getStartStartDate() {
    return startStartDate;
  }

  public void setStartStartDate(Date startStartDate) {
    this.startStartDate = startStartDate;
    this.startStartDateSet = true;
  }

  public void unsetStartStartDate() {
    this.startStartDateSet = false;
  }

  public boolean isEndStartDateSet() {
    return endStartDateSet;
  }

  public Date getEndStartDate() {
    return endStartDate;
  }

  public void setEndStartDate(Date endStartDate) {
    this.endStartDate = endStartDate;
    this.endStartDateSet = true;
  }

  public void unsetEndStartDate() {
    this.endStartDateSet = false;
  }

  public boolean isStartEndDateSet() {
    return startEndDateSet;
  }

  public Date getStartEndDate() {
    return startEndDate;
  }

  public void setStartEndDate(Date startEndDate) {
    this.startEndDate = startEndDate;
    this.startEndDateSet = true;
  }

  public void unsetStartEndDate() {
    this.startEndDateSet = false;
  }

  public boolean isEndEndDateSet() {
    return endEndDateSet;
  }

  public Date getEndEndDate() {
    return endEndDate;
  }

  public void setEndEndDate(Date endEndDate) {
    this.endEndDate = endEndDate;
    this.endEndDateSet = true;
  }

  public void unsetEndEndDate() {
    this.endEndDateSet = false;
  }

  public boolean isOpenSet() {
    return openSet;
  }

  public Boolean getOpen() {
    return open;
  }

  public void setOpen(Boolean open) {
    this.open = open;
    this.openSet = true;
  }

  public void unsetOpen() {
    this.openSet = false;
  }

  public boolean isNameSet() {
    return nameSet;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    this.nameSet = true;
  }

  public void unsetName() {
    this.nameSet = false;
  }

  public boolean isDescriptionSet() {
    return descriptionSet;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
    this.descriptionSet = true;
  }

  public void unsetDescription() {
    this.descriptionSet = false;
  }

  public boolean isBillingTypeSet(){
    return billingTypeSet;
  }
  public BillingType getBillingType(){
      return billingType;
  }
  public void setBillingType( BillingType billingType ){
      this.billingType = billingType;
      this.billingTypeSet = true;
  }
  public void unsetBillingType(){
      this.billingTypeSet = false;
  }

  public boolean isOwnerIdSet() {
    return ownerIdSet;
  }

  public Integer getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Integer ownerId) {
    this.ownerId = ownerId;
    this.ownerIdSet = true;
  }

  public void unsetOwnerId() {
    this.ownerIdSet = false;
  }

  public boolean isDepartmentIdSet() {
    return departmentIdSet;
  }

  public Integer getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Integer departmentId) {
    this.departmentId = departmentId;
    this.departmentIdSet = true;
  }

  public void unsetDepartmentId() {
    this.departmentIdSet = false;
  }

  public boolean isStartInsertDateSet() {
    return startInsertDateSet;
  }

  public Date getStartInsertDate() {
    return startInsertDate;
  }

  public void setStartInsertDate(Date startInsertDate) {
    this.startInsertDate = startInsertDate;
    this.startInsertDateSet = true;
  }

  public void unsetStartInsertDate() {
    this.startInsertDateSet = false;
  }

  public boolean isEndInsertDateSet() {
    return endInsertDateSet;
  }

  public Date getEndInsertDate() {
    return endInsertDate;
  }

  public void setEndInsertDate(Date endInsertDate) {
    this.endInsertDate = endInsertDate;
    this.endInsertDateSet = true;
  }

  public void unsetEndInsertDate() {
    this.endInsertDateSet = false;
  }

  public boolean isStartUpdateDateSet() {
    return startUpdateDateSet;
  }

  public Date getStartUpdateDate() {
    return startUpdateDate;
  }

  public void setStartUpdateDate(Date startUpdateDate) {
    this.startUpdateDate = startUpdateDate;
    this.startUpdateDateSet = true;
  }

  public void unsetStartUpdateDate() {
    this.startUpdateDateSet = false;
  }

  public boolean isEndUpdateDateSet() {
    return endUpdateDateSet;
  }

  public Date getEndUpdateDate() {
    return endUpdateDate;
  }

  public void setEndUpdateDate(Date endUpdateDate) {
    this.endUpdateDate = endUpdateDate;
    this.endUpdateDateSet = true;
  }

  public void unsetEndUpdateDate() {
    this.endUpdateDateSet = false;
  }

  public boolean isClientSet() {
    return clientSet;
  }

  public Organization getClient() {
    return client;
  }

  public void setClient(Organization client) {
    this.client = client;
    this.clientSet = true;
  }

  public void unsetClient() {
    this.clientSet = false;
  }

  public boolean isOfferSet() {
    return offerSet;
  }

  public Offer getOffer() {
    return offer;
  }

  public void setOffer(Offer offer) {
    this.offer = offer;
    this.offerSet = true;
  }

  public void unsetOffer() {
    this.offerSet = false;
  }

  public boolean isOrderSet() {
    return orderSet;
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
    this.orderSet = true;
  }

  public void unsetOrder() {
    this.orderSet = false;
  }

  public boolean isEstimatedCostSet() {
    return estimatedCostSet;
  }

  public BigDecimal getEstimatedCost() {
    return estimatedCost;
  }

  public void setEstimatedCost(BigDecimal estimatedCost) {
    this.estimatedCost = estimatedCost;
    this.estimatedCostSet = true;
  }

  public void unsetEstimatedCost() {
    this.estimatedCostSet = false;
  }

  public boolean isRolesSet() {
    return rolesSet;
  }

  public List<ProjectRole> getRoles() {
    return roles;
  }

  public void setRoles(List<ProjectRole> roles) {
    this.roles = roles;
    this.rolesSet = true;
  }

  public void unsetRoles() {
    this.rolesSet = false;
  }

  public boolean isCostsSet() {
    return costsSet;
  }

  public List<ProjectCost> getCosts() {
    return costs;
  }

  public void setCosts(List<ProjectCost> costs) {
    this.costs = costs;
    this.costsSet = true;
  }

  public void unsetCosts() {
    this.costsSet = false;
  }

  // Fields

  private boolean startStartDateSet;
  private Date startStartDate;
  private boolean endStartDateSet;
  private Date endStartDate;

  private boolean startEndDateSet;
  private Date startEndDate;
  private boolean endEndDateSet;
  private Date endEndDate;

  private boolean openSet;
  private Boolean open;

  private boolean nameSet;
  private String name;

  private boolean descriptionSet;
  private String description;

  private boolean billingTypeSet;
  private BillingType billingType;

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

  private boolean clientSet;
  private Organization client;

  private boolean offerSet;
  private Offer offer;

  private boolean orderSet;
  private String order;

  private boolean estimatedCostSet;
  private BigDecimal estimatedCost;

  private boolean rolesSet;
  private List<ProjectRole> roles;

  private boolean costsSet;
  private List<ProjectCost> costs;
      
  
  // Returns if there are a search condition active
  public boolean isSearchActive() {
    return customIsSearchActive() || startStartDateSet || endStartDateSet || startEndDateSet || endEndDateSet || openSet
        || nameSet || descriptionSet || ownerIdSet || departmentIdSet || startInsertDateSet
        || endInsertDateSet || startUpdateDateSet || endUpdateDateSet || clientSet || rolesSet || costsSet || offerSet
        || estimatedCostSet || orderSet || billingTypeSet;
  }

  /* generated by stajanov (do not edit/delete) */

  private void customGetHQL(StringBuilder ret, int iArgNum) {
  }

  private boolean customIsSearchActive() {
    return false;
  }

  private void customToString(StringBuilder ret) {
  }

  private void customReset() {
  }

  private void customGetArguments(ArrayList ret) {
  }
}
