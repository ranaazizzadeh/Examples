<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/24/2022
  Time: 1:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Return Book</title>
</head>
<body>
<form:form action="processReturnBook" modelAttribute="returnBookModel">
    Choose book to borrow :
    <form:select path="bookId">
        <form:options items="${borrowedBooksMap}"/>
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
