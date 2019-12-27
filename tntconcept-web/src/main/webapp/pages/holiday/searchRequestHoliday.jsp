<%--

    TNTConcept Easy Enterprise Management by Autentia Real Bussiness Solution S.L.
    Copyright (C) 2007 Autentia Real Bussiness Solution S.L.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

--%>

<%-- 
 * TNTConcept Easy Enterprise Management by Autentia Real Bussiness Solution S.L.  
 *	Copyright (C) 2007 Autentia Real Bussiness Solution S.L.					   
 *	
 * 	This program is free software; you can redistribute it and/or
 * 	modify it under the terms of the GNU General Public License
 * 	as published by the Free Software Foundation; either version 2
 * 	of the License, or (at your option) any later version.
 *
 * 	This program is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 * 	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * 	GNU General Public License for more details.
 *
 * 	You should have received a copy of the GNU General Public License
 * 	along with this program; if not, write to the Free Software
 * 	Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 * 	Autentia Real Bussiness Solution S.L.
 * 	Tlf: +34 91 675 33 06, +34 655 99 11 72
 * 	Fax: +34 91 656 65 04
 * 	info@autentia.com																
 *
 --%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/inc/tlibs.jsp" %>

<html>
  <head>
    <%@include file="/inc/uiCore.jsp" %>
  </head>	
  <body>
    
    <!-- searchRequestHoliday.jsp: generated by stajanov code generator -->
    <f:loadBundle basename="com.autentia.tnt.resources.messages" var="msg" />
    <i:location place="searchRequestHoliday" msg="${msg}"/> 
    
    <f:view>
      <%@include file="/inc/header.jsp" %>
      <h:form id="search" enctype="multipart/form-data">
        
        <%-- Header --%>
        <i:titleBar msg="${msg}">
          <h:commandLink action="#{requestHolidayBean.list}">
            <h:graphicImage title="#{msg.entityActions_run}"  value="/img/run.png" styleClass="titleImg" />
          </h:commandLink>
        </i:titleBar>
        
        <%-- Search form --%>
        <table class="searchTable" cellpadding="0" cellspacing="0">

          
      <%-- Ignored field: id --%>

                        
      <%-- Field: beginDate --%>
    <tr>
      <td class="searchLabel">${msg['requestHoliday.beginDate']}:</td>
      <td class="searchFieldCell">

        
                    
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="startBeginDate" />
            <h:selectBooleanCheckbox id="startBeginDateValid" value="#{requestHolidayBean.searchStartBeginDateValid}" 
                                      onclick="setEnabled('search:startBeginDate',this.checked)"/>
            <t:inputCalendar id="startBeginDate" value="#{requestHolidayBean.searchStartBeginDate}"
                             renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true" 
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             onchange="setEnabled('search:startBeginDate',true);setChecked('search:startBeginDateValid',true);"
                             />
          </h:panelGroup>
          -
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="endBeginDate" />
            <h:selectBooleanCheckbox id="endBeginDateValid" value="#{requestHolidayBean.searchEndBeginDateValid}" 
                                      onclick="setEnabled('search:endBeginDate',this.checked)"/>
            <t:inputCalendar id="endBeginDate" value="#{requestHolidayBean.searchEndBeginDate}"
                             renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true" 
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             onchange="setEnabled('search:endBeginDate',true);setChecked('search:endBeginDateValid',true);"
                             />
          </h:panelGroup>
          <script>
            setEnabled( 'search:startBeginDate', ${requestHolidayBean.searchStartBeginDateValid} )
            setEnabled( 'search:endBeginDate', ${requestHolidayBean.searchEndBeginDateValid} )
          </script>

        
      </td>
    </tr>
                        
      <%-- Field: finalDate --%>
    <tr>
      <td class="searchLabel">${msg['requestHoliday.finalDate']}:</td>
      <td class="searchFieldCell">

        
                    
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="startFinalDate" />
            <h:selectBooleanCheckbox id="startFinalDateValid" value="#{requestHolidayBean.searchStartFinalDateValid}" 
                                      onclick="setEnabled('search:startFinalDate',this.checked)"/>
            <t:inputCalendar id="startFinalDate" value="#{requestHolidayBean.searchStartFinalDate}"
                             renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true" 
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             onchange="setEnabled('search:startFinalDate',true);setChecked('search:startFinalDateValid',true);"
                             />
          </h:panelGroup>
          -
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="endFinalDate" />
            <h:selectBooleanCheckbox id="endFinalDateValid" value="#{requestHolidayBean.searchEndFinalDateValid}" 
                                      onclick="setEnabled('search:endFinalDate',this.checked)"/>
            <t:inputCalendar id="endFinalDate" value="#{requestHolidayBean.searchEndFinalDate}"
                             renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true" 
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             onchange="setEnabled('search:endFinalDate',true);setChecked('search:endFinalDateValid',true);"
                             />
          </h:panelGroup>
          <script>
            setEnabled( 'search:startFinalDate', ${requestHolidayBean.searchStartFinalDateValid} )
            setEnabled( 'search:endFinalDate', ${requestHolidayBean.searchEndFinalDateValid} )
          </script>

        
      </td>
    </tr>
                        
      <%-- Field: state --%>
    <tr>
      <td class="searchLabel">${msg['requestHoliday.state']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="state" />
            <h:selectBooleanCheckbox id="stateValid" value="#{requestHolidayBean.searchStateValid}" 
                                      onclick="setEnabled('search:state',this.checked)"/>
            <h:selectOneMenu id="state" value="#{requestHolidayBean.searchState}" onclick="setEnabled('search:state',true)">
              <f:converter converterId="autentia.EnumConverter"/>
              <f:selectItems value="#{requestHolidayBean.states}" />
            </h:selectOneMenu>
          </h:panelGroup>
          <script>
            setEnabled( 'search:state', ${requestHolidayBean.searchStateValid} )
          </script>

        
      </td>
    </tr>
                        
      <%-- Field: userComment --%>
    <tr>
      <td class="searchLabel">${msg['requestHoliday.userComment']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="userComment" />
            <h:selectBooleanCheckbox id="userCommentValid" value="#{requestHolidayBean.searchUserCommentValid}" 
                                      onclick="setEnabled('search:userComment',this.checked)"/>
            <h:inputText id="userComment" value="#{requestHolidayBean.searchUserComment}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:userComment', ${requestHolidayBean.searchUserCommentValid} )
          </script>

        
      </td>
    </tr>
                        
      <%-- Field: observations --%>
    <tr>
      <td class="searchLabel">${msg['requestHoliday.observations']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="observations" />
            <h:selectBooleanCheckbox id="observationsValid" value="#{requestHolidayBean.searchObservationsValid}" 
                                      onclick="setEnabled('search:observations',this.checked)"/>
            <h:inputText id="observations" value="#{requestHolidayBean.searchObservations}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:observations', ${requestHolidayBean.searchObservationsValid} )
          </script>

        
      </td>
    </tr>
                        
      <%-- Field: chargeYear --%>
    <tr>
      <td class="searchLabel">${msg['requestHoliday.chargeYear']}:</td>
      <td class="searchFieldCell">

        
                    
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="startChargeYear" />
            <h:selectBooleanCheckbox id="startChargeYearValid" value="#{requestHolidayBean.searchStartChargeYearValid}" 
                                      onclick="setEnabled('search:startChargeYear',this.checked)"/>
            <t:inputCalendar id="startChargeYear" value="#{requestHolidayBean.searchStartChargeYear}"
                             renderAsPopup="true" popupDateFormat="yyyy" renderPopupButtonAsImage="true" 
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             onchange="setEnabled('search:startChargeYear',true);setChecked('search:startChargeYearValid',true);"
                             />
          </h:panelGroup>
          -
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="endChargeYear" />
            <h:selectBooleanCheckbox id="endChargeYearValid" value="#{requestHolidayBean.searchEndChargeYearValid}" 
                                      onclick="setEnabled('search:endChargeYear',this.checked)"/>
            <t:inputCalendar id="endChargeYear" value="#{requestHolidayBean.searchEndChargeYear}"
                             renderAsPopup="true" popupDateFormat="yyyy" renderPopupButtonAsImage="true" 
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             onchange="setEnabled('search:endChargeYear',true);setChecked('search:endChargeYearValid',true);"
                             />
          </h:panelGroup>
          <script>
            setEnabled( 'search:startChargeYear', ${requestHolidayBean.searchStartChargeYearValid} )
            setEnabled( 'search:endChargeYear', ${requestHolidayBean.searchEndChargeYearValid} )
          </script>

        
      </td>
    </tr>
                        
      <%-- Ignored field: departmentId --%>

                        
      <%-- Ignored field: insertDate --%>

                        
      <%-- Ignored field: updateDate --%>

                                  
      <%-- Ignored field: userRequest --%>

                                
        </table>
        
      </h:form>
    </f:view>
    
  </body>
</html>  		
