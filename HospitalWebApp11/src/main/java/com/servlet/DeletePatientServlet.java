package com.servlet;



	import com.dao.HospitalDAO;

	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.IOException;

	public class DeletePatientServlet extends HttpServlet {
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        try {
	            int id = Integer.parseInt(request.getParameter("patientID"));
	            int status = HospitalDAO.deletePatient(id);
	            request.setAttribute("message", status > 0 ? "Patient deleted successfully." : "Patient not found.");
	        } catch (Exception e) {
	            request.setAttribute("message", "Error: " + e.getMessage());
	        }

	        RequestDispatcher rd = request.getRequestDispatcher("patientdelete.jsp");
	        rd.forward(request, response);
	    }
	}



