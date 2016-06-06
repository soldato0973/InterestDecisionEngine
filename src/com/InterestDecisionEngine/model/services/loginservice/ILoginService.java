package com.voyage.model.services.loginservice;

import com.voyage.model.domain.User;
import com.voyage.model.services.IService;
import com.voyage.model.services.exception.LoginException;

/**
 * @author Jason Canney
 *
 */
public interface ILoginService extends IService
{

	public final String NAME = "ILoginService";

	/** 
	 * Authenticate user into our application 
	 * @param User 
	 * 							contains user information to be authenticated 
	 * @throws LoginException 
	 * 							If the User object in the composite is null or
	 *   				        If the file that contains the user information is not found or
	 *   					    If an unexpected exception is encountered while accessing the file.
	 * @return boolean
	 * 					true - if authenticated
	 * 				    false - if failed to authenticate
	 * */
	public boolean loginUser(User user) throws LoginException;

}