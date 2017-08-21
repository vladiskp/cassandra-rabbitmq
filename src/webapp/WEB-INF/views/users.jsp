<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<table class="table table-striped">
    <tr>
        <th>ID</th>
        <th>Login</th>
    </tr>

    <c:forEach var="subscriber" items="${users}">
        <tr>
            <td>${subscriber.id}</td>
            <td>${subscriber.login}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
