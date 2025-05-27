package com.servlet;


	import com.dao.HospitalDAO;
	import com.model.Patient;

	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.*;

	public class ReportServlet extends HttpServlet {
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        List<Patient> result = new ArrayList<>();
	        try {
	            String criteria = request.getParameter("criteria");

	            if ("date".equals(criteria)) {
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                Date start = sdf.parse(request.getParameter("startDate"));
	                Date end = sdf.parse(request.getParameter("endDate"));
	                result = HospitalDAO.getPatientsByDateRange(start, end);

	            } else if ("ailment".equals(criteria)) {
	                String ailment = request.getParameter("ailment");
	                result = HospitalDAO.getPatientsByAilment(ailment);

	            } else if ("doctor".equals(criteria)) {
	                String doctor = request.getParameter("doctor");
	                result = HospitalDAO.getPatientsByDoctor(doctor);
	            }

	            request.setAttribute("patients", result);

	        } catch (Exception e) {
	            request.setAttribute("error", "Error: " + e.getMessage());
	        }

	        RequestDispatcher rd = request.getRequestDispatcher("report_result.jsp");
	        rd.forward(request, response);
	    }
	}



