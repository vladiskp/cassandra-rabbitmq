<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Subscribers</title>
</head>
<body>
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Phone Number</th>
            <th>Phone Operator</th>
            <th>Balance</th>
        </tr>

        <c:forEach var="subscriber" items="${subscribers}">
            <tr>
                <td>${subscriber.id}</td>
                <td>${subscriber.phoneNumber.number}</td>
                <td>${subscriber.phoneNumber.operator}</td>
                <td>${subscriber.phoneNumber.balance}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
