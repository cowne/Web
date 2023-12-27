<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Image Page</title>
</head>
<body>
<%
    String username = (String)request.getParameter("username");
%>
<h1 style="color: red" align="center">Image Gallery.</h1>
    <div align="center">
        <form method="post" action="/addImage" enctype="multipart/form-data">
            Select Image:<input type="file" name="image">
            <input type="hidden" value="<%=username%>" name="username">
            <button type="submit">Add image</button>
        </form>
    </div>
<div align="center">
    <table border="5px" style="width: 400px">
        <tr>
            <th>Image</th>
        </tr>
<%--            run the for loops to list all the image belongs to the user--%>
            <c:forEach items="${imageList}" var="x">
                <tr>
                    <th><img src="/images/${x.imageFileName}" width="400" height="500"></th>
                </tr>
            </c:forEach>


    </table>

</div>
</body>
</html>
