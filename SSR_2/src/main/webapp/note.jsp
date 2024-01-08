<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Note page</title>
</head>
<body>
<h1>This is the note page.</h1>
<p>${message}</p>
<table align="center">
    <tr>
        <th>Note</th>
        <th>Action</th>
    </tr>

        <c:forEach items="${listNote}" var="x">
            <tr>
                <th>${x.content}</th>
                <th>
                    <a href="${pageContext.request.contextPath}/note/delete?id=${x.id}">Delete</a>
                    <a href="${pageContext.request.contextPath}/note/update?id=${x.id}">Update</a>
                </th>
            </tr>
        </c:forEach>

</table>

<form action="/note" method="post">
    Enter your note:<input type="text" name="content">
    <button type="submit">Note</button>
</form>

<a href="${pageContext.request.contextPath}/user">Back to the user page.</a>
</body>
</html>
