<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 11/4/2023
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz 3 - Add Post</title>
    <style>
        body {
            font-family: sans-serif;
        }

        form {
            width: 500px;
            margin: 0 auto;
        }

        input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #000;
            color: #fff;
        }
    </style>
</head>
<body>

<form action="addPost" method="POST">
    <h1>Post Form</h1>

    <label for="author">Author:</label>
    <input type="text" name="author" placeholder="Enter Author">

    <label for="title">Title:</label>
    <input type="text" name="title" placeholder="Enter Title">

    <label for="content">Content:</label>
    <textarea name="content" placeholder="Enter Content"></textarea>

    <input type="submit" value="Submit">
</form>

</body>
</html>
