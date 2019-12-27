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
    
    <!-- editInteraction.jsp: generated by stajanov code generator -->
    <f:loadBundle basename="com.autentia.tnt.resources.messages" var="msg" />
    <i:location place="detailInteraction" msg="${msg}"/> 
    
    <f:view>
        <%@include file="/inc/header.jsp" %>
      <h:form id="interaction" enctype="multipart/form-data">
        
        <%-- Header --%>
        <i:titleBar name="${interactionBean.creationDate}" msg="${msg}">
          <t:commandLink action="#{interactionBean.edit}" immediate="true" rendered="#{interactionBean.editAvailable}">
            <f:param name="rowid" value="#{interactionBean.id}" />
            <h:graphicImage title="#{msg.entityActions_edit}"  value="/img/edit.gif" styleClass="cmdImg" />
          </t:commandLink>
          <h:commandLink action="#{interactionBean.delete}" rendered="#{interactionBean.deleteAvailable}" onclick="if( !confirm('#{msg['question.confirmDelete']}') ) return false;">
            <h:graphicImage title="#{msg.entityActions_delete}"  value="/img/delete.gif" styleClass="titleImg" />
          </h:commandLink>
          <h:commandLink action="#{interactionBean.list}" immediate="true">
            <h:graphicImage title="#{msg.entityActions_back}"  value="/img/back.gif" styleClass="titleImg" />
          </h:commandLink>
        </i:titleBar>


        <%-- Detail form --%>
        <table class="detailTable" cellpadding="0" cellspacing="0">

            
  
      <%-- Ignored field: id --%>
  
                            
  
      <%-- Field: creationDate --%>
    <tr>
	<td class="detailLabelRW">${msg['interaction.creationDate']}:</td>
	<td class="detailFieldCell">
         	    	<h:outputText value="#{interactionBean.creationDate}" converter="autentia.dateConverter" />
 	          </td>
    </tr>
                            
  
      <%-- Field: interest --%>
    <tr>
	<td class="detailLabelRW">${msg['interaction.interest']}:</td>
	<td class="detailFieldCell">
                	<h:outputText value="#{interactionBean.interestFormatted}" />
              </td>
    </tr>
                            
  
      <%-- Field: description --%>
    <tr>
	<td class="detailLabelRW">${msg['interaction.description']}:</td>
	<td class="detailFieldCell">
         	       <h:outputText value="#{interactionBean.description}" />
 	      </td>
    </tr>
                            
  
      <%-- Field: file --%>
    <tr>
	<td class="detailLabelRW">${msg['interaction.file']}:</td>
	<td class="detailFieldCell">
                  <i:fileLink type="interaction" objectId="${interactionBean.id}" file="${interactionBean.file}" /> 
     	      </td>
    </tr>
                            
  
      <%-- Ignored field: fileMime --%>
                            
  
      <%-- Ignored field: departmentId --%>
  
                            
  
      <%-- Ignored field: insertDate --%>
  
                            
  
      <%-- Ignored field: updateDate --%>
  
                                        
  
      <%-- Field: project --%>
    <tr>
	<td class="detailLabelRW">${msg['interaction.project']}:</td>
	<td class="detailFieldCell">
         	    	<h:outputText value="#{interactionBean.project.name}"/>
 	          </td>
    </tr>
                            
  
      <%-- Field: type --%>
    <tr>
	<td class="detailLabelRW">${msg['interaction.type']}:</td>
	<td class="detailFieldCell">
         	    	<h:outputText value="#{interactionBean.type.name}"/>
 	          </td>
    </tr>
                            
  
      <%-- Field: user --%>
    <tr>
	<td class="detailLabelRW">${msg['interaction.user']}:</td>
	<td class="detailFieldCell">
         	    	<h:outputText value="#{interactionBean.user.name}"/>
 	          </td>
    </tr>
                            
  
      <%-- Ignored field: offer --%>
  
                                      
        </table>

      </h:form>
    </f:view>
    
  </body>
</html>  		
<%-- interaction - generated by stajanov (do not edit/delete) --%>
