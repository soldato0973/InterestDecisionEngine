package com.voyage.model.services.applicationservice;

import com.voyage.model.domain.Application;
import com.voyage.model.services.IService;
import com.voyage.model.services.exception.ApplicationException;
import java.util.Set;

/**
 * This interface defines methods for persisting of Applications
 * to and from a file system
 * @author Jason L. Canney
 * @param NAME is a string used to identify the service
 *
 */
public interface IApplicationSvc extends IService {
	
	public final String NAME = "IApplicationSvc";
	
	/**
	 * Persists an application
	 * The storeApplication takes in an application object as input and will pass it to the ApplicationSvcImpl
	 * @param application The application to be persisted
	 * @return boolean true/false
	 * @throws ApplicationException 
	 */
	public boolean storeApplication(Application application) throws ApplicationException;
	/**
	 * Retrieves an application
	 * The getApplication takes an ID as an argument and retrieves it through the ApplicationSvcImpl class
	 * @param none The unique identifier for the application to be retrieved
	 * @return The collection
	 * @throws ApplicationException
	 * @throws ClassNotFoundException 
	 */
	// public boolean getApplication(Application application) throws ApplicationException, ClassNotFoundException;
	
	public Set<Application> getApplication() throws ApplicationException,
			ClassNotFoundException;
        
}