<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/28/2023
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <p>${message}</p>
    <h1 align="center" style="color: red">Sign up</h1>
    <div align="center">
        <form action="/signUp" method="post">
            Full name:<input type="text" name="fullname"><br>
            Username:<input type="text" name="username"><br>
            Password:<input type="password" name="password"><br>
            Confirm password:<input type="password" name="confirmPassword"><br>
            <button type="submit">Create account</button>
        </form>
    </div>
</body>
</html>
