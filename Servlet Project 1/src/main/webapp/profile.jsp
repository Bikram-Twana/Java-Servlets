<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>
</head>
<body>
<%
    if(session !=null){


        String name = (String) session.getAttribute("nm");

        out.println("This is profile: " +name);

    }
    //session.setAttribute("foo", name);
%>
<a href="PrfServlet">Profile</a>
<a href="DashboardServlet">Dashboard</a>
<form action="LogoutServlet" method="post">

    <input type="submit" value="logout">

</form>
</body>
</html>



//