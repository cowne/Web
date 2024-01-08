<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/8/2024
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update note content</title>
</head>
<body>
        <form method="post" action="${pageContext.request.contextPath}/note/update">
            Enter your content:<input type="text" name="content">
            <input type="hidden" value="${id}" name="id">
            <button type="submit">Change the content</button>
        </form>
</body>
<a href="${pageContext.request.contextPath}/note">Back to the note page.</a>
</html>
