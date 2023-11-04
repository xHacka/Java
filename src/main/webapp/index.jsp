<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Quiz 3</title>
    <style>
        table {
            border-collapse: collapse;
        }

        label {
            display: inline-block;
            width: 120px;
        }

        form {
            padding: 20px;
        }

        form div {
            margin: 30px 0px;
        }

        @keyframes shake {
            0% {
                transform: translate(1px, 1px) rotate(0deg);
            }
            10% {
                transform: translate(-1px, -2px) rotate(-1deg);
            }
            20% {
                transform: translate(-3px, 0px) rotate(1deg);
            }
            30% {
                transform: translate(3px, 2px) rotate(0deg);
            }
            40% {
                transform: translate(1px, -1px) rotate(1deg);
            }
            50% {
                transform: translate(-1px, 2px) rotate(-1deg);
            }
            60% {
                transform: translate(-3px, 1px) rotate(0deg);
            }
            70% {
                transform: translate(3px, 1px) rotate(-1deg);
            }
            80% {
                transform: translate(-1px, -1px) rotate(1deg);
            }
            90% {
                transform: translate(1px, 2px) rotate(0deg);
            }
            100% {
                transform: translate(1px, -2px) rotate(-1deg);
            }
        }

        body {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-size: 14px;
        }

        .header {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-size: 18px;
        }

        .bottom {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-size: 9px;
            text-align: center;
            vertical-align: middle;
            color: #8E969D;
        }
    </style>
</head>
<body>

<br/>

<a href="addPost.jsp" >Add New Post</a>

<br/>

<table style="border: 1px solid #CAD6E0" align="center" cellpadding="0"
       cellspacing="0" border="0" width="400">
    <tbody>
    <tr>
        <td class="header" height="42" align="center" valign="middle"
            width="100%" bgcolor="#E4EBEB">Entry Form | Catalog
        </td>
    </tr>
    <tr>
        <td height="1" width="100%" bgcolor="#CAD6E0"></td>
    </tr>
    <tr>
        <td width="100%" colspan="2">
            <table width="100%" style="height: 150px" align="left" cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <th>ID</th>
                    <th>Author</th>
                    <th>Title</th>
                    <th>Content</th>
                    <th>Views</th>
                </tr>
                <c:forEach items="${posts}" var="post">
                    <tr>
                        <td><c:out value="${post.id}"/></td>
                        <td><c:out value="${post.author}"/></td>
                        <td><c:out value="${post.title}"/></td>
                        <td><c:out value="${post.content}"/></td>
                        <td><c:out value="${post.views}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
    <tr>
        <td colspan="2" valign="bottom" height="1" width="100%" bgcolor="#CAD6E0"></td>
    </tr>
    </tbody>
</table>
</body>
</html>
