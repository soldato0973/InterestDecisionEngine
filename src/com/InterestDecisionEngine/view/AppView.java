package com.voyage.view;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.voyage.model.domain.Application;

	public class AppView extends HttpServlet {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse response) 
	                throws ServletException, IOException  {
		 
		String authenticated = "Successful Application Creation";
		
	    HttpSession session = req.getSession();
		
		response.setContentType("text/html");
	 	PrintWriter out = response.getWriter();
		Application application = (Application)session.getAttribute("application");
	 	out.write("<html>");
	    out.write("<head><title>Voyage Application Metadata - Create</title></head>");
	    out.write("<body>");
	    out.write("<span>" + authenticated + "</span><br>");
	    out.write("Application Name: " +application.getAppName()+ "<br>");    
	    out.write("<tab><tab>Vendor: " +application.getAppVendor()+ "<br>");
	    out.write("<tab><tab>State: " +application.getAppState()+ "<br>");
	    out.write("<tab><tab>Prod Name: " +application.getAppProdName()+ "<br>");
	    out.write("<tab><tab>File Size: " +application.getAppFileSize()+ "<br>");
	    out.write("<tab><tab>CheckSum: " +application.getAppCheckSum()+ "<br>");
	    out.write("<tab><tab>Description: " +application.getAppDescription()+ "<br>");
	    out.write("<tab><tab>URL: " +application.getAppURL()+ "<br>");
	    out.write("<tab><tab>Contact Name: " +application.getAppContactName()+ "<br>");
	    out.write("<tab><tab>Contact Email: " +application.getAppContactEmail()+ "<br>");
	    out.write("</body>");
	    out.write("</html>");
	    
	    
	}
	
}
