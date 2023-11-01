<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/7/2023
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="dbConnection.jsp"%>
<%
    String firstName = request.getParameter("first_name");
    String lastName = request.getParameter("last_name");
%>



<c:set var="first_name" value="<%= firstName %>" />
<c:set var="last_name" value="<%= lastName %>" />
<sql:update dataSource="${db}" var="count">
    INSERT INTO students (first_name, last_name) VALUES (?, ?)
    <sql:param value="${first_name}" />
    <sql:param value="${last_name}" />
</sql:update>

<c:redirect url="index.jsp"/>