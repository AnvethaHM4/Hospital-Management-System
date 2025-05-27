package com.servlet;

	import com.dao.HospitalDAO;
	import com.model.Patient;

	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.IOException;
	import java.text.SimpleDateFormat;

	public class AddPatientServlet extends HttpServlet {
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        try {
	            Patient p = new Patient();
	            p.setPatientID(Integer.parseInt(request.getParameter("patientID")));
	            p.setPatientName(request.getParameter("patientName"));
	            p.setAge(Integer.parseInt(request.getParameter("age")));
	            p.setGender(request.getParameter("gender"));

	            String dateStr = request.getParameter("admissionDate");
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            p.setAdmissionDate(sdf.parse(dateStr));

	            p.setAilment(request.getParameter("ailment"));
	            p.setAssignedDoctor(request.getParameter("assignedDoctor"));

	            int status = HospitalDAO.addPatient(p);
	            request.setAttribute("message", status > 0 ? "Patient added successfully." : "Failed to add patient.");
	        } catch (Exception e) {
	            request.setAttribute("message", "Error: " + e.getMessage());
	        }

	        RequestDispatcher rd = request.getRequestDispatcher("patientadd.jsp");
	        rd.forward(request, response);
	    }
	}



