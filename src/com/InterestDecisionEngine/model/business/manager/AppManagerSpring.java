package com.voyage.model.business.manager;

import com.voyage.model.domain.Application;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *  This Manager is called by the servlet AppController.java to manage the
 *  use case of verifying the application creation through the authenticate method
 * @author Jason Canney
 *
 */

public class AppManagerSpring {
	
	/** Default Manager Constructor */
	public AppManagerSpring() {
	 }
	
	/*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
	 static Logger log = Logger.getLogger(AppManagerSpring.class);
	
	// pull in the spring config file
	 ApplicationContext context = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
	
	/**
	 *  authenticate method used to take in a application object and verify it
	 *  Today the verification is hard coded in the method
	 *  long term will extend to service layer and mysql integration
	 * @author Jason Canney
	 * @param Application object for appName and appVendor
	 * @return Application object
	 *
	 */
	public boolean authenticate(Application application) {

		MetadataManager metadataManager = (MetadataManager)context.getBean("MetadataManager");                
        
		if (metadataManager != null) {	
        	boolean action = metadataManager.setMetadata("setApp", application);
        	return action;
	      }
		return false;
	}	
	
}
