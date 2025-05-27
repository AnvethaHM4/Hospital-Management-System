<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reports</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        form {
            margin-top: 20px;
        }
        label, input[type="radio"] {
            display: block;
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <h2>Generate Reports</h2>
    <form action="ReportCriteriaServlet" method="post">
        <label for="criteria">Select Report:</label>

        <input type="radio" id="date" name="criteria" value="date" required>
        <label for="date">Patients Admitted Between Dates</label>

        <input type="radio" id="ailment" name="criteria" value="ailment">
        <label for="ailment">Patients with Specific Ailment</label>

        <input type="radio" id="doctor" name="criteria" value="doctor">
        <label for="doctor">Patients Assigned to Specific Doctor</label>

        <br>
        <input type="submit" value="Next">
    </form>
</body>
</html>
