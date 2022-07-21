<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>JSP - Hello World</title>
</head>

<body>


<form action="userServlet" method="post">
    <input type="hidden" name="page" value="login">
    <div class="container">
        <div class="form-group">
            <label for="exampleInputEmail1">UserName</label>
            <input type="text" name="userName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter UserName">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1"
                   placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary">LOGIN</button>

        <a href="userServlet?page=newUser">Not  a member Click to register: </a>
    </div>
</form>

</body>
<script>
    var popMesssage = document.getElementById("exampleInputEmail1");
    if(popMesssage == null){
        alert("please enter a UserName");
    }
    var popMesssage1 = document.getElementById("exampleInputPassword1");
    if(popMesssage == null){
        alert("please enter a PassWord");
    }
</script>
</html>