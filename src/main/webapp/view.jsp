<%@ page import="com.example.quiz1.Car" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.quiz1.CarFactory" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>View</title>
</head>
<body>

<%

%>


<%
    List<Car> cars = CarFactory.getInstance().getCars();
    String table =
            "<table>" +
            "  <tr>" +
            "   <th>Name</th>" +
            "   <th>Model</th>" +
            "   <th>Color</th>" +
            "  <tr>";
    for (Car car : cars) {
        table += String.format(
                "<tr>" +
                "    <td>%s</td>" +
                "    <td>%s</td>" +
                "    <td>%s</td>" +
                "<tr>",
                car.getName(),
                car.getModel(),
                car.getColor()
        );
    }
    table += "</table>";
%>

<%= table %>

</body>
</html>