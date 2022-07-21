<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 7/4/2022
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="userServlet?page=editUser" method="post">
    <input type="text" name = "id" value="${user.id}">
    <input type="text" name="userName" value="${user.userName}">
    <input type="text" name="fullName" value="${user.fullName}">
    <input type="password" name="password" value="${user.password}">
    <input type="submit" value="Edit">
</form>

</body>
</html>
