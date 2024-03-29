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

public class OfferCost implements Serializable, ITransferObject, TaxableObject {

	public static final int MAX_LENGTH = 4096;
	
	/* OfferCost - generated by stajanov (do not edit/delete) */

	private static final long serialVersionUID = 70564301864197707L;

	// Fields
	
	private Integer id;

	private String name;

	private BigDecimal cost;

	private BigDecimal iva;

	private boolean billable = true;

	private Integer ownerId;

	private Integer departmentId;

	private Date insertDate;

	private Date updateDate;

	private Offer offer;

	private BigDecimal units;

	  private Integer place = 1;

	
	// Setters and getters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public boolean isBillable() {
		return billable;
	}

	public void setBillable(boolean billable) {
		this.billable = billable;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
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

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public boolean equals(Object that) {
		try {
			if (that == null)
				return false;
			else
				return this.getId().equals(((OfferCost) that).getId());
		} catch (Exception e) {
			return false;
		}
	}

	public int hashCode() {
		if (this.getId() == null)
			return super.hashCode();
		else
			return this.getId().intValue();
	}

	/* OfferCost - generated by stajanov (do not edit/delete) */
	public BigDecimal getUnits() {
		return units;
	}

	public void setUnits(BigDecimal units) {
		this.units = units;
	}

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
