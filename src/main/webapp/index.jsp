<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <title>Timeclock</title>
</head>
<body>
    <!-- Add EL to show conformation -->
    <form action="ClockInStatusServlet" method="post">
        <label>User ID: </label>
        <input type="text" name="userId">
        <button type="submit" value="submit">Submit</button>
    </form>
</body>
</html>
