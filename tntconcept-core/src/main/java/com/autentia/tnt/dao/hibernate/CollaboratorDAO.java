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

package com.autentia.tnt.dao.hibernate;

import com.autentia.tnt.businessobject.*;
import com.autentia.tnt.dao.*;
import com.autentia.tnt.util.SpringUtils;

import java.util.*;
import org.apache.commons.logging.*;

/**
 * DAO for BulletinBoard objects.
 * @author stajanov code generator
 */
public class CollaboratorDAO extends HibernateManagerBase<Collaborator>
{
    /* collaborator - generated by stajanov (do not edit/delete) */



  /** Logger */
  private static final Log log = LogFactory.getLog(CollaboratorDAO.class);

  /**
   * Get default CollaboratorDAO as defined in Spring's configuration file.
   * @return the default singleton CollaboratorDAO
   */
  public static CollaboratorDAO getDefault()
  {
    return (CollaboratorDAO)SpringUtils.getSpringBean("daoCollaborator");
  }

 /** 
   * Constructor
   * @deprecated do not construct DAOs alone: use Spring's declared beans
   */
  public CollaboratorDAO(){
    super(false);
  }

  /** 
   * Retrieve a Collaborator object from database given its id
   * @param id primary key of Collaborator object
   * @return the Collaborator object identified by the id
   * @throws DataAccException on error
   */
  public Collaborator loadById(int id ) throws DataAccException {
    return super.loadByPk(Collaborator.class,id);
  }

    public Collaborator getById(int id ) throws DataAccException {
        return super.getByPk(Collaborator.class,id);
    }

  /** 
   * Get all Collaborator objects from database sorted by the given criteria
   * @param crit the sorting criteria
   * @return a list with all existing Collaborator objects
   * @throws DataAccException on error
   */
  public List<Collaborator> search( SortCriteria crit ) throws DataAccException {
    return super.list(Collaborator.class,crit);
  }

  /** 
   * Get specified Collaborator objects from database sorted by the given criteria
   * @param search search criteria
   * @param sort the sorting criteria
   * @return a list with Collaborator objects matching the search criteria
   * @throws DataAccException on error
   */
  public List<Collaborator> search(SearchCriteria search, SortCriteria sort) throws DataAccException {
    return super.search(Collaborator.class,search,sort);
  }

  /** 
   * Insert a new Collaborator object in database
   * @param dao the Collaborator object to insert
   * @throws DataAccException on error
   */
  public void insert(Collaborator dao) throws DataAccException {
    super.insert(dao);
  }

  /** 
   * Update an existing Collaborator object in database
   * @param dao the Collaborator object to update
   * @throws DataAccException on error
   */
  public void update(Collaborator dao) throws DataAccException {
    super.update(dao,dao.getId());
  }

  /** 
   * Delete an existing Collaborator object in database
   * @param dao the Collaborator object to update
   * @throws DataAccException on error
   */
  public void delete(Collaborator dao) throws DataAccException {
    super.delete(dao,dao.getId());
  }

/* collaborator - generated by stajanov (do not edit/delete) */
}