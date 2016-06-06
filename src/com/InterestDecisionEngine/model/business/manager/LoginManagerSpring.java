package com.voyage.model.business.manager;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.voyage.model.domain.User;


/**
 *  This Manager is called by the servlet LoginController.java to manage the
 *  use case of verifying the login through the authenticate method
 * @author Jason Canney
 *
 */

public class LoginManagerSpring {
	
	
	/** Default Manager Constructor */
	public LoginManagerSpring() {
	 }
	
	/*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
	 static Logger log = Logger.getLogger(LoginManagerSpring.class);
	
	// pull in the spring config file
	 ApplicationContext context = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
	
	/**
	 *  authenticate method used to take in a user object and verify it
	 *  Today the verification is hard coded in the method
	 *  long term will extend to service layer and mysql integration
	 * @author Jason Canney
	 * @param User object for username and password
	 * @return User object
	 *
	 */
	public boolean authenticate(User user) {
		
		
		MetadataManager metadataManager = (MetadataManager)context.getBean("MetadataManager");                
        
		if (metadataManager != null) {	
        	boolean action = metadataManager.setMetadata("loginUser", user);
        	return action;
	      }
		return false;
	}
}