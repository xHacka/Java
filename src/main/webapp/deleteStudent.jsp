<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/7/2023
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="dbConnection.jsp"%>

<c:set var="id" value="<%= request.getParameter("id") %>" />

<sql:update dataSource="${db}" var="count">
    DELETE FROM students WHERE id=?
    <sql:param value="${id}" />
</sql:update>

<c:redirect url="index.jsp"/>