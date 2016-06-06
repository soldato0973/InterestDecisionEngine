package com.voyage.controllers;

import java.io.*;

import com.voyage.model.business.manager.LoginManagerSpring;
import com.voyage.model.business.manager.MetadataManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;

import com.voyage.model.domain.User;

	public class LoginController extends HttpServlet {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// pull in the spring config file
		  ApplicationContext context = new ClassPathXmlApplicationContext(
						"applicationContext.xml");
		
		
		
	    public void doPost(HttpServletRequest request, HttpServletResponse response) 
	                throws ServletException, IOException  {
		 
			// Create user object to store the user ID and password
			User user = new User();
			// get login parameters
		    user.setUserName(request.getParameter("username"));
		    user.setPassword(request.getParameter("password"));
		    // validate the user and forward to the next page
		    
		    HttpSession session = request.getSession();
		   
	        MetadataManager metadataManager = (MetadataManager)context.getBean("MetadataManager");                

		    
		    boolean result = (new LoginManagerSpring()).authenticate(user);

	//        log.info ("Created user object, received data from login.html, created user1 from authentication method in LoginManager.java");

		    
		   if (result!=false){
	    //    if (authenticate(user)){
		    	session.setAttribute("user", user);
		    	response.encodeURL("/web/loginview");
		    	getServletContext().getRequestDispatcher("/web/LoginView.jsp").forward(request, response);
		    } else {
		    	session.setAttribute("user", user);
		    	response.encodeURL("/web/loginerror");
		    	getServletContext().getRequestDispatcher("/web/LoginError.jsp").forward(request, response);
		    }
	}
 
	/*
	public boolean authenticate (User user) {
		if ("foo".equals(user.getUserName()) && "bar".equals(user.getPassword())){
			return true;
		}
		return false;
	}
	  */
	
}
