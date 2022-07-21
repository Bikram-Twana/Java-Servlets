<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 6/26/2022
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    if(session != null){
        String pass = (String) session.getAttribute("user");
        PrintWriter printWriter = response.getWriter();
        out.println("From welcome: Your password is : " + pass);
    }
    else{
        response.sendRedirect("index.jsp");
    }
%>
<form action="WelcomeServlet" method="post">
    <input type="submit" value="Logout">
</form>
    Welcome from welcome jsp.
</body>
</html>
