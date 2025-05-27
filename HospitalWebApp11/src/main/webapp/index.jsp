<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hospital Management System</title>
    <link rel="stylesheet" href="css/style.css">
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f4f7f9;
            color: #333;
        }

        header {
            background-color: #007bff;
            color: white;
            padding: 20px 0;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        h1 {
            margin: 0;
            font-size: 32px;
        }

        nav {
            margin: 40px auto;
            max-width: 600px;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0,0,0,0.1);
        }

        ul {
            list-style: none;
            padding: 0;
        }

        li {
            margin: 15px 0;
        }

        a {
            display: block;
            background: #007bff;
            color: white;
            text-decoration: none;
            padding: 12px 20px;
            border-radius: 5px;
            transition: background 0.3s ease;
            font-size: 18px;
            text-align: center;
        }

        a:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
    <header>
        <h1>Hospital Management System</h1>
    </header>

    <nav>
        <ul>
            <li><a href="patientadd.jsp">Add Patient</a></li>
            <li><a href="patientupdate.jsp">Update Patient</a></li>
            <li><a href="patientdelete.jsp">Delete Patient</a></li>
            <li><a href="DisplayPatientsServlet">View All Patients</a></li>
            <li><a href="reports.jsp">Reports</a></li>
        </ul>
    </nav>
</body>
</html>
