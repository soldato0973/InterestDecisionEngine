package com.voyage.model.business.manager;

import org.apache.log4j.Logger;

import com.voyage.model.business.exception.ServiceLoadException;
import com.voyage.model.domain.User;
import com.voyage.model.services.exception.LoginException;
import com.voyage.model.services.factory.Factory;
import com.voyage.model.services.loginservice.ILoginService;


/**
 *  This Manager is called by the servlet LoginController.java to manage the
 *  use case of verifying the login through the authenticate method
 * @author Jason Canney
 *
 */

public class LoginManager {
	
	
	/** Default Manager Constructor */
	public LoginManager() {
	 }
	
	/*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
	 static Logger log = Logger.getLogger(LoginManager.class);
	
	
	
	/**
	 *  authenticate method used to take in a user object and verify it
	 *  Today the verification is hard coded in the method
	 *  long term will extend to service layer and mysql integration
	 * @author Jason Canney
	 * @param User object for username and password
	 * @return User object
	 *
	 */
	public User authenticate(User user) {

		Factory factory = Factory.getInstance();
		ILoginService loginSvc = null;
		try {
			loginSvc = (ILoginService)factory.getService (ILoginService.NAME);
		} catch (ServiceLoadException e) {
			log.error ("LoginManager::ILoginService factory.getService failed", e); // defaulting to isApplication to false			e.printStackTrace();
		}		
			// now use the ILoginService service
		User user1 = user;
	    boolean result = false;
		try {
			result = loginSvc.loginUser(user1);
		} catch (LoginException e) {
			log.error ("LoginManager::ILoginService factory.LoginException failed", e); // defaulting to isApplication to false			e.printStackTrace();
			e.printStackTrace();
		}
	    if (result!=false)
	    return user1;
	    else
	    	return null;
		/*
		if ("foo".equals(user.getUserName()) && "bar".equals(user.getPassword())){
					return user;
			}
		  return null;  
	*/
	
	}
}
