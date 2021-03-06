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
    
    <!-- searchContact.jsp: generated by stajanov code generator -->
    <f:loadBundle basename="com.autentia.tnt.resources.messages" var="msg" />
    <i:location place="searchContact" msg="${msg}"/> 
    
    <f:view>
      <%@include file="/inc/header.jsp" %>
      <h:form id="search" enctype="multipart/form-data">
        
        <%-- Header --%>
        <i:titleBar msg="${msg}">
          <h:commandLink action="#{contactBean.list}">
            <h:graphicImage title="#{msg.entityActions_run}"  value="/img/run.png" styleClass="titleImg" />
          </h:commandLink>
        </i:titleBar>
        
        <%-- Search form --%>
        <table class="searchTable" cellpadding="0" cellspacing="0">

          
      <%-- Ignored field: id --%>

                        
      <%-- Field: name --%>
    <tr>
      <td class="searchLabel">${msg['contact.name']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="name" />
            <h:selectBooleanCheckbox id="nameValid" value="#{contactBean.searchNameValid}" 
                                      onclick="setEnabled('search:name',this.checked)"/>
            <h:inputText id="name" value="#{contactBean.searchName}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:name', ${contactBean.searchNameValid} )
          </script>

        
      </td>
    </tr>
                        
      <%-- Field: email --%>
    <tr>
      <td class="searchLabel">${msg['contact.email']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="email" />
            <h:selectBooleanCheckbox id="emailValid" value="#{contactBean.searchEmailValid}" 
                                      onclick="setEnabled('search:email',this.checked)"/>
            <h:inputText id="email" value="#{contactBean.searchEmail}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:email', ${contactBean.searchEmailValid} )
          </script>

        
      </td>
    </tr>

	<%-- Field: email2 --%>
    <tr>
      <td class="searchLabel">${msg['contact.email2']}:</td>
      <td class="searchFieldCell">
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="email2" />
            <h:selectBooleanCheckbox id="email2Valid" value="#{contactBean.searchEmail2Valid}" 
                                      onclick="setEnabled('search:email2',this.checked)"/>
            <h:inputText id="email2" value="#{contactBean.searchEmail2}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:email2', ${contactBean.searchEmail2Valid} )
          </script>
      </td>
    </tr>

    <%-- Field: phone --%>
    <tr>
      <td class="searchLabel">${msg['contact.phone']}:</td>
      <td class="searchFieldCell">
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="phone" />
            <h:selectBooleanCheckbox id="phoneValid" value="#{contactBean.searchPhoneValid}" 
                                      onclick="setEnabled('search:phone',this.checked)"/>
            <h:inputText id="phone" value="#{contactBean.searchPhone}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:phone', ${contactBean.searchPhoneValid} )
          </script>
      </td>
    </tr>

    <%-- Field: phone2 --%>
    <tr>
      <td class="searchLabel">${msg['contact.phone2']}:</td>
      <td class="searchFieldCell">
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="phone2" />
            <h:selectBooleanCheckbox id="phone2Valid" value="#{contactBean.searchPhone2Valid}" 
                                      onclick="setEnabled('search:phone2',this.checked)"/>
            <h:inputText id="phone2" value="#{contactBean.searchPhone2}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:phone2', ${contactBean.searchPhone2Valid} )
          </script>
      </td>
    </tr>
                        
    <%-- Field: mobile --%>
    <tr>
      <td class="searchLabel">${msg['contact.mobile']}:</td>
      <td class="searchFieldCell">
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="mobile" />
            <h:selectBooleanCheckbox id="mobileValid" value="#{contactBean.searchMobileValid}" 
                                      onclick="setEnabled('search:mobile',this.checked)"/>
            <h:inputText id="mobile" value="#{contactBean.searchMobile}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:mobile', ${contactBean.searchMobileValid} )
          </script>
      </td>
    </tr>

    <%-- Field: fax --%>
    <tr>
      <td class="searchLabel">${msg['contact.fax']}:</td>
      <td class="searchFieldCell">
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="fax" />
            <h:selectBooleanCheckbox id="faxValid" value="#{contactBean.searchFaxValid}" 
                                      onclick="setEnabled('search:fax',this.checked)"/>
            <h:inputText id="fax" value="#{contactBean.searchFax}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:fax', ${contactBean.searchFaxValid} )
          </script>
      </td>
    </tr>

    <%-- Field: country --%>
    <tr>
      <td class="searchLabel">${msg['contact.country']}:</td>
      <td class="searchFieldCell">
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="country" />
            <h:selectBooleanCheckbox id="countryValid" value="#{contactBean.searchCountryValid}" 
                                      onclick="setEnabled('search:country',this.checked)"/>
            <h:inputText id="country" value="#{contactBean.searchCountry}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:country', ${contactBean.searchCountryValid} )
          </script>
      </td>
    </tr>
    
    <%-- Field: province --%>
    <tr>
      <td class="searchLabel">${msg['contact.province']}:</td>
      <td class="searchFieldCell">
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="province" />
            <h:selectBooleanCheckbox id="provinceValid" value="#{contactBean.searchProvinceValid}" 
                                      onclick="setEnabled('search:province',this.checked)"/>
            <h:selectOneMenu id="province" value="#{contactBean.searchProvince}" onclick="setEnabled('search:province',true)">
              <f:selectItems value="#{contactBean.provinces}" />
              <f:converter converterId="autentia.EntityConverter"/>
            </h:selectOneMenu>
          </h:panelGroup>
          <script>
            setEnabled( 'search:province', ${contactBean.searchProvinceValid} )
          </script>
      </td>
    </tr>
    
    <%-- Field: city --%>
    <tr>
      <td class="searchLabel">${msg['contact.city']}:</td>
      <td class="searchFieldCell">
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="city" />
            <h:selectBooleanCheckbox id="cityValid" value="#{contactBean.searchCityValid}" 
                                      onclick="setEnabled('search:city',this.checked)"/>
            <h:inputText id="city" value="#{contactBean.searchCity}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:city', ${contactBean.searchCityValid} )
          </script>
      </td>
    </tr>
    
    <%-- Field: postal code --%>
    <tr>
      <td class="searchLabel">${msg['contact.postalCode']}:</td>
      <td class="searchFieldCell">
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="postalCode" />
            <h:selectBooleanCheckbox id="postalCodeValid" value="#{contactBean.searchPostalCodeValid}" 
                                      onclick="setEnabled('search:postalCode',this.checked)"/>
            <h:inputText id="postalCode" value="#{contactBean.searchPostalCode}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:postalCode', ${contactBean.searchPostalCodeValid} )
          </script>
      </td>
    </tr>
    
    <%-- Field: address --%>
    <tr>
      <td class="searchLabel">${msg['contact.address']}:</td>
      <td class="searchFieldCell">
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="address" />
            <h:selectBooleanCheckbox id="addressValid" value="#{contactBean.searchAddressValid}" 
                                      onclick="setEnabled('search:address',this.checked)"/>
            <h:inputText id="address" value="#{contactBean.searchAddress}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:address', ${contactBean.searchAddressValid} )
          </script>
      </td>
    </tr>
    
      <%-- Field: notified --%>
    <tr>
      <td class="searchLabel">${msg['contact.notified']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="notified" />
            <h:selectBooleanCheckbox id="notifiedValid" value="#{contactBean.searchNotifiedValid}" 
                                      onclick="setEnabledByName('search:notified',this.checked)"/>
            
            <h:outputLabel for="notified" value="#{msg['msg.yesno']}"></h:outputLabel>
            <h:selectBooleanCheckbox id="notified" value="#{contactBean.searchNotified}"/>            
            
            
          </h:panelGroup>
          <script>
            setEnabledByName( 'search:notified', ${contactBean.searchNotifiedValid} )
          </script>

        
      </td>
    </tr>
                        
      <%-- Field: position 
    <tr>
      <td class="searchLabel">${msg['contact.position']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="position" />
            <h:selectBooleanCheckbox id="positionValid" value="#{contactBean.searchPositionValid}" 
                                      onclick="setEnabled('search:position',this.checked)"/>
            <h:inputText id="position" value="#{contactBean.searchPosition}" size="70"/>
          </h:panelGroup>
          <script>
            setEnabled( 'search:position', ${contactBean.searchPositionValid} )
          </script>

        
      </td>
    </tr>
--%>                        
      <%-- Ignored field: ownerId --%>

                        
      <%-- Ignored field: departmentId --%>

                        
      <%-- Ignored field: insertDate --%>

                        
      <%-- Ignored field: updateDate --%>

                                  
      <%-- Field: organization --%> 
    <tr>
      <td class="searchLabel">${msg['contact.organization']}:</td>
      <td class="searchFieldCell">

        
          
          <h:panelGroup>
            <h:message styleClass="error" showSummary="true" showDetail="false" for="organization" />
            <h:selectBooleanCheckbox id="organizationValid" value="#{contactBean.searchOrganizationValid}" 
                                      onclick="setEnabled('search:organization',this.checked)"/>
            <h:selectOneMenu id="organization" value="#{contactBean.searchOrganization}" onclick="setEnabled('search:organization',true)">
              <f:selectItems value="#{contactBean.organizations}" />
              <f:converter converterId="autentia.EntityConverter"/>
            </h:selectOneMenu>
          </h:panelGroup>
          <script>
            setEnabled( 'search:organization', ${contactBean.searchOrganizationValid} )
          </script>

        
      </td>
    </tr>
                               
        </table>
        
      </h:form>
    </f:view>
    
  </body>
</html>  		
