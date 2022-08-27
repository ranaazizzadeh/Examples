<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 8/22/2022
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Book Form</title>
</head>
<body>

<form:form action="processAddBook" modelAttribute="book">

   Name: <form:input path="name"/>
   <br><br>
   Author: <form:input path="author"/>
   <br><br>
   <input type="submit" value="add book">
</form:form>

</body>
</html>
