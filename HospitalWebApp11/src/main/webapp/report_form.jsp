<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Report Input</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Enter Report Parameters</h2>
    <form action="ReportServlet" method="post">
        <%
            String criteria = (String) request.getAttribute("criteria");
            if (criteria != null) {
        %>
        <input type="hidden" name="criteria" value="<%= criteria %>">
        <%
                if ("date".equals(criteria)) {
        %>
            <label for="startDate">From:</label>
            <input type="date" id="startDate" name="startDate"><br><br>

            <label for="endDate">To:</label>
            <input type="date" id="endDate" name="endDate"><br><br>
        <%
                } else if ("ailment".equals(criteria)) {
        %>
            <label for="ailment">Ailment:</label>
            <input type="text" id="ailment" name="ailment"><br><br>
        <%
                } else if ("doctor".equals(criteria)) {
        %>
            <label for="doctor">Doctor:</label>
            <input type="text" id="doctor" name="doctor"><br><br>
        <%
                }
            } else {
        %>
            <p>Error: Report criteria not specified.</p>
        <%
            }
        %>
        <input type="submit" value="Generate Report">
    </form>
</body>
</html>
