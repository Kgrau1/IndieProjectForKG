<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Timeclock</title>
</head>
<body>
    <!-- Add EL to show conformation -->
    <form action="ClockInStatusServlet" method="get">
        <label>User ID: </label>
        <input type="number" name="userId">
        <button type="submit" value="submit">Submit</button>

        <br>

        <c:if test="${param.success eq 'true'}">
            <p style="color: green;">Successfully clocked in</p>
        </c:if>
        <c:if test="${userNotFound}">
            <p style="color: red;">User not found</p>
        </c:if>
    </form>
</body>
</html>
