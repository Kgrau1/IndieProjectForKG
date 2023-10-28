<%@ page language="java" contentType="text/html; charset=UFT-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Timeclock</title>
</head>
<body>
    <form action="ClockInServlet" method="post">
        <label>User ID: </label>
        <input type="text" name="userId">
        <label>Job: </label>
        <input type="text" name="jobId">
    </form>
</body>
</html>
