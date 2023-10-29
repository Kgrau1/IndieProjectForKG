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
    <form action="ClockingActionsServlet" method="post">
        <label>User ID: </label>
        <input type="text" name="userId" value="${param.userId}">

        <c:choose>
            <c:when test="${isClockedIn}">
                <input type="submit" name="action" value="Change Job">
                <input type="submit" name="action" value="Clock Out">
            </c:when>
            <c:otherwise>
                <input type="submit" name="action" value="Clock In">
            </c:otherwise>
        </c:choose>
    </form>

</body>
</html>
