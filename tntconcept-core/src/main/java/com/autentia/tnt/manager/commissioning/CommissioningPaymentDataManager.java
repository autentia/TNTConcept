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

package com.autentia.tnt.manager.commissioning;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.autentia.tnt.businessobject.CommissioningPaymentData;
import com.autentia.tnt.dao.SortCriteria;
import com.autentia.tnt.dao.hibernate.CommissioningPaymentDataDAO;
import com.autentia.tnt.dao.search.CommissioningPaymentDataSearch;
import com.autentia.tnt.util.SpringUtils;

/* CreditTitle - generated by stajanov (do not edit/delete) */


public class CommissioningPaymentDataManager {
  /** Logger */
  private static final Log log = LogFactory.getLog(CommissioningPaymentDataManager.class);

  /** CommissioningPaymentData DAO **/
  private CommissioningPaymentDataDAO commissioningPaymentDataDAO;

  /**
   * Get default CommissioningPaymentDataManager as defined in Spring's configuration file.
   * @return the default singleton CommissioningPaymentDataManager
   */
  public static CommissioningPaymentDataManager getDefault()
  {
    return (CommissioningPaymentDataManager)SpringUtils.getSpringBean("managerCommissioningPaymentData");
  }

  /** 
   * Empty constructor needed by CGLIB (Spring AOP)
   */
  protected CommissioningPaymentDataManager()
  {
  }
	
  /** 
   * Default constructor 
   * @deprecated do not construct managers alone: use Spring's declared beans
   */
  public CommissioningPaymentDataManager( CommissioningPaymentDataDAO commissioningPaymentDataDAO )
  {
    this.commissioningPaymentDataDAO = commissioningPaymentDataDAO;
  }

  /**
   * List commissioningPaymentDatas. 
   * @param search search filter to apply
   * @param sort sorting criteria
   * @return the list of all commissioningPaymentDatas sorted by requested criterion
   */
  public List<CommissioningPaymentData> getAllEntities(CommissioningPaymentDataSearch search, SortCriteria sort){
    return commissioningPaymentDataDAO.search( search, sort );
  }
  
  /**
   * Get commissioningPaymentData by primary key.
   * @return commissioningPaymentData selected by id.
   */
  public CommissioningPaymentData getEntityById(int id){
    return commissioningPaymentDataDAO.loadById(id);
  }
	
  /**
   * Insert commissioningPaymentData. 
   */
  public void insertEntity(CommissioningPaymentData commissioningPaymentData) {
    commissioningPaymentDataDAO.insert(commissioningPaymentData);
  }
	 
  /**
   * Update commissioningPaymentData. 
   */
  public void updateEntity(CommissioningPaymentData commissioningPaymentData) {
    commissioningPaymentDataDAO.update(commissioningPaymentData);
  }

  /**
   * Delete commissioningPaymentData. 
   */
  public void deleteEntity(CommissioningPaymentData commissioningPaymentData) {
    commissioningPaymentDataDAO.delete(commissioningPaymentData);
  }

/* CreditTitle - generated by stajanov (do not edit/delete) */
}