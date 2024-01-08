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
    <p><a href="${pageContext.request.contextPath}/logout">Logout</a></p>
    <p><a href="${pageContext.request.contextPath}/image">Image</a></p>
    <a href="/note">Note</a>

    <h2>User Info: ${user.fullname}</h2>

    <h3>Update User info</h3>
    <form method="post" action="${pageContext.request.contextPath}/user/update">
        Full name:<input type="text" name="fullname" value="${user.fullname}">
        <button type="submit">Change info</button>
    </form>

    <p>Carefully with delete account! <a href="${pageContext.request.contextPath}/user/delete">Delete account</a> </p>

</c:if>
<c:if test="${sessionScope.user == null}">
    <p><a href="${pageContext.request.contextPath}/login">Login</a></p>
    <a href="${pageContext.request.contextPath}/signUp">Sign Up</a>
</c:if>
</body>
</html>
