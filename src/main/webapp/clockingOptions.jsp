<%--
  Created by IntelliJ IDEA.
  User: cheve
  Date: 10/29/2023
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="ClockingActionServlet" method="post">
        <label>User ID: ${userId}</label>
        <input type="hidden" name="userId" value="${userId}">
        <!-- Add first and last name -->
        <br>
        <label>Enter Job: </label>
        <input type="text" name="jobId">

        <c:choose>
            <c:when test="${isClockedIn}">
                <button type="submit" name="action" value="Change Job">Change Job</button>
                <button type="submit" name="action" value="Clock Out">Clock Out</button>
            </c:when>
            <c:otherwise>
                <button type="submit" name="action" value="Clock In">Clock In</button>
            </c:otherwise>
        </c:choose>
    </form>

</body>
</html>
