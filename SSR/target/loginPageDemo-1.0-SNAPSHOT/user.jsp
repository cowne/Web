<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/23/2023
  Time: 9:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
<h1>Hello ${username}</h1>
<h3>User info</h3>
<p>Firstname: ${firstname}</p>
<p>Lastname: ${lastname}</p>
<p>${message}</p>
<h3>Edit user info</h3>

<form action="/update" method="post">
    First name:<input type="text" name="firstname"><br>
    Last name:<input type="text" name="lastname"><br>
    <input type="hidden" value="${username}" name="username">
    <button type="submit">Update</button>
</form>

<form action="/delete" method="post">
    <input type="hidden" value="${username}" name="username">
    <button type="submit">Delete account</button>
</form>
<a href="/image?username=${username}">Image Gallery.</a>
</body>
</html>
