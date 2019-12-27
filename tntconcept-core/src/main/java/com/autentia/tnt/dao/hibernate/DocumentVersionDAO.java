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
public class DocumentVersionDAO extends HibernateManagerBase<DocumentVersion> 
{
/* documentVersion - generated by stajanov (do not edit/delete) */
  /** Logger */
  private static final Log log = LogFactory.getLog(DocumentVersionDAO.class);

  /**
   * Get default DocumentVersionDAO as defined in Spring's configuration file.
   * @return the default singleton DocumentVersionDAO
   */
  public static DocumentVersionDAO getDefault()
  {
    return (DocumentVersionDAO)SpringUtils.getSpringBean("daoDocumentVersion");
  }

 /** 
   * Constructor
   * @deprecated do not construct DAOs alone: use Spring's declared beans
   */
  public DocumentVersionDAO(){
    super(false);
  }

  /** 
   * Retrieve a DocumentVersion object from database given its id
   * @param id primary key of DocumentVersion object
   * @return the DocumentVersion object identified by the id
   * @throws DataAccException on error
   */
  public DocumentVersion loadById(int id ) throws DataAccException {
    return super.loadByPk(DocumentVersion.class,id);
  }

    public DocumentVersion getById(int id ) throws DataAccException {
        return super.getByPk(DocumentVersion.class,id);
    }

  /** 
   * Get all DocumentVersion objects from database sorted by the given criteria
   * @param crit the sorting criteria
   * @return a list with all existing DocumentVersion objects
   * @throws DataAccException on error
   */
  public List<DocumentVersion> search( SortCriteria crit ) throws DataAccException {
    return super.list(DocumentVersion.class,crit);
  }

  /** 
   * Get specified DocumentVersion objects from database sorted by the given criteria
   * @param search search criteria
   * @param sort the sorting criteria
   * @return a list with DocumentVersion objects matching the search criteria
   * @throws DataAccException on error
   */
  public List<DocumentVersion> search(SearchCriteria search, SortCriteria sort) throws DataAccException {
    return super.search(DocumentVersion.class,search,sort);
  }

  /** 
   * Insert a new DocumentVersion object in database
   * @param dao the DocumentVersion object to insert
   * @throws DataAccException on error
   */
  public void insert(DocumentVersion dao) throws DataAccException {
    super.insert(dao);
  }

  /** 
   * Update an existing DocumentVersion object in database
   * @param dao the DocumentVersion object to update
   * @throws DataAccException on error
   */
  public void update(DocumentVersion dao) throws DataAccException {
    super.update(dao,dao.getId());
  }

  /** 
   * Delete an existing DocumentVersion object in database
   * @param dao the DocumentVersion object to update
   * @throws DataAccException on error
   */
  public void delete(DocumentVersion dao) throws DataAccException {
    super.delete(dao,dao.getId());
  }
/* documentVersion - generated by stajanov (do not edit/delete) */

}
