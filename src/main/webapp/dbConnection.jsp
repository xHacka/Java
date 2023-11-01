<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/7/2023
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<sql:setDataSource
    var="db"
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/db"
    user="root"
    password=""
/>
