<%@ page import="java.util.ArrayList" %>
<%@ page import="model.User" %>
<%@ page import="Service.UserService" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 7/1/2022
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserList</title>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<%@ include file="../includes/navBar.jsp"%>


<table border="2">
    <tr>
        <th>User ID</th>
        <th>User Name</th>
        <th>Full Name</th>
        <th>Password</th>

        <th>Services</th>
        <th>User Details</th>
    </tr>
    <tbody>
    <c:forEach items="${list}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.userName}</td>
        <td>${user.fullName}</td>
        <td>${user.password}</td>

        <td><a href = "userServlet?page=addNew">AddUser</a>
        </td>
        <td><a href="userServlet?page=userDetails&id=${user.id}">View details.</a></td>

    </tr>
    </c:forEach>
    </tbody>

</table>
<%

%>

</body>
</html>
