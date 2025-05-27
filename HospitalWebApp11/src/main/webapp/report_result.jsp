<%@ page import="java.util.*,com.model.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Report Result</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9fbfd;
            color: #333;
            padding: 20px;
        }

        h2 {
            color: #004085;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px 15px;
            border: 1px solid #dee2e6;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        tbody tr:nth-child(even) {
            background-color: #f2f9ff;
        }

        tbody tr:hover {
            background-color: #e1f0ff;
        }

        p {
            font-style: italic;
            color: #dc3545;
        }
    </style>
</head>
<body>
    <h2>Report Result</h2>

    <%
        List<Patient> patients = (List<Patient>) request.getAttribute("patients");
        if (patients == null || patients.isEmpty()) {
    %>
        <p>No results found.</p>
    <%
        } else {
    %>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Admission Date</th>
                    <th>Ailment</th>
                    <th>Doctor</th>
                </tr>
            </thead>
            <tbody>
                <% for (Patient p : patients) { %>
                    <tr>
                        <td><%= p.getPatientID() %></td>
                        <td><%= p.getPatientName() %></td>
                        <td><%= p.getAge() %></td>
                        <td><%= p.getGender() %></td>
                        <td><%= p.getAdmissionDate() %></td>
                        <td><%= p.getAilment() %></td>
                        <td><%= p.getAssignedDoctor() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <%
        }
    %>
</body>
</html>
