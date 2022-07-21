<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 7/3/2022
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NavBar</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>


<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Login Form</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="userServlet?page=dash">Home</a></li>
                <li><a href="userServlet?page=liUser">List of User</a></li>
                <li><a href="userServlet?page=logout">Logout</a></li>

            </ul>
        </div>
    </nav>



</body>
</html>
