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

<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%@include file="/inc/tlibs.jsp" %>

<html>
  <head>
    <%@include file="/inc/uiCore.jsp" %>
  </head>	
  <body>
    
    <!-- searchBill.jsp: generated by stajanov code generator -->
    <f:loadBundle basename="com.autentia.tnt.resources.messages" var="msg" />
    <i:location place="searchBill" msg="${msg}"/> 
    
    <f:view>
        <%@include file="/inc/header.jsp" %>
      <h:form id="search" enctype="multipart/form-data">
        
        
        
        <%-- Header --%>
        <i:titleBar msg="${msg}">
          <h:commandLink action="#{billBean.list}">
            <h:graphicImage title="#{msg.entityActions_run}"  value="/img/run.png" styleClass="titleImg" />
          </h:commandLink>
        </i:titleBar>
        
        <%-- Search form --%>
        <table class="searchTable" cellpadding="0" cellspacing="0">

          
      <%-- Ignored field: id --%>

                        
      <%-- Field: creationDate --%>
    <tr>
      <td class="searchLabel">${msg['bill.creationDate']}:</td>
      <td class="searchFieldCell">

        
                    
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="startCreationDate" />
            <h:selectBooleanCheckbox id="startCreationDateValid" value="#{billBean.searchStartCreationDateValid}" 
                                      onclick="setEnabled('search:startCreationDate',this.checked)"/>
            <t:inputCalendar id="startCreationDate" value="#{billBean.searchStartCreationDate}"
                             renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true" 
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             onchange="setEnabled('search:startCreationDate',true);setChecked('search:startCreationDateValid',true);"
                             >
				<f:validator validatorId="autentia.dateValidator"/>
			</t:inputCalendar>
          </h:panelGroup>
          -
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="endCreationDate" />
            <h:selectBooleanCheckbox id="endCreationDateValid" value="#{billBean.searchEndCreationDateValid}" 
                                      onclick="setEnabled('search:endCreationDate',this.checked)"/>
            <t:inputCalendar id="endCreationDate" value="#{billBean.searchEndCreationDate}"
                             renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true" 
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             onchange="setEnabled('search:endCreationDate',true);setChecked('search:endCreationDateValid',true);"
                             >
				<f:validator validatorId="autentia.dateValidator"/>
			</t:inputCalendar>
          </h:panelGroup>
          <script>
            setEnabled( 'search:startCreationDate', ${billBean.searchStartCreationDateValid} )
            setEnabled( 'search:endCreationDate', ${billBean.searchEndCreationDateValid} )
          </script>

        
      </td>
    </tr>
          <%-- Field: startBillDate --%>
    <tr>
      <td class="searchLabel">${msg['bill.startBillDate']}:</td>
      <td class="searchFieldCell">

        
                    
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="startStartBillDate" />
            <h:selectBooleanCheckbox id="startStartBillDateValid" value="#{billBean.searchStartStartBillDateValid}" 
                                      onclick="setEnabled('search:startStartBillDate',this.checked)"/>
            <t:inputCalendar id="startStartBillDate" value="#{billBean.searchStartStartBillDate}"
                             renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true" 
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             onchange="setEnabled('search:startStartBillDate',true);setChecked('search:startStartBillDateValid',true);"
                             >
				<f:validator validatorId="autentia.dateValidator"/>
			</t:inputCalendar>
          </h:panelGroup>
          -
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="endStartBillDate" />
            <h:selectBooleanCheckbox id="endStartBillDateValid" value="#{billBean.searchEndStartBillDateValid}" 
                                      onclick="setEnabled('search:endStartBillDate',this.checked)"/>
            <t:inputCalendar id="endStartBillDate" value="#{billBean.searchEndStartBillDate}"
                             renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true" 
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             onchange="setEnabled('search:endStartBillDate',true);setChecked('search:endStartBillDateValid',true);"
                             >
				<f:validator validatorId="autentia.dateValidator"/>
			</t:inputCalendar>
          </h:panelGroup>
          <script>
            setEnabled( 'search:startStartBillDate', ${billBean.searchStartStartBillDateValid} )
            setEnabled( 'search:endStartBillDate', ${billBean.searchEndStartBillDateValid} )
          </script>

        
      </td>
    </tr>
                        
      <%-- Field: endBillDate --%>
    <tr>
      <td class="searchLabel">${msg['bill.endBillDate']}:</td>
      <td class="searchFieldCell">

        
                    
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="startEndBillDate" />
            <h:selectBooleanCheckbox id="startEndBillDateValid" value="#{billBean.searchStartEndBillDateValid}" 
                                      onclick="setEnabled('search:startEndBillDate',this.checked)"/>
            <t:inputCalendar id="startEndBillDate" value="#{billBean.searchStartEndBillDate}"
                             renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true" 
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             onchange="setEnabled('search:startEndBillDate',true);setChecked('search:startEndBillDateValid',true);"
                             >
				<f:validator validatorId="autentia.dateValidator"/>
			</t:inputCalendar>
          </h:panelGroup>
          -
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="endEndBillDate" />
            <h:selectBooleanCheckbox id="endEndBillDateValid" value="#{billBean.searchEndEndBillDateValid}" 
                                      onclick="setEnabled('search:endEndBillDate',this.checked)"/>
            <t:inputCalendar id="endEndBillDate" value="#{billBean.searchEndEndBillDate}"
                             renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true" 
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             onchange="setEnabled('search:endEndBillDate',true);setChecked('search:endEndBillDateValid',true);"
                             >
				<f:validator validatorId="autentia.dateValidator"/>
			</t:inputCalendar>
          </h:panelGroup>
          <script>
            setEnabled( 'search:startEndBillDate', ${billBean.searchStartEndBillDateValid} )
            setEnabled( 'search:endEndBillDate', ${billBean.searchEndEndBillDateValid} )
          </script>

        
      </td>
    </tr>              
      <%-- Field: expiration --%>
    <tr>
      <td class="searchLabel">${msg['bill.expiration']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="startExpiration" />
            <h:selectBooleanCheckbox id="startExpirationValid" value="#{billBean.searchStartExpirationValid}" 
                                      onclick="setEnabled('search:startExpiration',this.checked)"/>
            <t:inputCalendar id="startExpiration" value="#{billBean.searchStartExpiration}"
                             renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true" 
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             onchange="setEnabled('search:startExpiration',true);setChecked('search:startExpirationValid',true);"
                             >                                      
				<f:validator validatorId="autentia.dateValidator"/>
			</t:inputCalendar>
          </h:panelGroup>
          -
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="endExpiration" />
            <h:selectBooleanCheckbox id="endExpirationValid" value="#{billBean.searchEndExpirationValid}" 
                                      onclick="setEnabled('search:endExpiration',this.checked)"/>
            <t:inputCalendar id="endExpiration" value="#{billBean.searchEndExpiration}"
                             renderAsPopup="true" popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true" 
                             popupTodayString="#{msg['calendar.today']}" popupWeekString="#{msg['calendar.week']}"
                             onchange="setEnabled('search:endExpiration',true);setChecked('search:endExpirationValid',true);"
                             >                                      
				<f:validator validatorId="autentia.dateValidator"/>
			</t:inputCalendar>                                      
          </h:panelGroup>
          <script>
            setEnabled( 'search:startExpiration', ${billBean.searchStartExpirationValid} )
            setEnabled( 'search:endExpiration', ${billBean.searchEndExpirationValid} )
          </script>

        
      </td>
    </tr>
                        
      <%-- Field: paymentMode --%>
    <tr>
      <td class="searchLabel">${msg['bill.paymentMode']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="paymentMode" />
            <h:selectBooleanCheckbox id="paymentModeValid" value="#{billBean.searchPaymentModeValid}" 
                                      onclick="setEnabled('search:paymentMode',this.checked)"/>
            <h:selectOneMenu id="paymentMode" value="#{billBean.searchPaymentMode}" onclick="setEnabled('search:paymentMode',true)">
              <f:converter converterId="autentia.EnumConverter"/>
              <f:selectItems value="#{billBean.paymentModes}" />
            </h:selectOneMenu>
          </h:panelGroup>
          <script>
            setEnabled( 'search:paymentMode', ${billBean.searchPaymentModeValid} )
          </script>

        
      </td>
    </tr>
                        
      <%-- Field: state --%>
    <tr>
      <td class="searchLabel">${msg['bill.state']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="state" />
            <h:selectBooleanCheckbox id="stateValid" value="#{billBean.searchStateValid}" 
                                      onclick="setEnabled('search:state',this.checked)"/>
            <h:selectOneMenu id="state" value="#{billBean.searchState}" onclick="setEnabled('search:state',true)">
              <f:converter converterId="autentia.EnumConverter"/>
              <f:selectItems value="#{billBean.states}" />
            </h:selectOneMenu>
          </h:panelGroup>
          <script>
            setEnabled( 'search:state', ${billBean.searchStateValid} )
          </script>

        
      </td>
    </tr>
                        
      
                        
      <%-- Field: number --%>
    <tr>
      <td class="searchLabel">${msg['bill.number']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="number" />
            <h:selectBooleanCheckbox id="numberValid" value="#{billBean.searchNumberValid}" 
                                      onclick="setEnabled('search:number',this.checked)"/>
            <h:inputText id="number" value="#{billBean.searchNumber}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:number', ${billBean.searchNumberValid} )
          </script>

        
      </td>
    </tr>
    
    <%-- Field: bookNumber --%>
    <tr>
      <td class="searchLabel">${msg['bill.bookNumber']}:</td>
      <td class="searchFieldCell">
          <h:panelGroup>
          	<h:selectBooleanCheckbox id="bookNumberValid" value="#{billBean.searchBookNumberValid}" 
                                      onclick="setEnabled('search:bookNumber',this.checked)"/>
            <h:inputText id="bookNumber" value="#{billBean.searchBookNumber}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:bookNumber', ${billBean.searchBookNumberValid} )
          </script>
      </td>
    </tr>
    
    <%-- Field: provider --%>
    <tr>
      <td class="searchLabel">${msg['bill.provider']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="provider" />
            <h:selectBooleanCheckbox id="providerValid" value="#{billBean.searchProviderValid}" 
                                      onclick="setEnabled('search:provider',this.checked)"/>
            <h:selectOneMenu id="provider" value="#{billBean.searchProvider}" onclick="setEnabled('search:provider',true)">
              <f:selectItems value="#{billBean.providers}" />
              <f:converter converterId="autentia.EntityConverter"/>
            </h:selectOneMenu>
          </h:panelGroup>
          <script>
            setEnabled( 'search:provider', ${billBean.searchProviderValid} )
          </script>

        
      </td>
    </tr>
                        
      <%-- Field: name --%>
    <tr>
      <td class="searchLabel">${msg['bill.name']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="name" />
            <h:selectBooleanCheckbox id="nameValid" value="#{billBean.searchNameValid}" 
                                      onclick="setEnabled('search:name',this.checked)"/>
            <h:inputText id="name" value="#{billBean.searchName}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:name', ${billBean.searchNameValid} )
          </script>

        
      </td>
    </tr>
                        
      <%-- Ignored field: file --%>

                        
      <%-- Ignored field: fileMime --%>

                        
      <%-- Ignored field: observations --%>
                      
     
    
                              
      <%-- Field: project --%>
    <tr>
      <td class="searchLabel">${msg['bill.organization']} / ${msg['bill.project']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="project" />
            <h:selectBooleanCheckbox id="projectValid" value="#{billBean.searchProjectValid}" 
                                      onclick="setEnabled('search:organization',this.checked);setEnabled('search:project',this.checked)"/>
            <h:selectOneMenu id="organization" value="#{billBean.selectedOrganization}" immediate="true" onchange="submit()"
                     valueChangeListener="#{billBean.onSelectedOrganizationSearchChanged}" onclick="setEnabled('search:organization',true);setEnabled('search:project',true)">
              <f:selectItems value="#{billBean.organizations}" />
              <f:converter converterId="autentia.EntityConverter"/>
            </h:selectOneMenu>
            <h:selectOneMenu id="project" value="#{billBean.searchProject}" onclick="setEnabled('search:organization',true);setEnabled('search:project',true)">
              <f:selectItems value="#{billBean.projectsBySelectedOrganization}" />
              <f:converter converterId="autentia.EntityConverter"/>
            </h:selectOneMenu>
          </h:panelGroup>
          <script>
          	setEnabled( 'search:project', ${billBean.searchProjectValid} );
            setEnabled( 'search:organization', ${billBean.searchProjectValid} );
          </script>

        
      </td>
    </tr>                                            
      <%-- Field: orderNumber --%>
    <tr>
      <td class="searchLabel">${msg['bill.orderNumber']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="orderNumber" />
            <h:selectBooleanCheckbox id="orderNumberValid" value="#{billBean.searchOrderNumberValid}" 
                                      onclick="setEnabled('search:orderNumber',this.checked)"/>
            <h:inputText id="orderNumber" value="#{billBean.searchOrderNumber}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:orderNumber', ${billBean.searchOrderNumberValid} )
          </script>

        
      </td>
    </tr>

          <%-- Field: rectifiedBill --%>
          <tr>
              <td class="searchLabel">${msg['bill.rectified']}:</td>
              <td class="searchFieldCell" style="display:flex">
                  <h:panelGroup>
                      <h:message styleClass="error" showSummary="true" showDetail="false" for="rectifiedBill" />
                      <h:selectBooleanCheckbox id="rectifiedBillValid" value="#{billBean.searchRectifiedBillValid}"
                                               onclick="setEnabled('search:rectifiedBill:0',this.checked);
                                                        setEnabled('search:rectifiedBill:1',this.checked)"/>
                      <h:selectOneRadio id="rectifiedBill" value = "#{billBean.searchRectifiedBill}">
                          <f:selectItem itemValue = "TRUE" itemLabel = "#{msg['msg.yes']}" />
                          <f:selectItem itemValue = "FALSE" itemLabel = "#{msg['msg.no']}" />
                      </h:selectOneRadio>
                  </h:panelGroup>
                  <script>
                      setEnabled( 'search:rectifiedBill:0', ${billBean.searchRectifiedBillValid} )
                      setEnabled( 'search:rectifiedBill:1', ${billBean.searchRectifiedBillValid} )
                  </script>


              </td>
          </tr>

          <%-- Field: billCategory --%>
          <tr>
              <td class="searchLabel">${msg['bill.type']}:</td>
              <td class="searchFieldCell">
                  <h:panelGroup>
                      <h:message styleClass="error" showSummary="true" showDetail="false" for="billCategory" />
                      <h:selectBooleanCheckbox id="billCategoryValid" value="#{billBean.searchBillCategoryValid}"
                                               onclick="setEnabled('search:billCategory',this.checked)"/>
                      <h:selectOneMenu id="billCategory" value="#{billBean.searchBillCategory}"
                                       onclick="setEnabled('search:billCategory',true)">
                          <f:selectItems value="#{billBean.billCategories}" />
                          <f:converter converterId="autentia.EntityConverter"/>
                      </h:selectOneMenu>
                  </h:panelGroup>
                  <script>
                      setEnabled( 'search:billCategory', ${billBean.searchBillCategoryValid} )
                  </script>


              </td>
          </tr>
    
     
            <h:messages></h:messages>
        </table>
        
      </h:form>
    </f:view>
    
  </body>
</html>  		
