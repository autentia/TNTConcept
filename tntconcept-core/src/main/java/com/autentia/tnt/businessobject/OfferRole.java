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


package com.autentia.tnt.businessobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.autentia.tnt.dao.ITransferObject;


public class OfferRole implements Serializable, ITransferObject, TaxableObject 
{

	public static final int MAX_LENGTH = 4096;
	
/* OfferRole - generated by stajanov (do not edit/delete) */









  // Fields
  
  
    
  private Integer id;

      
      
  private String name;

      
      
  private BigDecimal costPerHour;

      
      
  private BigDecimal iva;

      
      
  private int expectedHours;

      
      
  private Integer ownerId;

      
      
  private Integer departmentId;

      
      
  private Date insertDate;

      
      
  private Date updateDate;

        
  
    
  private Offer offer;

  private Integer place = 1;


  // Setters and getters
  
  
  
  public Integer getId() {
    return id;
  }
  public void setId( Integer id ) {
    this.id = id;
  }
      
  
  
  public String getName() {
    return name;
  }
	public void setName(String name) {
		if (name != null && name.length() > MAX_LENGTH) {
			name = name.substring(0, MAX_LENGTH);
		}			
		this.name = name;
	}
      
  
  
  public BigDecimal getCostPerHour() {
    return costPerHour;
  }
  public void setCostPerHour( BigDecimal costPerHour ) {
    this.costPerHour = costPerHour;
  }
      
  
  
  public BigDecimal getIva() {
    return iva;
  }
  public void setIva( BigDecimal iva ) {
    this.iva = iva;
  }
      
  
  
  public int getExpectedHours() {
    return expectedHours;
  }
  public void setExpectedHours( int expectedHours ) {
    this.expectedHours = expectedHours;
  }
      
  
  
  public Integer getOwnerId() {
    return ownerId;
  }
  public void setOwnerId( Integer ownerId ) {
    this.ownerId = ownerId;
  }
      
  
  
  public Integer getDepartmentId() {
    return departmentId;
  }
  public void setDepartmentId( Integer departmentId ) {
    this.departmentId = departmentId;
  }
      
  
  
  public Date getInsertDate() {
    return insertDate;
  }
  private void setInsertDate(Date insertDate) {
    this.insertDate = insertDate;
  }
      
  
  
  public Date getUpdateDate() {
    return updateDate;
  }
  private void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }
        
  
  
  public Offer getOffer() {
    return offer;
  }
  public void setOffer( Offer offer ) {
    this.offer = offer;
  }
        
      
      
      
    
  public boolean equals( Object that )
  {
  	try {
	  if (that == null) 
  		return false;
  	else 
    	return this.getId().equals( ((OfferRole)that).getId() );
  	} catch (Exception e) {
		return false;
	}
  }
  
  public int hashCode() {
  	  if(this.getId()==null)
  	  	return super.hashCode();
  	  else	
	 	return this.getId().intValue();
	}
/* OfferRole - generated by stajanov (do not edit/delete) */
	public List<Integer> getOwnersId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPlace() {
		return place;
	}
	public void setPlace(Integer place) {
		this.place = place;
	}

}
