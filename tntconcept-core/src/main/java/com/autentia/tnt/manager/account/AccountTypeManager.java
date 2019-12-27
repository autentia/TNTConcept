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

package com.autentia.tnt.manager.account;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.autentia.tnt.businessobject.AccountType;
import com.autentia.tnt.dao.SortCriteria;
import com.autentia.tnt.dao.hibernate.AccountTypeDAO;
import com.autentia.tnt.dao.search.AccountTypeSearch;
import com.autentia.tnt.util.SpringUtils;



public class AccountTypeManager 
{
/* generated by stajanov (do not edit/delete) */


  /** Logger */
  private static final Log log = LogFactory.getLog(AccountTypeManager.class);

  /** AccountType DAO **/
  private AccountTypeDAO accountTypeDAO;

  /**
   * Get default AccountTypeManager as defined in Spring's configuration file.
   * @return the default singleton AccountTypeManager
   */
  public static AccountTypeManager getDefault()
  {
    return (AccountTypeManager)SpringUtils.getSpringBean("managerAccountType");
  }

  /** 
   * Empty constructor needed by CGLIB (Spring AOP)
   */
  protected AccountTypeManager()
  {
  }
	
  /** 
   * Default constructor 
   * @deprecated do not construct managers alone: use Spring's declared beans
   */
  public AccountTypeManager( AccountTypeDAO accountTypeDAO )
  {
    this.accountTypeDAO = accountTypeDAO;
  }

  /**
   * List accountTypes. 
   * @param search search filter to apply
   * @param sort sorting criteria
   * @return the list of all accountTypes sorted by requested criterion
   */
  public List<AccountType> getAllEntities(AccountTypeSearch search, SortCriteria sort){
    return accountTypeDAO.search( search, sort );
  }
  
  /**
   * Get accountType by primary key.
   * @return accountType selected by id.
   */
  public AccountType getEntityById(int id){
    return accountTypeDAO.loadById(id);
  }
	
  /**
   * Insert accountType. 
   */
  public void insertEntity(AccountType accountType) {
    accountTypeDAO.insert(accountType);
  }
	 
  /**
   * Update accountType. 
   */
  public void updateEntity(AccountType accountType) {
    accountTypeDAO.update(accountType);
  }

  /**
   * Delete accountType. 
   */
  public void deleteEntity(AccountType accountType) {
    accountTypeDAO.delete(accountType);
  }
/* generated by stajanov (do not edit/delete) */
}
