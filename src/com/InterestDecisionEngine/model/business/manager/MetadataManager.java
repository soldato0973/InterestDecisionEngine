package com.voyage.model.business.manager;

import com.voyage.model.business.exception.ServiceLoadException;
import com.voyage.model.domain.Application;
import com.voyage.model.domain.Release;
import com.voyage.model.domain.User;
import com.voyage.model.services.applicationservice.IApplicationSvc;
import com.voyage.model.services.exception.ApplicationException;
import com.voyage.model.services.exception.LoginException;
import com.voyage.model.services.exception.ReleaseException;
import com.voyage.model.services.factory.Factory;
import com.voyage.model.services.loginservice.ILoginService;
import com.voyage.model.services.releaseservice.IReleaseSvc;
import java.util.Set;
import java.util.TreeSet;
import org.apache.log4j.Logger;

/**
 *  This Manager class provides two key functionalities:
 *  1. Has the properties files loaded by the PropertyManager
 *  2. Calls the Factory class and executes the services being
 *     requested by the controller.
 * @author Jason Canney
 *
 */

public class MetadataManager extends ManagerSuperType
{

	private static MetadataManager _instance;

	private IApplicationSvc iapplicationSvc;
	private IReleaseSvc ireleaseSvc;
	private ILoginService iloginSvc;
        
	 /** Manager Constructor */
	  public MetadataManager() {
	 }
   

         /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(MetadataManager.class);
         
        /**
        * Injected Spring
        * @param _applicationSvc
        * @return void
        * Author - Jason Canney
        */
        public void setApplicationSvc(IApplicationSvc _applicationSvc)
        {
                    this.iapplicationSvc = _applicationSvc;
        }

        /**
        * Injected Spring
        * @param _releaseSvc
        * @return void
        * Author - Jason Canney
        */
        public void setReleaseSvc(IReleaseSvc _releaseSvc)
        {
                    this.ireleaseSvc = _releaseSvc;
        } 
        
        /**
         * Injected Spring
         * @param _loginSvc
         * @return void
         * Author - Jason Canney
         */
         public void setLoginSvc(ILoginService _loginSvc)
         {
                     this.iloginSvc = _loginSvc;
         } 
        
           
        /** 
        * Generic method that all clients of this class can call to set metadata
        * 
        * @param commandString 
        *                      Holds the service name to be invoked	 *                      
        * @param application
        *                      Holds application specific domain state
        * @return
        *         false
        *              if action failed
        *         true
        *              if action is successful
        */
        @Override
        public boolean setMetadata(String commandString, Object object)
         {
                boolean action = false;

                if (commandString.equals("setApp"))
                {
                action =  setApplication(IApplicationSvc.NAME, (Application) object);
                }
                else if (commandString.equals("setRel"))
                {
                action = setRelease(IReleaseSvc.NAME, (Release) object);	
                }
                else if (commandString.equals("loginUser"))
                {
                action = setLoginSvc(ILoginService.NAME, (User) object);	
                }
                return action;
         }
		 
            /** 
            * Generic method that all clients of this class can call to get metadata
            * 
            * @param commandString 
            *                      Holds the service name to be invoked	 *                      
            * @param id
            *                      Holds int value for which metadata to retrieve                
            * @return
            *         app			returns the application object
            */
             @Override
             public Set getMetadata(String commandString, int id)
             {
                    Set<Application> app = new TreeSet<Application>();
                    // Application app = null;

                    if (commandString.equals("getApp"))
                    {
                            app =  getApplication(IApplicationSvc.NAME, id);
                    }
                    return app;
             }
	 	 
            /**
             * Method delegates to the Factory to execute a service. 
             * 
             * @param commandString 
             * 					contains the service that needs to be performed
             * @param int
             * 					contains the int value of the application to retrieve
             * 
             * @return isApplication application object returned
             * 
             */
	    public static Set getApplication(String commandString, int id)
	    {
	    	// Application isApplication = null;
                Set<Application> isApplication = new TreeSet<Application>();


	    	Factory factory = Factory.getInstance();
	    	IApplicationSvc iapplicationSvc;

	    	try {
				iapplicationSvc = (IApplicationSvc)factory.getService(commandString);
				isApplication = iapplicationSvc.getApplication();
			} catch (ServiceLoadException e) {
				log.error ("MetadataManager::getApplication failed", e); // defaulting to isApplication to false
                        } catch (ApplicationException e) {
                                log.error ("MetadataManager::getApplication failed", e); // defaulting to isApplication to false
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

	    	return isApplication;

	    }//end getApplication

            /**
            * Invokes appropriate service to login the customer
            * 
            * @param commandString 
            * 					contains the service that needs to be performed
            * @param application
            * 					contains the application to store
            * @return
            *        true 
            *           if login information passed is valid
            *        false
            *           if login information passed is invalid
            */
	    public boolean setApplication(String commandString, Application application)
	    {
	    	boolean isApplication = false;

	    	// check if Spring loaded the service and it is not null
                if (iapplicationSvc != null)
                {	
                        try {
                        //invoke service operation
                        isApplication = iapplicationSvc.storeApplication(application);
                        } catch (ApplicationException e) {
                                log.error ("MetadataManager::setApplication failed",e); // defaulting to isApplication to false
			}
                }
	    	return isApplication;

	    }//end setApp
	    
            /**
            * Invokes appropriate service to login the customer
            * 
            * @param commandString 
            * 					contains the service that needs to be performed
            * @param release
            * 					contains the application to store
            * @return
            *        true 
            *           if login information passed is valid
            *        false
            *           if login information passed is invalid
            */
	    public boolean setRelease(String commandString, Release release)
	    {
	    	boolean isRelease = false;

	    		// check if Spring loaded the service and it is not null
                if (ireleaseSvc != null)
                {
                		try {
                		//invoke service operation
                        isRelease = ireleaseSvc.storeRelease(release);
                        } catch (ReleaseException e) {
                                log.error ("MetadataManager::setRelease failed",e); // defaulting to isRelease to false
                        		}
                }
	    	return isRelease;
	    }//end setRelease
	    
            /**
            * Invokes appropriate service to login the customer
            * 
            * @param commandString 
            * 					contains the service that needs to be performed
            * @param rentalComposite
            * 					contains the customer login information
            * @return
            *        true 
            *           if login information passed is valid
            *        false
            *           if login information passed is invalid
            */
            public boolean setLoginSvc(String commandString, User user) 
            {
                boolean isAuthenticated = false;
                log.info ("loginUser" + user.toString());

                // check if Spring loaded the service and it is not null
                if (iloginSvc != null)
                {
                		try {
                		//invoke service operation
                        isAuthenticated = iloginSvc.loginUser(user);
                        } catch (LoginException e) {
                           log.error ("MetadataManager::loginUser failed",e); // defaulting to isAuthenticated to false
                           e.printStackTrace();
						}
                }
                return isAuthenticated;

            } //end loginCustomer

	} // end class MetadataManager