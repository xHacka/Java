<%--
  Created by IntelliJ IDEA.
  User: pvpga
  Date: 01.11.2023
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>H+ Sports</title>
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
            margin: 30px 0;
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
        <td><img src="https://images.unsplash.com/photo-1497032628192-86f99bcd76bc" alt="work" style="width: 400px;">
        </td>
    </tr>
    <tr>
        <td width="100%" colspan="2">
            <table width="100%" style="height: 150px" align="left" cellpadding="0" cellspacing="0" border="0">
                <tbody>
                <tr>
                    <td align="center" width="100%" valign="middle">
                        <form id="item-form"
                              name="task-form"
                              method="post"
                              action="catalogServlet3"
                              enctype="application/x-www-form-urlencoded">
                            <div>
                                <label for="name">Product Name:</label>
                                <input id="productName" type="text" name="name"/>
                            </div>
                            <div>
                                <label for="manufacturer">Manufacturer:</label>
                                <input type="text" name="manufacturer"/>
                            </div>
                            <div>
                                <label for="sku">SKU:</label>
                                <input type="text" name="sku"/>
                            </div>
                            <input type="submit" value="Submit"/>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
        </td>
    </tr>
    <tr>
        <td colspan="2" valign="bottom" height="1" width="100%" bgcolor="#CAD6E0"></td>
    </tr>
    </tbody>
</table>
<script>
    document.addEventListener("DOMContentLoaded", function (event) {
        document.getElementById("item-form").style.animation = "shake .5s";
    });
</script>
</body>
</html>

