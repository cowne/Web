<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/26/2023
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
    <h1>Create account.</h1>
    <p>${message}</p>
<form method="post" action="/signUp">
    Firstname:<input type="text" name="firstname"><br>
    Lastname:<input type="text" name="lastname"><br>
    Username:<input type="text" name="username"><br>
    Password:<input type="password" name="password"><br>
    Confirm password:<input type="password" name="confirmPassword"><br>
    <button type="submit">Create account</button>
</form>
</body>
</html>
