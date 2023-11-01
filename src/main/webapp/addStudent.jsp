<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/7/2023
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="dbConnection.jsp"%>
<html>
<head>
    <title>Title</title>
    <style>
        :root {
            --primary: #50b3b7
        }

        html {
            height: 100%;
        }

        body {
            margin: 0;
            padding: 0;
            font-family: sans-serif;
            background: linear-gradient(#141e30, #243b55);
        }

        .login-box {
            position: absolute;
            top: 50%;
            left: 50%;
            width: 400px;
            padding: 40px;
            transform: translate(-50%, -50%);
            background: rgba(0, 0, 0, .5);
            box-sizing: border-box;
            box-shadow: 0 15px 25px rgba(0, 0, 0, .6);
            border-radius: 10px;
        }

        .login-box h2 {
            margin: 0 0 30px;
            padding: 0;
            color: #fff;
            text-align: center;
        }

        .login-box .user-box {
            position: relative;
        }

        .login-box .user-box input {
            width: 100%;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            margin-bottom: 30px;
            border: none;
            border-bottom: 1px solid #fff;
            outline: none;
            background: transparent;
        }

        .login-box .user-box label {
            position: absolute;
            top: 0;
            left: 0;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            pointer-events: none;
            transition: .5s;
        }

        .login-box .user-box input:focus ~ label,
        .login-box .user-box input:valid ~ label {
            top: -20px;
            left: 0;
            color: var(--primary);
            font-size: 12px;
        }

        .login-box form input {
            position: relative;
            display: inline-block;
            padding: 10px 20px;
            color: var(--primary);
            font-size: 16px;
            text-decoration: none;
            text-transform: uppercase;
            overflow: hidden;
            transition: .5s;
            margin-top: 40px;
            letter-spacing: 4px
        }

        .login-box input:hover {
            background: var(--primary);
            color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 5px var(--primary),
            0 0 25px var(--primary),
            0 0 50px var(--primary),
            0 0 100px var(--primary);
        }

        @keyframes btn-anim1 {
            0% {
                left: -100%;
            }
            50%, 100% {
                left: 100%;
            }
        }

        @keyframes btn-anim2 {
            0% {
                top: -100%;
            }
            50%, 100% {
                top: 100%;
            }
        }


        @keyframes btn-anim3 {
            0% {
                right: -100%;
            }
            50%, 100% {
                right: 100%;
            }
        }


        @keyframes btn-anim4 {
            0% {
                bottom: -100%;
            }
            50%, 100% {
                bottom: 100%;
            }
        }
    </style>
</head>
<body>
<%
    String id = request.getParameter("id");
    if (id != null || id != "") { %>
        <sql:query var="result" dataSource="${db}">
            SELECT * FROM students LIMIT 1;
        </sql:query>
    <%
    }
%>
<div class="login-box">
    <h2>Add Student</h2>
    <form action="checkData.jsp" target="_self" method="post">
        <div class="user-box">
            <input type="text" name="first_name" required="">
            <label for="first_name">First Name</label>
        </div>
        <div class="user-box">
            <input type="text" name="last_name" required="">
            <label for="last_name">Last Name</label>
        </div>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>

<%--<form action="checkData.jsp" target="_self" method="post">--%>
<%--  <label for="first_name">First Name: </label><input type="text" name="first_name" />--%>
<%--  <label for="last_name">Last Name: </label><input type="text" name="last_name" />--%>
<%--  <input type="submit" value="Submit">--%>
<%--</form>--%>