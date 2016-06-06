package com.voyage.view;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.voyage.model.domain.Application;

	public class AppError extends HttpServlet {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse response) 
	                throws ServletException, IOException  {
		 
		String authenticated = "Failed Application Creation";
		
	    HttpSession session = req.getSession();
		
		response.setContentType("text/html");
	 	PrintWriter out = response.getWriter();
		Application application = (Application)session.getAttribute("application");
	    out.write("<html>");
	    out.write("<head><title>Voyage Application Metadata - Create</title></head>");
	    out.write("<body>");
	    out.write("<span>" + authenticated + "</span><br><br>");
	    out.write("Application Name: " +application.getAppName()+ "<br>");    
	    out.write("&emsp;&emsp;&emsp;&emsp;&emsp;Vendor:&emsp;" +application.getAppVendor()+ "<br>");
	    out.write("&emsp;&emsp;&emsp;&emsp;&emsp;State:&emsp;" +application.getAppState()+ "<br>");
	    out.write("&emsp;&emsp;&emsp;&emsp;&emsp;Prod Name:&emsp;" +application.getAppProdName()+ "<br>");
	    out.write("&emsp;&emsp;&emsp;&emsp;&emsp;File Size:&emsp;" +application.getAppFileSize()+ "<br>");
	    out.write("&emsp;&emsp;&emsp;&emsp;&emsp;CheckSum:&emsp;" +application.getAppCheckSum()+ "<br>");
	    out.write("&emsp;&emsp;&emsp;&emsp;&emsp;Description:&emsp;" +application.getAppDescription()+ "<br>");
	    out.write("&emsp;&emsp;&emsp;&emsp;&emsp;URL:&emsp;" +application.getAppURL()+ "<br>");
	    out.write("&emsp;&emsp;&emsp;&emsp;&emsp;Contact Name:&emsp;" +application.getAppContactName()+ "<br>");
	    out.write("&emsp;&emsp;&emsp;&emsp;&emsp;Contact Email:&emsp;" +application.getAppContactEmail()+ "<br>");
	    out.write("<b>One or more of these values are not valid</b>");
	    out.write("</body>");
	    out.write("</html>");
	}
	
}
