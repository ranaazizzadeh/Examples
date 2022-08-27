<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/22/2022
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add User Form</title>
</head>
<body>

<form:form action="processAddUser" modelAttribute="user">

    Name: <form:input path="name" />
    <br><br>
    Lastname: <form:input path="lastname"/>
    <br><br>
    <input type="submit" value="add user">
</form:form>
</body>
</html>
