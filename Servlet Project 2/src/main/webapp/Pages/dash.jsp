<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 7/1/2022
  Time: 5:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<%@ include file="../includes/navBar.jsp"%>

<div>
    <p>
        <h3>You are a valid user.</h3>
    </p>
</div>

<%

  out.println("welcome to dash.");
  if(session != null){
      String fullName = (String) session.getAttribute("fullName");
      out.println("Hello " + fullName);
  }

  //RequestDispatcher requestDispatcher = request.getRequestDispatcher("listUser.jsp");
//  requestDispatcher.forward(request,response);
%>
    <!-- <a href="userServlet?page=liUser">Show Table </a> -->

</body>
</html>
