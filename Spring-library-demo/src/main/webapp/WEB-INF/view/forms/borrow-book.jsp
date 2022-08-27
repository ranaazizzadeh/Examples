<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/22/2022
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Borrow Book</title>
</head>
<body>
<form:form action="processBorrowBook" modelAttribute="borrowBookModel">
    Choose book to borrow :
    <form:select path="bookId">
        <form:options items="${availableBooksMap}"/>
    </form:select>
    <br><br>
    Choose user :
    <form:select path="userId">
        <form:options items="${usersMap}"/>
    </form:select>
    <br><br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
