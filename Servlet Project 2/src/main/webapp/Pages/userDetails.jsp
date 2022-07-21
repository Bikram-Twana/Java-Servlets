<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 7/4/2022
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table" border="2">
    <tr>
        <th>ID</th>
        <td>${user.id}</td>
    </tr>
    <tr>
        <th>UserName</th>
        <td>${user.userName}</td>
    </tr>
    <tr>
        <th>Full Name</th>
        <td>${user.fullName}</td>
    </tr>
    <tr>
        <th>Password</th>
        <td>${user.password}</td>
    </tr>
    <tr>
        <td><a href="userServlet?page=userEdit&id=${user.id}">Edit</a> </td>
        <td><a href="userServlet?page=userDelete&id=${user.id}">Delete</a> </td>
    </tr>
</table>

</body>
</html>
