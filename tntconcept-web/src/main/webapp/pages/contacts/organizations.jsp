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

    <!-- organizations.jsp: generated by stajanov code generator -->
    <f:loadBundle basename="com.autentia.tnt.resources.messages" var="msg" />
    <i:location place="organizations" msg="${msg}"/> 
    
    <f:view>
     <%@include file="/inc/header.jsp" %>
      <h:form id="organizations">
        
        <%-- Header --%>
        <i:titleBar msg="${msg}">
          <h:commandLink action="#{organizationBean.search}">
            <h:graphicImage rendered="#{ organizationBean.search.searchActive}" title="#{msg.entityActions_filtered}"  value="/img/search_applied.gif" styleClass="titleImg" />
            <h:graphicImage rendered="#{!organizationBean.search.searchActive}" title="#{msg.entityActions_search}"    value="/img/search.gif"         styleClass="titleImg" />
          </h:commandLink>
           <h:commandLink action="#{organizationBean.reset}">
            <h:graphicImage rendered="#{organizationBean.search.searchActive}" title="#{msg.entityActions_reset}"  value="/img/eraser.png" styleClass="titleImg" />           
          </h:commandLink>
          <h:commandLink action="#{organizationBean.create}" rendered="#{organizationBean.createAvailable}">
            <h:graphicImage title="#{msg.entityActions_create}"  value="/img/new.gif" styleClass="titleImg" />
          </h:commandLink>
        </i:titleBar>
        
        
          <%-- ABC quick pager --%>
          <div class="abcPager">
            <h:outputText value="#{msg['abcPager.title']}" styleClass="abcPagerTitle"/>
            <a:abcPager styleClass="abcPagerLetter" selectedStyleClass="abcPagerSelectedLetter" 
                        value="#{organizationBean.letter}" action="#{organizationBean.letterClicked}"
                        allowUnselect="true" unselectImage="/img/no_funnel.png"/>
          </div>

        
        <%-- List of organizations --%>
        <t:dataTable id="list" var="organization" value="#{organizationBean.all}" preserveDataModel="false" 
            cellpadding="0" cellspacing="0" styleClass="listTable" 
            headerClass="listHeaderCell" footerClass="listFooter" 
            rows="#{settingBean.mySettings.listSize}" rowClasses="listRowO,listRowE"
            columnClasses="listCmdCell,listOrganizationName,listOrganizationPhone,listOrganizationType,listOrganizationCategory"
            sortColumn="#{organizationBean.sortColumn}" sortAscending="#{organizationBean.sortAscending}"
	    rowOnMouseOver="this.savedClassName=this.className;this.className='listRowSel';" 
	    rowOnMouseOut="this.className=this.savedClassName;">
          
          <%-- Commands --%>
          <h:column>
            <f:facet name="header">
              <f:verbatim>-</f:verbatim>
            </f:facet>
            <t:commandLink action="#{organizationBean.searchContacts}" immediate="true">
              <f:param name="rowid" value="#{organization.id}" />
              <h:graphicImage value="/img/people.png" styleClass="cmdImg" />
            </t:commandLink>
            <t:commandLink action="#{organizationBean.detail}" immediate="true">
              <f:param name="rowid" value="#{organization.id}" />
              <h:graphicImage title="#{msg.entityActions_detail}"  value="/img/detail.gif" styleClass="cmdImg" />
            </t:commandLink>
          </h:column>


      <%-- Ignored field: id --%>
  

      <%-- Field: name --%>
    <h:column>
      <f:facet name="header">
      	        <t:commandSortHeader styleClass="listHeader" columnName="name">
                 <f:facet name="ascending">
            <t:graphicImage value="/img/ascending-arrow.gif" border="0" />
          </f:facet>
          <f:facet name="descending">
            <t:graphicImage value="/img/descending-arrow.gif" border="0" />
          </f:facet>
          <f:verbatim>${msg['organization.name']}</f:verbatim>
        </t:commandSortHeader>
      </f:facet>

      <t:commandLink action="#{organizationBean.detail}" immediate="true">
	<f:param name="rowid" value="#{organization.id}" />
		  <%-- String field --%>
	  <h:outputText value="#{organization.name}" />
	      </t:commandLink>

    </h:column>
  

      <%-- Ignored field: documentNumber --%>
  

      <%-- Ignored field: street --%>
  

      <%-- Ignored field: number --%>
  

      <%-- Ignored field: locator --%>
  

      <%-- Ignored field: postalCode --%>
  

      <%-- Ignored field: city --%>
  

      <%-- Ignored field: state --%>
  

      <%-- Ignored field: country --%>
  

      <%-- Field: phone --%>
    <h:column>
      <f:facet name="header">
      	        <t:commandSortHeader styleClass="listHeader" columnName="phone">
                 <f:facet name="ascending">
            <t:graphicImage value="/img/ascending-arrow.gif" border="0" />
          </f:facet>
          <f:facet name="descending">
            <t:graphicImage value="/img/descending-arrow.gif" border="0" />
          </f:facet>
          <f:verbatim>${msg['organization.phone']}</f:verbatim>
        </t:commandSortHeader>
      </f:facet>

      <t:commandLink action="#{organizationBean.detail}" immediate="true">
	<f:param name="rowid" value="#{organization.id}" />
		  <%-- String field --%>
	  <h:outputText value="#{organization.phone}" />
	      </t:commandLink>

    </h:column>
  

      <%-- Ignored field: fax --%>
  

      <%-- Ignored field: email --%>
  

      <%-- Ignored field: website --%>
  

      <%-- Ignored field: ftpsite --%>
  

      <%-- Ignored field: notes --%>
  

      <%-- Ignored field: ownerId --%>
  

      <%-- Ignored field: departmentId --%>
  

      <%-- Ignored field: insertDate --%>
  

      <%-- Ignored field: updateDate --%>
  

      <%-- Field: type --%>
    <h:column>
      <f:facet name="header">
      	        <t:commandSortHeader styleClass="listHeader" columnName="type.name">
                 <f:facet name="ascending">
            <t:graphicImage value="/img/ascending-arrow.gif" border="0" />
          </f:facet>
          <f:facet name="descending">
            <t:graphicImage value="/img/descending-arrow.gif" border="0" />
          </f:facet>
          <f:verbatim>${msg['organization.type']}</f:verbatim>
        </t:commandSortHeader>
      </f:facet>

      <t:commandLink action="#{organizationBean.detail}" immediate="true">
	<f:param name="rowid" value="#{organization.id}" />
		  <%-- Referenced field --%>
	  <h:outputText value="#{organization.type.name}" />

	      </t:commandLink>

    </h:column>
  

      <%-- Field: category --%>
    <h:column>
      <f:facet name="header">
      	        <t:commandSortHeader styleClass="listHeader" columnName="category.name">
                 <f:facet name="ascending">
            <t:graphicImage value="/img/ascending-arrow.gif" border="0" />
          </f:facet>
          <f:facet name="descending">
            <t:graphicImage value="/img/descending-arrow.gif" border="0" />
          </f:facet>
          <f:verbatim>${msg['organization.category']}</f:verbatim>
        </t:commandSortHeader>
      </f:facet>

      <t:commandLink action="#{organizationBean.detail}" immediate="true">
	<f:param name="rowid" value="#{organization.id}" />
		  <%-- Referenced field --%>
	  <h:outputText value="#{organization.category.name}" />

	      </t:commandLink>

    </h:column>
  

      <%-- Ignored field: province --%>
  
        </t:dataTable>
          
        <%-- Paginator control --%>
        <%@include file="/inc/paginator.jsp" %>
        
      </h:form>
    </f:view>
    
  </body>
</html>  		

