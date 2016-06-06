package com.voyage.controllers;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.voyage.model.business.manager.RelManagerSpring;
import com.voyage.model.domain.Release;

/**
 * Servlet catches form data from voyageapp.html and puts it into an application object
 * @author JasonCanney
 * @param takes in the servlet request and sends back the response
 * @version 1.0 - Split response logic into AppView and AppError servlets
 * @returns void
 */

	public class RelController extends HttpServlet {

	    
		private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	                throws ServletException, IOException  {
		 
			// Create user object to store the user ID and password
			Release release = new Release();
			// get login parameters
			release.setReleaseName(request.getParameter("relName"));
			release.setReleaseNumber(request.getParameter("relNumber"));
			release.setReleaseType(request.getParameter("relType"));

			HttpSession session = request.getSession();
			   
			boolean result = (new RelManagerSpring()).authenticate(release);
			
		    if (result!=false){
				    	session.setAttribute("release", release);
				    	// response.encodeURL("/web/appview");
				    	getServletContext().getRequestDispatcher("/jsp/RelView.jsp").forward(request, response);
				    } else {
				    	session.setAttribute("release", release);
				    	// response.encodeURL("/web/apperror");
				    	getServletContext().getRequestDispatcher("/jsp/RelError.jsp").forward(request, response);
				    }
			
	}
	
}
