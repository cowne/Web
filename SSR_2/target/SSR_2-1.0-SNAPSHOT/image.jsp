<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/30/2023
  Time: 8:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Image Gallery</title>
</head>
<body>
<p>${message}</p>
<h1 align="center">Image Gallery</h1>
<div align="center">
    <form method="post" action="/image" enctype="multipart/form-data">
        Select Image:<input type="file" name="image">
        <input type="hidden" value="addImage" name="action">
        <button type="submit">Add image</button>
    </form>
</div>
<div align="center">
    <table border="5px" style="width: 400px">
        <tr>
            <th>Image</th>
            <th>Action</th>
        </tr>
        <jsp:useBean id="imageName" scope="request" type="java.util.List"/>
        <c:forEach items="${imageName}" var="x">
            <tr>
                <th><img src="img/${x.name}" width="400" height="500" alt=""></th>
                <th width="300px">
                    <form method="post" action="/image" enctype="multipart/form-data">
                        Update Image:<input type="file" name="image">
                        <input type="hidden" value="update" name="action">
                        <input type="hidden" value="${x.id}" name="id">
                        <button type="submit">Update image</button>
                    </form>
                    <a href="/image?action=delete&id=${x.id}">Delete</a>
                </th>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
