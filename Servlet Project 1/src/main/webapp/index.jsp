<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action = "ProfileServlet" method="POST">
    <input type="text" name = "userName" placeholder="Enter your Name">
    <input type="password" name = "password" placeholder="Enter Password">
    <br>
    <input type="radio" id="male" name="gender" value="Male"> Male
    <input type="radio" id="female" name="gender" value="FeMale"> Female
    <br>
    <select name="" id="">
        <option value=""></option>
        <option value=""></option>
        <option value=""></option>
    </select>
    <br>
    // select.javas#>subject*3
    <br>
    <select name="subject" id="" class="javas">
        <option value="Java">Java</option>
        <option value="Js">Js</option>

    </select>
    <br>
    <input type="checkbox"  name="interest" value="Cycling">Cycling
    <input type="checkbox"  name="interest" value="Hiking">Hiking

    <input type="submit" value="submit">

</form>
</body>
</html>