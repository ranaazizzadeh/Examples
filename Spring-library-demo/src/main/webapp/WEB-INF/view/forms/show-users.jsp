<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/22/2022
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Of Users</title>
</head>
<body>
List Of Users:

<ul>
    <c:forEach var="user" items="${userList}">
        <li>
                ${user.name} ${user.lastname}
        </li>
    </c:forEach>
</ul>
</body>
</html>
