package com.servlet;



	import javax.servlet.*;
	import javax.servlet.http.*;
	import java.io.IOException;

	public class ReportCriteriaServlet extends HttpServlet {
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String criteria = request.getParameter("criteria");
	        request.setAttribute("criteria", criteria);
	        RequestDispatcher rd = request.getRequestDispatcher("report_form.jsp");
	        rd.forward(request, response);
	    }
	}



