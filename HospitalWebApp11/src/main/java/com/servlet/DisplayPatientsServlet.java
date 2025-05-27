package com.servlet;


	import com.dao.HospitalDAO;
	import com.model.Patient;

	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.IOException;
	import java.util.List;

	public class DisplayPatientsServlet extends HttpServlet {
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        try {
	            List<Patient> list = HospitalDAO.getAllPatients();
	            request.setAttribute("patients", list);
	        } catch (Exception e) {
	            request.setAttribute("error", "Error: " + e.getMessage());
	        }

	        RequestDispatcher rd = request.getRequestDispatcher("patientdisplay.jsp");
	        rd.forward(request, response);
	    }
	}



