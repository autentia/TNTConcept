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
import java.util.Set;

import com.autentia.tnt.dao.ITransferObject;

/**
 * Transfer object to store ProjectRoles
 * @author stajanov code generator
 */
public class ProjectRole implements Serializable, ITransferObject 
{
  /** Serial version field */
  private static final long serialVersionUID = -1L;

/* projectRole - generated by stajanov (do not edit/delete) */









  // Fields
  
  
    
  private Integer id;

      
      
  private String name;

      
      
  private BigDecimal costPerHour;

      
      
  private int expectedHours;

      
      
  private Integer ownerId;

      
      
  private Integer departmentId;

      
      
  private Date insertDate;

      
      
  private Date updateDate;

  private Integer maxAllowed = 0;

  private Project project;

  private Set<Activity> activities;

  private RequireEvidenceType requireEvidence;

  private TimeUnitType timeUnit = TimeUnitType.MINUTES;

  private boolean isWorkingTime = true;

  private boolean isApprovalRequired = false;


    // Setters and getters
  
  
  
  public Integer getId() {
    return id;
  }

protected void setId( Integer id ) {
    this.id = id;
  }
      
  
  
  public String getName() {
    return name;
  }
  public void setName( String name ) {
    this.name = name;
  }
      
  
  
  public BigDecimal getCostPerHour() {
    return costPerHour;
  }
  public void setCostPerHour( BigDecimal costPerHour ) {
    this.costPerHour = costPerHour;
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
        
  
  
  public Project getProject() {
    return project;
  }
  public void setProject( Project project ) {
    this.project = project;
  }


    public TimeUnitType getTimeUnit() {
        return timeUnit;
    }
    public void setTimeUnit(TimeUnitType timeUnit) {
        this.timeUnit = timeUnit;
    }


    public boolean getIsWorkingTime() {return isWorkingTime;}
    public void setIsWorkingTime(boolean isWorkingTime) {this.isWorkingTime = isWorkingTime;}

    public boolean getIsApprovalRequired() {return isApprovalRequired;}
    public void setIsApprovalRequired(boolean isApprovalRequired) {this.isApprovalRequired = isApprovalRequired;}

    public Set<Activity> getActivities() {
		return activities;
	}
	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

    public RequireEvidenceType getRequireEvidence() {
        return requireEvidence;
    }

    public void setRequireEvidence(RequireEvidenceType requireEvidence) {
        this.requireEvidence = requireEvidence;
    }

    public boolean getRequiredEvidence(){
        return this.getRequireEvidence() != RequireEvidenceType.NO;
    }

  public boolean equals( Object that )
  {
  	try {
	  if (that == null) 
  		return false;
  	else 
    	return this.getId().equals( ((ProjectRole)that).getId() );
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
/* projectRole - generated by stajanov (do not edit/delete) */
	public List<Integer> getOwnersId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	public double getPercentageWorkedByRole(){
		double expected = this.getExpectedHours();
		double worked=0.0;
		
		if(this.getActivities()!=null){
			for (Activity activity : this.getActivities()){
				worked += (double)activity.getDuration()/60;
			}
		}
		if (worked == 0){
			return 0;
		} else if (expected == 0){
			return 1;
		} else {
			return worked/expected;
		}
		
	}
		
	public long getWorkedHoursByRole(){
		  long total = 0;
		  if (this.getActivities()!=null){
			  for (Activity activity : this.getActivities()){
						total += activity.getDuration();
				}
			
		  }	  
		  return total/60;		
	}

	public Integer getMaxAllowed() {
		return maxAllowed;
	}

	public void setMaxAllowed(Integer maxAllowed) {
		this.maxAllowed = maxAllowed;
	}
}
