<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/23/2023
  Time: 7:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<p>${message}</p>
<form method="post" action="/login">
    username:<input type="text" name=username><br>
    password:<input type="password" name="password"><br>
    <button type="submit">Login</button>
</form>
</body>
</html>
