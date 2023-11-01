<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="dbConnection.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>

<%--
<form action="view.jsp" method="post">
  <label for="name">Name: </label><input type="text" name="name" placeholder="Car Name" />
  <label for="model">Model: </label><input type="text" name="model" placeholder="Car Model" />
  <label for="color">Color: </label><input type="text" name="color" placeholder="Car Color" />
</form>
--%>

<a href="addStudent.jsp">Add Student...</a>

<sql:query var="result" dataSource="${db}">
  SELECT * FROM students;
</sql:query>

<table>
  <tr>
    <th>ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Action</th>
    <th>Action</th>
  </tr>

  <c:forEach items="${result.rows}" var="student">
    <tr>
      <td>${student.id}</td>
      <td>${student.first_name}</td>
      <td>${student.last_name}</td>
      <td><a href="addStudent.jsp?id=${student.id}">Update</a></td>
      <td><a href="deleteStudent.jsp?id=${student.id}">Delete</a></td>
    </tr>
  </c:forEach>

</table>

</body>
</html>