<%@ page import="com.example.lecture2.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lecture2.StudentSingleton" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 9/30/2023
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student</title>
</head>
<body>

<%
  List<Student> students = StudentSingleton.getInstance().getStudents();
  String name = request.getParameter("name");
  String lastname = request.getParameter("lastname");
  String age = request.getParameter("age");
  String error= null;
  if (name == null || name == "")              { error = "name Cant Be Null!";     }
  else if (lastname == null || lastname == "") { error = "lastname Cant Be Null!"; }
  else if (age == null || age == "")           { error = "age Cant Be Null!";      }
  else {
    try {
      Integer ageAsInt = Integer.parseInt(age);
      students.add(new Student(name, lastname, ageAsInt));
    }
    catch (NumberFormatException e) { error = "age Is Not A Number!"; }
  }

  if (error != null) { response.sendError(418, error); }
  else { response.sendRedirect("student.jsp"); }
%>

</body>
</html>
