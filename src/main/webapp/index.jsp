<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Timeclock</title>
</head>
<body>
    <!-- Add EL to show conformation -->
    <form action="ClockInServlet" method="post">
        <label>User ID: </label>
        <input type="text" name="userId">
        <label>Job: </label>
        <input type="text" name="jobId">
    </form>
</body>
</html>
