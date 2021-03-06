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

package com.autentia.tnt.manager.holiday;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.autentia.tnt.businessobject.Holiday;
import com.autentia.tnt.dao.SortCriteria;
import com.autentia.tnt.dao.hibernate.HolidayDAO;
import com.autentia.tnt.dao.search.HolidaySearch;
import com.autentia.tnt.util.SpringUtils;




public class HolidayManager {


/* Holiday - generated by stajanov (do not edit/delete) */


  /** Logger */
  private static final Log log = LogFactory.getLog(HolidayManager.class);

  /** Holiday DAO **/
  private HolidayDAO holidayDAO;

  /**
   * Get default HolidayManager as defined in Spring's configuration file.
   * @return the default singleton HolidayManager
   */
  public static HolidayManager getDefault()
  {
    return (HolidayManager)SpringUtils.getSpringBean("managerHoliday");
  }

  /** 
   * Empty constructor needed by CGLIB (Spring AOP)
   */
  protected HolidayManager()
  {
  }
	
  /** 
   * Default constructor 
   * @deprecated do not construct managers alone: use Spring's declared beans
   */
  public HolidayManager( HolidayDAO holidayDAO )
  {
    this.holidayDAO = holidayDAO;
  }

  /**
   * List holidays. 
   * @param search search filter to apply
   * @param sort sorting criteria
   * @return the list of all holidays sorted by requested criterion
   */
  public List<Holiday> getAllEntities(HolidaySearch search, SortCriteria sort){
    return holidayDAO.search( search, sort );
  }
  
  /**
   * Get holiday by primary key.
   * @return holiday selected by id.
   */
  public Holiday getEntityById(int id){
    return holidayDAO.loadById(id);
  }
	
  /**
   * Insert holiday. 
   */
  public void insertEntity(Holiday holiday) {
    holidayDAO.insert(holiday);
  }
	 
  /**
   * Update holiday. 
   */
  public void updateEntity(Holiday holiday) {
    holidayDAO.update(holiday);
  }

  /**
   * Delete holiday. 
   */
  public void deleteEntity(Holiday holiday) {
    holidayDAO.delete(holiday);
  }
/* Holiday - generated by stajanov (do not edit/delete) */

	
}
