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

<%@include file="/inc/tlibs.jsp"%>
<html>
<head>
<%@include file="/inc/uiCore.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/script/prototype.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/script/scriptaculous.js?load=effects"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/script/modalbox.js"></script>
    <script type="text/javascript">
     function openPDF() {  
     	$('commissioningReport').submit();
     	
     }
    
    </script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/modalbox.css" type="text/css" media="screen" />
</head>
<body>
<!-- editContact.jsp: generated by stajanov code generator -->
<f:loadBundle basename="com.autentia.tnt.resources.messages" var="msg" />
<i:location place="editCommissioning" msg="${msg}" />

<f:view>
	<c:if test="${commissioningBean.id != null}">
	<form id="commissioningReport" action="<%=request.getContextPath()%>/report/document/ficha.de.proyecto.pdf" target="_blank" method="post">
		<input type="hidden" name="connection" value="none">
		<input type="hidden" name="projectName" value="${commissioningBean.reportProjectName}">
		<input type="hidden" name="projectContent" value="${commissioningBean.reportProjectContent}">
		<input type="hidden" name="projectPurpose" value="${commissioningBean.reportProjectPurpose}">
		<input type="hidden" name="collaboratorName" value="">
		<input type="hidden" name="revisorName" value="${commissioningBean.revisorName}">
		<input type="hidden" name="endDate" value="${commissioningBean.reportEndDate}">
		<input type="hidden" name="budget" value="${commissioningBean.reportBudget}">
		<input type="hidden" name="day" value="${commissioningBean.reportDay}">
		<input type="hidden" name="month" value="${commissioningBean.reportMonth}">
		<input type="hidden" name="year" value="${commissioningBean.reportYear}">
	</form>
	</c:if>
<%--<tr:document>--%>
	<%@include file="/inc/header.jsp"%>
	<h:form id="commissioning" enctype="multipart/form-data">

		<%-- Header --%>
		<i:titleBar name="${commissioningBean.name}" msg="${msg}">
			<h:commandLink rendered="#{commissioningBean.puedoImprimir}" action="#" onclick="openPDF()" immediate="true">
				<h:graphicImage value="/img/page_white_acrobat.png" styleClass="titleImg" />
			</h:commandLink>		
			<h:commandLink action="#{commissioningBean.save}" onclick="if(!askSave('#{commissioningBean.id}','#{msg['question.confirmSave']}')) return false;">
				<h:graphicImage value="/img/save.gif" styleClass="titleImg" />
			</h:commandLink>
			<h:commandLink action="#{commissioningBean.delete}" rendered="#{commissioningBean.deleteAvailable}"
				onclick="return confirm('#{msg['question.confirmDelete']}');">
				<h:graphicImage value="/img/delete.gif" styleClass="titleImg" />
			</h:commandLink>
			<h:commandLink action="#{commissioningBean.list}" immediate="true">
				<h:graphicImage title="#{msg.entityActions_back}" value="/img/back.gif" styleClass="titleImg" />
			</h:commandLink>
			<h:commandLink action="#{commissioningBean.nextFlowStep}" rendered="#{commissioningBean.id != null && commissioningBean.canPerformNextFlowStep}"
				onclick="return confirm('#{msg['question.confirmChangeState']}');">
				<h:graphicImage value="/img/run.png" styleClass="titleImg"/>
				<h:outputText value="#{commissioningBean.nextAction}"/>
			</h:commandLink>
		</i:titleBar>

		<h:messages errorClass="error" infoClass="info" warnClass="warning" id="errorMessage" showSummary="true" showDetail="false" globalOnly="true" />

		<%-- Edition form --%>
		<table class="editTable" cellpadding="0" cellspacing="0">

			<%-- Commissioning - generated by stajanov (do not edit/delete) --%>

			<%-- Field: status --%>
		    <t:htmlTag id="statusRow" value="tr" rendered="#{commissioningBean.renderStatus}">
   	    		<td class="editLabelRW">${msg['commissioning.status']}:</td>
		    	      
		      	<td class="editFieldCell" colspan="2">
		
                <h:panelGroup>
		            <h:message styleClass="error" showSummary="true" showDetail="false" for="status" />
		            <h:selectOneMenu id="status" value="#{commissioningBean.status}" readonly="#{!commissioningBean.editStatus}" disabled="#{!commissioningBean.editStatus}">
		              <f:converter converterId="autentia.EnumConverter"/>
		              <f:selectItems value="#{commissioningBean.statuss}" />
		            </h:selectOneMenu>
		          </h:panelGroup>
		
				</td>
		    </t:htmlTag>

			<%-- Field: requestDate --%>
			<t:htmlTag id="requestDateRow" value="tr" rendered="#{commissioningBean.renderRequestDate}">
				<td class="editLabelRW">${msg['commissioning.requestDate']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="requestDate" />
					<t:inputCalendar id="requestDate"
						value="#{commissioningBean.requestDate}" renderAsPopup="true"
						popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true"
						popupTodayString="#{msg['calendar.today']}"
						popupWeekString="#{msg['calendar.week']}" 
						rendered="#{commissioningBean.editRequestDate}"/>
					<h:outputText value="#{commissioningBean.requestDate}" converter="autentia.dateConverter" 
						rendered="#{!commissioningBean.editRequestDate}"/>
				</h:panelGroup></td>
			</t:htmlTag>


			<%-- Field: name --%>
			<t:htmlTag id="nameRow" value="tr" rendered="#{commissioningBean.renderName}">
				<td class="editLabelRW">${msg['commissioning.name']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="name" />
					<h:inputText id="name" value="#{commissioningBean.name}" readonly="#{!commissioningBean.editName}"/>
				</h:panelGroup></td>
			</t:htmlTag>


			<%-- Field: scope --%>
			<t:htmlTag id="scopeRow" value="tr" rendered="#{commissioningBean.renderScope}">
				<td class="editLabelRW">${msg['commissioning.scope']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="scope" />
					<h:inputTextarea id="scope" value="#{commissioningBean.scope}" rows="5" cols="75" readonly="#{!commissioningBean.editScope}"/>
				</h:panelGroup></td>
			</t:htmlTag>


			<%-- Field: content --%>
			<t:htmlTag id="contentRow" value="tr" rendered="#{commissioningBean.renderContent}">
				<td class="editLabelRW">${msg['commissioning.content']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="content" />
					<h:inputTextarea id="content" value="#{commissioningBean.content}" rows="5" cols="75" readonly="#{!commissioningBean.editContent}"/>
				</h:panelGroup></td>
			</t:htmlTag>


			<%-- Field: products --%>
			<t:htmlTag id="productsRow" value="tr" rendered="#{commissioningBean.renderProducts}">
				<td class="editLabelRW">${msg['commissioning.products']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="products" />
					<h:inputTextarea id="products" value="#{commissioningBean.products}" rows="5" cols="75" readonly="#{!commissioningBean.editProducts}"/>
				</h:panelGroup></td>
			</t:htmlTag>


			<%-- Field: deliveryDate --%>
			<t:htmlTag id="deliveryDateRow" value="tr" rendered="#{commissioningBean.renderDeliveryDate}" styleClass="editFieldCell" style="vertical-align: top;">
				<td class="editLabelRW">${msg['commissioning.deliveryDate']}:</td>

				<td class="" style="border-bottom:1px solid #C7D7DF; width: 18%;">
				<h:panelGrid>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="deliveryDate" />
					<t:inputCalendar id="deliveryDate"
						value="#{commissioningBean.deliveryDate}" renderAsPopup="true"
						popupDateFormat="d/MM/yyyy" renderPopupButtonAsImage="true"
						popupTodayString="#{msg['calendar.today']}"
						popupWeekString="#{msg['calendar.week']}"
						required="true"
						rendered="#{commissioningBean.editDeliveryDate}"/>
					<h:outputText value="#{commissioningBean.deliveryDate}" rendered="#{!commissioningBean.editDeliveryDate}"/>

			        <h:commandLink action="#{commissioningBean.showAddDelay}" rendered="#{!commissioningBean.showAddDelayPanel && commissioningBean.addDelay}">
			        	<h:graphicImage value="/img/today.png" styleClass="titleImg" />
			        	<h:outputText>${msg['commissioning.addDelay']}</h:outputText>
			        </h:commandLink>
			        
			        <h:outputLink value="delays.jsf" onclick="Modalbox.show('delays.jsf',{title: ' ', width: 600});return false;" rendered="#{commissioningBean.hasCommissionDelays}">
						<h:graphicImage value="/img/detail.gif" styleClass="titleImg" />			        	
						<h:outputText>${msg['commissioning.viewDelays']}</h:outputText>
			        </h:outputLink>
			       
			        </h:panelGrid>
			        </td>
			        <td style="border-bottom:1px solid #C7D7DF;">		

						<h:panelGroup rendered="#{commissioningBean.showAddDelayPanel}">
						<table id="addDelayTable" cellpadding="0" cellspacing="0" style="width: 80%;">
							<tr>
								<td class="editLabelRW" style="width: 35%">${msg['commissioningDelay.delayedToDate']}:</td>
								<td class="" colspan="2"><h:panelGroup>
									<h:message styleClass="error" showSummary="true" showDetail="false"
										for="delayedToDate" />
									<t:inputCalendar id="delayedToDate"
										value="#{commissioningBean.commissioningDelay.delayedToDate}"
										renderAsPopup="true" popupDateFormat="d/MM/yyyy"
										renderPopupButtonAsImage="true"
										popupLeft="true"
										popupTodayString="#{msg['calendar.today']}"
										popupWeekString="#{msg['calendar.week']}" required="true">
											<t:jsValueChangeListener for="endTimeHour" property="value" expressionValue="actualizeTimeFields($srcElem, 'tabActivity');" />
										</t:inputCalendar>
								</h:panelGroup></td>
							</tr>
							<tr>
								<td class="editLabelRW">${msg['commissioningDelay.reason']}:</td>
								<td class="" colspan="2"><h:panelGroup>
									<h:message styleClass="error" showSummary="true" showDetail="false"
										for="delayedToDate" />
									<h:inputTextarea id="reason"
										value="#{commissioningBean.commissioningDelay.reason}" required="true"/>
								</h:panelGroup></td>
							</tr>
							<tr>
								<td colspan="2" align="right">
									<h:commandLink action="#{commissioningBean.hideAddDelay}" immediate="true">
			        					<h:graphicImage value="/img/false.png" styleClass="titleImg" />
			        					<h:outputText>${msg['commissioning.button.cancel']}</h:outputText>
			        				</h:commandLink>
									<h:commandLink action="#{commissioningBean.delay}">
			        					<h:graphicImage value="/img/ico_yes.gif" styleClass="titleImg" />
			        					<h:outputText>${msg['commissioning.addDelay']}</h:outputText>
			        				</h:commandLink>
								</td>
							</tr>
						</table>
						</h:panelGroup>					
				</td>
			</t:htmlTag>


			<%-- Field: budget --%>
			<t:htmlTag id="budgetRow" value="tr" rendered="#{commissioningBean.renderBudget}">
				<td class="editLabelRW">${msg['commissioning.budget']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="budget" />
					<h:inputText id="budget" value="#{commissioningBean.budget}" size="10" readonly="#{!commissioningBean.editBudget}"/>
				</h:panelGroup></td>
			</t:htmlTag>

			<%-- Field: notes --%>
			<t:htmlTag id="notesRow" value="tr" rendered="#{commissioningBean.renderNotes}">
				<td class="editLabelRW">${msg['commissioning.notes']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="notes" />
					<h:inputTextarea id="notes" value="#{commissioningBean.notes}" rows="5" cols="75" readonly="#{!commissioningBean.editNotes}"/>
				</h:panelGroup></td>
			</t:htmlTag>


			<%-- Field: authorSignature --%>
			<t:htmlTag id="authorSignatureRow" value="tr" rendered="#{commissioningBean.renderAuthorSignature}">
				<td class="editLabelRW">${msg['commissioning.authorSignature']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="authorSignature" />
					<h:selectBooleanCheckbox id="authorSignature"
						value="#{commissioningBean.authorSignature}" rendered="#{commissioningBean.editAuthorSignature}"/>
					<t:graphicImage value="/img/true.png" rendered="#{!commissioningBean.editAuthorSignature && commissioningBean.authorSignature}"/>
					<t:graphicImage value="/img/false.png" rendered="#{!commissioningBean.editAuthorSignature && !commissioningBean.authorSignature}"/>
				</h:panelGroup></td>
			</t:htmlTag>


			<%-- Field: reviserSignature --%>
			<t:htmlTag id="reviserSignatureRow" value="tr" rendered="#{commissioningBean.renderReviserSignature}">
				<td class="editLabelRW">${msg['commissioning.reviserSignature']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="reviserSignature" />
					<h:selectBooleanCheckbox id="reviserSignature"
						value="#{commissioningBean.reviserSignature}" rendered="#{commissioningBean.editReviserSignature}"/>
					<t:graphicImage value="/img/true.png" rendered="#{!commissioningBean.editReviserSignature && commissioningBean.reviserSignature}"/>
					<t:graphicImage value="/img/false.png" rendered="#{!commissioningBean.editReviserSignature && !commissioningBean.reviserSignature}"/>
				</h:panelGroup></td>
			</t:htmlTag>


			<%-- Field: adminSignature --%>
			<t:htmlTag id="adminSignatureRow" value="tr" rendered="#{commissioningBean.renderAdminSignature}">
				<td class="editLabelRW">${msg['commissioning.adminSignature']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="adminSignature" />
					<h:selectBooleanCheckbox id="adminSignature"
						value="#{commissioningBean.adminSignature}" rendered="#{commissioningBean.editAdminSignature}"/>
						
					<t:graphicImage value="/img/true.png" rendered="#{!commissioningBean.editAdminSignature && commissioningBean.adminSignature}"/>
					<t:graphicImage value="/img/false.png" rendered="#{!commissioningBean.editAdminSignature && !commissioningBean.adminSignature}"/>
				</h:panelGroup></td>
			</t:htmlTag>


			<%-- Field: justifyInformation --%>
			<t:htmlTag id="justifyInformationRow" value="tr" rendered="#{commissioningBean.renderJustifyInformation}">
				<td class="editLabelRW">${msg['commissioning.justifyInformation']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="justifyInformation" />
					<h:selectBooleanCheckbox id="justifyInformation"
						value="#{commissioningBean.justifyInformation}" rendered="#{commissioningBean.editJustifyInformation}"/>
					<t:graphicImage value="/img/true.png" rendered="#{!commissioningBean.editJustifyInformation && commissioningBean.justifyInformation}"/>
					<t:graphicImage value="/img/false.png" rendered="#{!commissioningBean.editJustifyInformation && !commissioningBean.justifyInformation}"/>
				</h:panelGroup></td>
			</t:htmlTag>


			<%-- Field: developedActivities --%>
			<t:htmlTag id="developedActivitiesRow" value="tr" rendered="#{commissioningBean.renderDevelopedActivities}">
				<td class="editLabelRW">${msg['commissioning.developedActivities']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="developedActivities" />
					<h:inputTextarea id="developedActivities"
						value="#{commissioningBean.developedActivities}" rows="5" cols="75" readonly="#{!commissioningBean.editDevelopedActivities}" required="true"/>
				</h:panelGroup></td>
			</t:htmlTag>


			<%-- Field: difficultiesAppeared --%>
			<t:htmlTag id="difficultiesAppearedRow" value="tr" rendered="#{commissioningBean.renderDifficultiesAppeared}">
				<td class="editLabelRW">${msg['commissioning.difficultiesAppeared']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="difficultiesAppeared" />
					<h:inputTextarea id="difficultiesAppeared"
						value="#{commissioningBean.difficultiesAppeared}" rows="5" cols="75" readonly="#{!commissioningBean.editDifficultiesAppeared}" required="true"/>
				</h:panelGroup></td>
			</t:htmlTag>

			<%-- Field: results --%>
			<t:htmlTag id="resultsRow" value="tr" rendered="#{commissioningBean.renderResults}">
				<td class="editLabelRW">${msg['commissioning.results']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="results" />
					<h:inputTextarea id="results" value="#{commissioningBean.results}"  rows="5" cols="75" readonly="#{!commissioningBean.editResults}" required="true"/>
				</h:panelGroup></td>
			</t:htmlTag>


			<%-- Field: conclusions --%>
			<t:htmlTag id="conclusionsRow" value="tr" rendered="#{commissioningBean.renderConclusions}">
				<td class="editLabelRW">${msg['commissioning.conclusions']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="conclusions" />
					<h:inputTextarea id="conclusions"
						value="#{commissioningBean.conclusions}" rows="5" cols="75" readonly="#{!commissioningBean.editConclusions}" required="true"/>
				</h:panelGroup></td>
			</t:htmlTag>

			<%-- Field: evaluation --%>
			<t:htmlTag id="evaluationRow" value="tr" rendered="#{commissioningBean.renderEvaluation}">
				<td class="editLabelRW">${msg['commissioning.evaluation']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="evaluation" />
					<h:inputTextarea id="evaluation"
						value="#{commissioningBean.evaluation}" readonly="#{!commissioningBean.editEvaluation}" rows="5" cols="75" required="true"/>
				</h:panelGroup></td>
			</t:htmlTag>


			<%-- Field: project --%>
			<t:htmlTag id="projectRow" value="tr" rendered="#{commissioningBean.renderProject}">
				<td class="editLabelRW">${msg['commissioning.project']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="project" />
					<h:selectOneMenu id="project" value="#{commissioningBean.project}" readonly="#{!commissioningBean.editProject}">
						<f:selectItems value="#{commissioningBean.projects}" />
						<f:converter converterId="autentia.EntityConverter" />
					</h:selectOneMenu>
				</h:panelGroup></td>
			</t:htmlTag>



			<%-- Commissioning - generated by stajanov (do not edit/delete) --%>

			<%-- Field: revisers 
			<t:htmlTag id="revisersRow" value="tr" rendered="#{commissioningBean.renderRevisers}">
				<td class="editLabelRW">${msg['commissioning.revisers']}:</td>

				<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="revisers" />
					<h:selectManyListbox id="revisers" value="#{commissioningBean.revisers}" disabled="#{!commissioningBean.editRevisers}">
						<f:selectItems value="#{commissioningBean.allRevisers}" />
							<f:converter converterId="autentia.EntityConverter"/>
							<f:attribute name="com.autentia.tnt.converter.EntityConverter.valueClass" 
		                           value="com.autentia.tnt.businessobject.User"/> 
					</h:selectManyListbox>
				</h:panelGroup></td>
			</t:htmlTag>
--%>

			<t:htmlTag id="revisersRow" value="tr" rendered="#{commissioningBean.renderRevisers}">
				<td class="editLabelRW">${msg['commissioning.revisers']}:</td>

				<td class="editFieldCell" colspan="2">
					<h:panelGroup>
						<h:selectOneMenu id="revisersList" value="#{commissioningBean.selectedReviser}" disabled="#{!commissioningBean.editRevisers}">
							<f:selectItems value="#{commissioningBean.allRevisers}" />
							<f:converter converterId="autentia.EntityConverter"/>
							<f:attribute name="com.autentia.tnt.converter.EntityConverter.valueClass" 
	                         	  value="com.autentia.tnt.businessobject.User"/> 
						</h:selectOneMenu>
						<h:commandLink action="#{commissioningBean.addReviser}" rendered="#{commissioningBean.editRevisers}">
							<h:graphicImage value="/img/add.png" styleClass="titleImg" />
						</h:commandLink>
						<h:message styleClass="error" showSummary="true" showDetail="false"
							for="revisers" />
						
						<t:dataTable id="revisers" var="reviserData"
						value="#{commissioningBean.commissioningRevisers}"
						preserveDataModel="false" cellpadding="0" cellspacing="0"
						styleClass="listTable" headerClass="listHeaderCell"
						footerClass="listFooter" rows="#{settingBean.mySettings.listSize}"
						rowClasses="listRowO,listRowE"
						columnClasses="listCmdCell,listCommissioningId,listCommissioningRequestDate,listCommissioningName,listCommissioningScope,listCommissioningContent,listCommissioningProducts,listCommissioningDeliveryDate,listCommissioningBudget,listCommissioningNotes,listCommissioningAuthorSignature,listCommissioningReviserSignature,listCommissioningAdminSignature,listCommissioningJustifyInformation,listCommissioningDevelopedActivities,listCommissioningDifficultiesAppeared,listCommissioningResults,listCommissioningConclusions,listCommissioningEvaluation,listCommissioningStatus,listCommissioningInsertDate,listCommissioningUpdateDate,listCommissioningReviser,listCommissioningProject"
						rowOnMouseOver="this.savedClassName=this.className;this.className='listRowSel';"
						rowOnMouseOut="this.className=this.savedClassName;">
						
							<h:column rendered="#{commissioningBean.editRevisers}">
								<f:facet name="header">
									<f:verbatim>-</f:verbatim>
								</f:facet>
								<h:commandLink action="#{commissioningBean.deleteReviser}">
									<h:graphicImage value="/img/delete.gif" styleClass="titleImg" />
								</h:commandLink>
							</h:column>
				
							<h:column>
								<f:facet name="header">
									<f:verbatim>${msg['collaborator.name']}</f:verbatim>
								</f:facet>
								<h:outputText value="#{reviserData.name}"  />
							</h:column>
						</t:dataTable>
					</h:panelGroup>
				</td>
			</t:htmlTag>




			<%-- Field: collaborators --%>
			<t:htmlTag id="collaboratorsRow" value="tr" rendered="#{commissioningBean.renderCollaborators}">
			<td class="editLabelRW">${msg['commissioning.collaborators']}:</td>
			<td class="editFieldCell" colspan="2"><h:panelGroup>
					<h:selectOneMenu id="collaboratorsList" value="#{commissioningBean.selectedCollaborator}" disabled="#{!commissioningBean.editPaymentMode}">
						<f:selectItems value="#{commissioningBean.allCollaborators}" />
						<f:converter converterId="autentia.EntityConverter"/>
						<f:attribute name="com.autentia.tnt.converter.EntityConverter.valueClass" 
                         	  value="com.autentia.tnt.businessobject.Collaborator"/> 
					</h:selectOneMenu>
					<h:commandLink action="#{commissioningBean.addCollaborator}" rendered="#{commissioningBean.changeCollaborators}">
						<h:graphicImage value="/img/add.png" styleClass="titleImg" />
					</h:commandLink>
					<h:message styleClass="error" showSummary="true" showDetail="false"
						for="collaborators" />
					
					<t:dataTable id="collaborators" var="collPayData"
					value="#{commissioningBean.collaboratorsPaymentData}"
					preserveDataModel="false" cellpadding="0" cellspacing="0"
					styleClass="listTable" headerClass="listHeaderCell"
					footerClass="listFooter" rows="#{settingBean.mySettings.listSize}"
					rowClasses="listRowO,listRowE"
					columnClasses="listCmdCell,listCommissioningId,listCommissioningRequestDate,listCommissioningName,listCommissioningScope,listCommissioningContent,listCommissioningProducts,listCommissioningDeliveryDate,listCommissioningBudget,listCommissioningNotes,listCommissioningAuthorSignature,listCommissioningReviserSignature,listCommissioningAdminSignature,listCommissioningJustifyInformation,listCommissioningDevelopedActivities,listCommissioningDifficultiesAppeared,listCommissioningResults,listCommissioningConclusions,listCommissioningEvaluation,listCommissioningStatus,listCommissioningInsertDate,listCommissioningUpdateDate,listCommissioningReviser,listCommissioningProject"
					rowOnMouseOver="this.savedClassName=this.className;this.className='listRowSel';"
					rowOnMouseOut="this.className=this.savedClassName;">
					
					<h:column rendered="#{commissioningBean.changeCollaborators}">
						<f:facet name="header">
							<f:verbatim>-</f:verbatim>
						</f:facet>
						<h:commandLink action="#{commissioningBean.deleteCollaborator}">
							<h:graphicImage value="/img/delete.gif" styleClass="titleImg" />
						</h:commandLink>
					</h:column>
		
					<h:column>
						<f:facet name="header">
							<f:verbatim>${msg['collaborator.name']}</f:verbatim>
						</f:facet>
						<h:outputText value="#{collPayData.collaborator.name}"  />
					</h:column>
		
					<h:column>
						<f:facet name="header">
							<f:verbatim>${msg['commissioning.paymentMode']}</f:verbatim>
						</f:facet>
				 		<h:selectOneMenu id="paymentMode" value="#{collPayData.paymentMode}" disabled="#{!commissioningBean.editPaymentMode}">
							<f:converter converterId="autentia.EnumConverter" />
							<f:selectItems value="#{commissioningBean.paymentModes}" />
						</h:selectOneMenu>
					</h:column>
					
					<h:column>
						<f:facet name="header">
							<f:verbatim>${msg['commissioning.bankAccount']}</f:verbatim>
						</f:facet>
				 		<h:inputText id="bankAccount" value="#{collPayData.bankAccount}" size="20" readonly="#{!commissioningBean.editPaymentMode}"/>
					</h:column>
					
					<h:column>
						<f:facet name="header">
							<f:verbatim>${msg['commissioning.billNumber']}</f:verbatim>
						</f:facet>
				 		<h:inputText id="billNumber" value="#{collPayData.billNumber}" size="20" readonly="#{!commissioningBean.editPaymentMode}"/>
					</h:column>
					
				</t:dataTable>
					
				</h:panelGroup></td>
			</t:htmlTag>

			
			<%-- Field: file --%>
          <t:htmlTag id="files" value="tr" rendered="#{!commissioningBean.newCommissioning}">
            <td class="editLabelRW">${msg['commissioning.files']}:</td>
            <td class="editFieldCell" colspan="2">
            
			   <t:inputFileUpload id="file" size="58" maxlength="400" value="#{commissioningBean.uploadFile}" storage="file" />
     			<h:message styleClass="error" showSummary="true" showDetail="false" for="file" />
            	<t:dataTable id="list" var="commissioningFile"
					value="#{commissioningBean.files}"
					preserveDataModel="false" cellpadding="0" cellspacing="0"
					styleClass="listTable" headerClass="listHeaderCell"
					footerClass="listFooter" rows="#{settingBean.mySettings.listSize}"
					rowClasses="listRowO,listRowE"
					columnClasses="listCmdCell,listCommissioningId,listCommissioningRequestDate,listCommissioningName,listCommissioningScope,listCommissioningContent,listCommissioningProducts,listCommissioningDeliveryDate,listCommissioningBudget,listCommissioningNotes,listCommissioningAuthorSignature,listCommissioningReviserSignature,listCommissioningAdminSignature,listCommissioningJustifyInformation,listCommissioningDevelopedActivities,listCommissioningDifficultiesAppeared,listCommissioningResults,listCommissioningConclusions,listCommissioningEvaluation,listCommissioningStatus,listCommissioningInsertDate,listCommissioningUpdateDate,listCommissioningReviser,listCommissioningProject"
					rowOnMouseOver="this.savedClassName=this.className;this.className='listRowSel';"
					rowOnMouseOut="this.className=this.savedClassName;">
		
		
					<h:column>
						<f:facet name="header">
							<f:verbatim>-</f:verbatim>
						</f:facet>
						<h:commandLink action="#{commissioningBean.deleteFile}">
							<h:graphicImage value="/img/delete.gif" styleClass="titleImg" />
						</h:commandLink>
					</h:column>
		
					<h:column>
						<f:facet name="header">
							<f:verbatim>${msg['commissioningFile.insertDate']}</f:verbatim>
						</f:facet>
		
						<h:outputText value="#{commissioningFile.insertDate}"
							converter="autentia.dateConverter" />
		
					</h:column>
		
					<h:column>
						<f:facet name="header">
							<f:verbatim>${msg['commissioningFile.file']}</f:verbatim>
						</f:facet>
				 
				 		<h:commandLink onclick="openFile('commissioning', #{commissioningBean.id}, '#{commissioningFile.file}','#{commissioningFile.fileMime}'); return false;">
							<h:graphicImage value="/img/yellow-folder-open.png" style="border:0; vertical-align:middle;"/>
							<h:outputText value="#{commissioningFile.file}"/>
						</h:commandLink>
						 
		
					</h:column>
					
				</t:dataTable>
              
            </td>
          </t:htmlTag>
          
		</table>
	</h:form>
<%--</tr:document>--%>
</f:view>


</body>
</html>


