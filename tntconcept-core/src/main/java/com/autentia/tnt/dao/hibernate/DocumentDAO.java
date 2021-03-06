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
import com.autentia.tnt.util.ConfigurationUtil;
import com.autentia.tnt.util.FileUtil;
import com.autentia.tnt.util.SpringUtils;

import java.io.File;
import java.io.Serializable;
import java.util.*;
import org.apache.commons.logging.*;

/**
 * DAO for BulletinBoard objects.
 * @author stajanov code generator
 */
public class DocumentDAO extends HibernateManagerBase<Document> 
{
/* document - generated by stajanov (do not edit/delete) */
  /** Logger */
  private static final Log log = LogFactory.getLog(DocumentDAO.class);

  /**
   * Get default DocumentDAO as defined in Spring's configuration file.
   * @return the default singleton DocumentDAO
   */
  public static DocumentDAO getDefault()
  {
    return (DocumentDAO)SpringUtils.getSpringBean("daoDocument");
  }

 /** 
   * Constructor
   * @deprecated do not construct DAOs alone: use Spring's declared beans
   */
  public DocumentDAO(){
    super(false);
  }

  /** 
   * Retrieve a Document object from database given its id
   * @param id primary key of Document object
   * @return the Document object identified by the id
   * @throws DataAccException on error
   */
  public Document loadById(int id ) throws DataAccException {
    return super.loadByPk(Document.class,id);
  }

    public Document getById(int id ) throws DataAccException {
        return super.getByPk(Document.class,id);
    }

  /** 
   * Get all Document objects from database sorted by the given criteria
   * @param crit the sorting criteria
   * @return a list with all existing Document objects
   * @throws DataAccException on error
   */
  public List<Document> search( SortCriteria crit ) throws DataAccException {
    return super.list(Document.class,crit);
  }

  /** 
   * Get specified Document objects from database sorted by the given criteria
   * @param search search criteria
   * @param sort the sorting criteria
   * @return a list with Document objects matching the search criteria
   * @throws DataAccException on error
   */
  public List<Document> search(SearchCriteria search, SortCriteria sort) throws DataAccException {
    return super.search(Document.class,search,sort);
  }

  /** 
   * Insert a new Document object in database
   * @param dao the Document object to insert
   * @throws DataAccException on error
   */
  public void insert(Document dao) throws DataAccException {
    super.insert(dao);    
  }

  /** 
   * Update an existing Document object in database
   * @param dao the Document object to update
   * @throws DataAccException on error
   */
  public void update(Document dao) throws DataAccException {
	  super.update(dao,dao.getId());    
  }
  
  public Document updateAndRet(Document dao) throws DataAccException {
	    return (Document) super.updateAndReturn(dao,dao.getId());    
  }

  /** 
   * Delete an existing Document object in database
   * @param dao the Document object to update
   * @throws DataAccException on error
   */
  public void delete(Document dao) throws DataAccException {
    super.delete(dao,dao.getId());
  }
/* document - generated by stajanov (do not edit/delete) */

  public void doAfterDelete(Serializable pk) throws DataAccException {
	// Deletes the files
	if (pk!=null) {
		Integer id = (Integer) pk;
		String filePath = ConfigurationUtil.getDefault().getUploadPath() + "document"
							+ File.separator + id + File.separator;
		FileUtil.deleteTree(new File(filePath));
	}
  }

}
