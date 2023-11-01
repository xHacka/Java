<%@ page import="com.example.lecture2.Student" %>
<%@ page import="com.example.lecture2.StudentSingleton" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.ParseException" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        td, th {
            border: 1px solid #777;
            padding: 0.5rem;
            text-align: center;
        }

        table {
            border-collapse: collapse;
        }

        tbody tr:nth-child(odd) {
            background: #eee;
        }

        caption {
            font-size: 0.8rem;
        }
    </style>
</head>
<body>
<form action="addStudent.jsp" method="GET">
    <label>Name: </label><input type="text" placeholder="Name" name="name"><br>
    <label>Lastname: </label><input type="text" placeholder="Lastname" name="lastname"><br>
    <label>Age: </label><input type="number" placeholder="Age" name="age"><br>
    <button type="submit">Submit</button>
</form>

<%
    List<Student> students = StudentSingleton.getInstance().getStudents();
    String table =
            "<table>" +
            "  <tr>" +
            "   <th>Name</th>" +
            "   <th>Lastname</th>" +
            "   <th>Age</th>" +
            " <tr>";
    for (Student student : students) {
        table += String.format(
                "<tr>" +
                "    <td>%s</td>" +
                "    <td>%s</td>" +
                "    <td>%d</td>" +
                "<tr>",
                student.getName(),
                student.getLastname(),
                student.getAge()
        );
    }
    table += "</table>";
%>

<%= table %>

</body>
</html>