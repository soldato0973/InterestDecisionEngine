package com.voyage.controllers;

import com.voyage.model.business.manager.AppManagerSpring;
import com.voyage.model.domain.Application;

import javax.servlet.http.*;
import java.io.IOException;

/**
 * Servlet catches form data from voyageapp.html and puts it into an application object
 * @author JasonCanney
 * @param takes in the servlet request and sends back the response
 * @version 1.0 - Split response logic into AppView and AppError servlets
 * @returns void
 */

	public class AppController extends HttpServlet {

	    
		private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	                throws ServletException, IOException  {
		 
			// Create user object to store the user ID and password
			Application application = new Application();
			// get login parameters
			application.setAppName(request.getParameter("appName"));
			application.setAppVendor(request.getParameter("appVendor"));
			application.setApplicationType(request.getParameter("applicationType"));
			application.setAppVers(request.getParameter("appVers"));
			application.setAppState(request.getParameter("appState"));
			application.setAppProdName(request.getParameter("appProdName"));
			application.setAppFileSize(request.getParameter("appFileSize"));
			application.setAppCheckSum(request.getParameter("appCheckSum"));
			application.setAppDescription(request.getParameter("appDescription"));
			application.setAppURL(request.getParameter("appURL"));
			application.setAppContactName(request.getParameter("appContactName"));
			application.setAppContactEmail(request.getParameter("appContactEmail"));

			HttpSession session = request.getSession();
			   
			boolean result = (new AppManagerSpring()).authenticate(application);
			
		    if (result!=false){
				    	session.setAttribute("application", application);
				    	response.encodeURL("/web/appview");
				    	getServletContext().getRequestDispatcher("/web/AppView.jsp").forward(request, response);
				    } else {
				    	session.setAttribute("application", application);
				    	response.encodeURL("/web/apperror");
				    	getServletContext().getRequestDispatcher("/web/AppError.jsp").forward(request, response);
				    }
			
	}
	
}
