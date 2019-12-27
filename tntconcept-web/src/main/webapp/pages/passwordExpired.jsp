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


        <f:loadBundle basename="com.autentia.tnt.resources.messages" var="messages" />
        <i:location place="changePassword" msg="${messages}"/> 
       
    <f:view>
          <h:form id="expiredPasswordBean">
                <i:titleBar  msg="${messages}">
                   <h:commandLink action="#{expiredPasswordBean.changePassword}"  >
                       <h:graphicImage title="#{messages.entityActions_save}"  value="/img/save.gif" styleClass="titleImg" />
                   </h:commandLink>
                </i:titleBar> 

                <table class="editTable" cellpadding="0" cellspacing="0">
                    <tr>
                    	<td class="editLabelRW">${messages['changePassword.newPassword']}:</td>
                    	<td class="editFieldCell">
				              <h:panelGroup>
				                  <h:message styleClass="error" showSummary="true" showDetail="false" for="password" />
				                  <h:inputSecret id="password" value="#{expiredPasswordBean.password}" size="70" maxlength="50" required="true">
				                      <f:validateLength maximum="50" minimum="5"/>
				                  </h:inputSecret>
				              </h:panelGroup>                    	
                    	</td>
                    </tr>
                    <tr>
                    	<td class="editLabelRW">${messages['changePassword.repeatPassword']}:</td>
                    	<td class="editFieldCell">
				              <h:panelGroup>
				                  <h:message styleClass="error" showSummary="true" showDetail="false" for="passwordRepe" />
				                  <h:inputSecret id="passwordRepe" value="#{expiredPasswordBean.passwordRepe}" size="70" maxlength="50" required="true">
				                      <f:validateLength maximum="50" minimum="5"/>
				                  </h:inputSecret>
				              </h:panelGroup>                     	
                    	</td>
                    </tr>
                	<tr>
                		<td colspan="2"><h:messages errorClass="error" globalOnly="true"/></td>
                	</tr>
				</table>
      </h:form>
    </f:view>

</body>
</html>