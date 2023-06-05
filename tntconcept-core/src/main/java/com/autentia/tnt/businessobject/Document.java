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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.autentia.tnt.dao.ITransferObject;

/**
 * Transfer object to store Contacts
 * 
 * @author stajanov code generator
 */
public class Document implements Serializable, ITransferObject {
/* document - generated by stajanov (do not edit/delete) */









  // Fields
  
  
    
  private Integer id;

      
      
  private Date creationDate;

      
      
  private String name;

      
      
  private String description;

      
      
  private Integer ownerId;

      
      
  private Integer departmentId;

      
      
  private Date insertDate;

      
      
  private Date updateDate;

            
              
  private Set<DocumentCategory> categories;

      
              
  private Set<DocumentVersion> versions;

    	 	

  // Setters and getters
  
  
  
  public Integer getId() {
    return id;
  }
  protected void setId( Integer id ) {
    this.id = id;
  }
      
  
  
  public Date getCreationDate() {
    return creationDate;
  }
  public void setCreationDate( Date creationDate ) {
    this.creationDate = creationDate;
  }
      
  
  
  public String getName() {
    return name;
  }
  public void setName( String name ) {
    this.name = name;
  }
      
  
  
  public String getDescription() {
    return description;
  }
  public void setDescription( String description ) {
    this.description = description;
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
  private void setInsertDate( Date insertDate ) {
    this.insertDate = insertDate;
  }
      
  
  
  public Date getUpdateDate() {
    return updateDate;
  }
  private void setUpdateDate( Date updateDate ) {
    this.updateDate = updateDate;
  }
            
            
  public Set<DocumentCategory> getCategories() {
    return categories;
  }
  public void setCategories( Set<DocumentCategory> categories ) {
    this.categories = categories;
  }
      
            
  public Set<DocumentVersion> getVersions() {
    return versions;
  }
  public void setVersions( Set<DocumentVersion> versions ) {
    this.versions = versions;
  }
    
      
      
      
    
  public boolean equals( Object that )
  {
  	try {
	  if (that == null) 
  		return false;
  	else 
    	return this.getId().equals( ((Document)that).getId() );
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
/* document - generated by stajanov (do not edit/delete) */

	String lastVersionDocumentPath = null;

	String lastVersionNumber = null;

	public String getLastVersionDocumentPath() {
		if (lastVersionDocumentPath == null) {
			updateLastVersionDocumentInfo();
		}
		return lastVersionDocumentPath;
	}

	public String getLastVersionNumber() {
		if (lastVersionNumber == null) {
			updateLastVersionDocumentInfo();
		}
		return lastVersionNumber;
	}

	private void updateLastVersionDocumentInfo() {
		if (this.getVersions() != null && !this.getVersions().isEmpty()) {
			Integer lastId = Integer.valueOf(-1);
			for (Iterator iter = this.getVersions().iterator(); iter.hasNext();) {
				DocumentVersion version = (DocumentVersion) iter.next();
				if (version.getId() > lastId) {
					this.lastVersionDocumentPath = version.getDocumentPath();
					this.lastVersionNumber = version.getVersion();
					lastId = version.getId();
				}
			}
		}
	}
	public List<Integer> getOwnersId() {
		// TODO Auto-generated method stub
		return null;
	}

}
