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
        <label>User ID: ${param.userId}</label>
        <label>Enter Job: </label>
        <input type="text" name="jobId" value="jobId">

        <c:choose>
            <c:when test="${isClockedIn}">
                <button type="submit" name="action" value="Change Job">
                <button type="submit" name="action" value="Clock Out">
            </c:when>
            <c:otherwise>
                <button type="submit" name="action" value="Clock In">
            </c:otherwise>
        </c:choose>
    </form>

</body>
</html>
