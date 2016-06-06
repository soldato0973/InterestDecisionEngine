package com.voyage.view;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.voyage.model.domain.User;

	public class LoginError extends HttpServlet {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse response) 
	                throws ServletException, IOException  {
		 
		String authenticated = "Failed Login";
		
	    HttpSession session = req.getSession();
		
		response.setContentType("text/html");
	 	PrintWriter out = response.getWriter();
		User user = (User)session.getAttribute("user");
	    out.write("<html>");
	    out.write("<head><title>Voyage Login</title></head>");
	    out.write("<body>");
	    out.write("<span>" + authenticated + "</span><br><br>");
	    out.write("Your Username: " + user.getUserName()+ "<br>");
	    out.write("and/or Password: " + user.getPassword()+ " is not valid");
	    out.write("</body>");
	    out.write("</html>");
	}
	
}
