package com.voyage.model.business.manager;

import com.voyage.model.domain.Application;


/**
 *  This Manager is called by the servlet AppController.java to manage the
 *  use case of verifying the application creation through the authenticate method
 * @author Jason Canney
 *
 */

public class AppManager {
	
	/** Default Manager Constructor */
	public AppManager() {
	 }
	
	
	/**
	 *  authenticate method used to take in a application object and verify it
	 *  Today the verification is hard coded in the method
	 *  long term will extend to service layer and mysql integration
	 * @author Jason Canney
	 * @param Application object for appName and appVendor
	 * @return Application object
	 *
	 */
	public Application authenticate(Application application) {

		  if ("foo".equals(application.getAppName()) && "bar".equals(application.getAppVendor())){
					return application;
			}
		  return null;  
	}	
	
}
