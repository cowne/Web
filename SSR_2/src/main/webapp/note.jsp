<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Note page</title>
</head>
<body>
<h1>This is the note page.</h1>
<table align="center">
    <tr>
        <th>Note</th>
        <th>Action</th>
    </tr>

        <c:forEach items="${listNote}" var="x">
            <tr>
                <th>${x.content}</th>
                <th>
                    <a href="/note?action=delete&id=${x.id}">Delete</a>
                    <a href="/note?action=update&id=${x.id}">Update</a>
                </th>
            </tr>
        </c:forEach>

</table>

<form action="/note" method="post">
    Enter your note:<input type="text" name="note">
    <button type="submit">Note</button>
</form>
</body>
</html>
