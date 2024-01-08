<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/28/2023
  Time: 8:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<div align="center">
    <h1 style="color:red;">Login page</h1>
    <form action="/login" method="post" >
        <p>${message}</p>
        Username:<input type="text" name="username"><br>
        Password:<input type="password" name="password"><br>
        <button type="submit">Log in</button>
    </form>
</div>

<p>You don't have an account? <a href="/signUp">Sign up in here</a> </p>
</body>
</html>
