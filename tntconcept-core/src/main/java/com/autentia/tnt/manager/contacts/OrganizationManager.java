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

package com.autentia.tnt.manager.contacts;

import com.autentia.tnt.businessobject.Contact;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.autentia.tnt.businessobject.Organization;
import com.autentia.tnt.businessobject.OrganizationType;
import com.autentia.tnt.dao.SortCriteria;
import com.autentia.tnt.dao.hibernate.ContactDAO;
import com.autentia.tnt.dao.hibernate.OrganizationDAO;
import com.autentia.tnt.dao.hibernate.OrganizationTypeDAO;
import com.autentia.tnt.dao.search.OrganizationSearch;
import com.autentia.tnt.tracking.EntityChange;
import com.autentia.tnt.tracking.hibernate.dao.EntityChangeDAO;
import com.autentia.tnt.util.ConfigurationUtil;
import com.autentia.tnt.util.SpringUtils;
import java.util.ArrayList;



public class OrganizationManager
{
	
/* Organization - generated by stajanov (do not edit/delete) */



  /** Logger */
  private static final Log log = LogFactory.getLog(OrganizationManager.class);

  /** Organization DAO **/
  private OrganizationDAO organizationDAO;
  
  private ContactDAO contactDAO;

	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

  /**
   * Get default OrganizationManager as defined in Spring's configuration file.
   * @return the default singleton OrganizationManager
   */
  public static OrganizationManager getDefault()
  {
    return (OrganizationManager)SpringUtils.getSpringBean("managerOrganization");
  }

  /** 
   * Empty constructor needed by CGLIB (Spring AOP)
   */
  protected OrganizationManager()
  {
  }
	
  /** 
   * Default constructor 
   * @deprecated do not construct managers alone: use Spring's declared beans
   */
  public OrganizationManager( OrganizationDAO organizationDAO )
  {
    this.organizationDAO = organizationDAO;
  }

  /**
   * List organizations. 
   * @param search search filter to apply
   * @param sort sorting criteria
   * @return the list of all organizations sorted by requested criterion
   */
  public List<Organization> getAllEntities(OrganizationSearch search, SortCriteria sort){
    return organizationDAO.search( search, sort );
  }
  
  /**
   * Get organization by primary key.
   * @return organization selected by id.
   */
  public Organization getEntityById(int id){
		final Organization organization = organizationDAO.loadById(id);
		organization.initChanges();
		return organization;
  }
	
  /**
   * Insert organization. 
   */
  public void insertEntity(Organization organization) {
    organizationDAO.insert(organization);
  }
	 
  /**
   * Update organization. 
   */
  public void updateEntity(Organization organization) {
    organizationDAO.update(organization);
    this.trackContactChanges(organization);
  }

  /**
   * Delete organization. 
   */
  public void deleteEntity(Organization organization) {
    organizationDAO.delete(organization);
  }

/* Organization - generated by stajanov (do not edit/delete) */
	
	public Organization getMyOrganization()
	{
		return organizationDAO.loadById(ConfigurationUtil.getDefault().getIdOurCompany());
	}
	
	
	public List<Organization> getProvidersAndClients()
	{
		OrganizationTypeDAO orgTypeDao = OrganizationTypeDAO.getDefault();
		
		OrganizationType provider = orgTypeDao.loadById(ConfigurationUtil.getDefault().getOrganizationTypeProvider());
		OrganizationType providerCient = orgTypeDao.loadById(ConfigurationUtil.getDefault().getOrganizationTypeProviderAndClient());
		
		List<Organization> lista = new ArrayList<Organization>();
		List<Organization> orgs = organizationDAO.searchByOrganizationTypes(new SortCriteria("name"), provider, providerCient );
		for(Organization org : orgs )
		{
			lista.add(org);
		}
		
		return lista;
	}
	
    private void trackContactChanges(Organization organization) {
        if (!organization.getName().equals(organization.getChanges().getName()))
        {
            final List<Contact> contacts = organizationDAO.getContactsForOrganization(organization);
            for (Contact contact : contacts) {
                contact.addEntityChange(Contact.FIELD_ORGANIZATION,
                        organization.getChanges().getName(), organization.getName(),organization.getId().toString());
                contactDAO.update(contact);
            }
        }
    }
}
