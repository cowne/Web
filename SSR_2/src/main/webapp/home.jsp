<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/28/2023
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Welcome to home page</h1>
<p style="color:red;" align="center">${message}</p>
<c:if test="${sessionScope.user != null}">
    <h2>Hello ${sessionScope.user.username}</h2>
    <p><a href="/logout?action=logout">Logout</a></p>
    <p><a href="#">Image</a></p>
    <a href="#">Note</a>

    <h2>User Info: ${user.fullname}</h2>

    <h3>Update User info</h3>
    <form method="post" action="<c:url value='/change-info'/>">
        Full name:<input type="text" name="fullname">
        <input type="hidden" name="action" value="changeName">
        <button type="submit">Change info</button>
    </form>

    <form method="post" action="/delete">
        <input type="hidden" name="action" value="deleteAccount">
        <button type="submit">Delete account</button>
    </form>

</c:if>
<c:if test="${sessionScope.user == null}">
    <p><a href="/login">Login</a></p>
    <a href="/signUp">Sign Up</a>
</c:if>
</body>
</html>
