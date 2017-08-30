<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Call Records</title>
</head>
<body>
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Subscriber ID</th>
            <th>Duration</th>
            <th>Start Time</th>
            <th>End Time</th>
            <th>Price</th>
            <th>Is Internal</th>
            <th>Out Phone Number</th>
            <th>In Phone Number</th>
        </tr>

        <c:forEach var="callRecord" items="${callRecords}">
            <tr>
                <td>${callRecord.id}</td>
                <td>${callRecord.subscriberId}</td>
                <td>${callRecord.duration}</td>
                <td>${callRecord.startTime}</td>
                <td>${callRecord.endTime}</td>
                <td>${callRecord.price}</td>
                <td>${callRecord.internal}</td>
                <td>${callRecord.outPhoneNumber}</td>
                <td>${callRecord.inPhoneNumber}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
