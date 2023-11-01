<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/7/2023
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String firstName = request.getParameter("first_name");
    String lastName = request.getParameter("last_name");
%>

<ul>
    <li><%= firstName %></li>
    <li><%= lastName  %></li>
</ul>

<a href="saveRecord.jsp?first_name=<%= firstName %>&last_name=<%= lastName %>">Save Record</a>

</body>
</html>
