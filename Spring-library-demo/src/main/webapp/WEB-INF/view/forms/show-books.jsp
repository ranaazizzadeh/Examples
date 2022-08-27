<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/22/2022
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Of Books</title>
</head>
<body>
List Of Books:

<ul>
    <c:forEach var="book" items="${bookList}">
        <li>
            ${book.name} authored by ${book.author}
        </li>
    </c:forEach>
</ul>
</body>
</html>
