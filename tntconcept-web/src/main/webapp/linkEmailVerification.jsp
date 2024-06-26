<%@page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Objects, com.autentia.tnt.bean.LinkBean" %>
<%@include file="/inc/tlibs.jsp" %>

<f:loadBundle basename="com.autentia.tnt.resources.messages" var="msg"/>
<html>
<head title="">
    <%@include file="/inc/uiCore.jsp" %>
</head>
<f:view>
    <%@include file="/inc/publicHeader.jsp" %>
    <body marginwidth="0" marginheight="0">
    <%
        String method = request.getMethod();
        if (Objects.equals(method, "GET")) {
            String link = request.getParameter("link");
            LinkBean linkBean = new LinkBean();
            String password = linkBean.checkLinkAndResetPassword(link);
    %>

    <div style="top:50px; text-align: center">
        <p><%= password %></p>
    </div>
    <% } %>
    </body>
</f:view>

</html>


