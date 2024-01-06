<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/6/2024
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update image</title>
</head>
<body>
<h1>Update image page</h1>
<div align="center">
    <form method="post" action="/image?action=update" enctype="multipart/form-data">
        Select Image:<input type="file" name="image">
        <input type="hidden" value="addImage" name="action">
        <button type="submit">Add image</button>
    </form>
</div>
</body>
</html>
