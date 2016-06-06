package com.voyage.model.services.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

import com.voyage.model.business.exception.PropertyFileNotFoundException;

/**
 * This class's loadProperties method is called by the MetadataManager.
 * Once loaded, any other class can call it and request for a property value.
 * 
 * How To Use:
 *   1. The service.properties file that was loaded for this application 
 *      has these values:
 *  		 IApplicationSvc=com.voyage.model.services.applicationservice.ApplicationSvcImpl
 *			 IReleaseSvc=com.voyage.model.services.releaseservice.ReleaseSvcImpl
 *   2. Once this file is loaded, if a class wants to get the value for the 
 *      key IApplicationSvc, you would make the following call:
 *           PropertyManager.getPropertyValue("IApplicationSvc");
 *      This would return the string value, "com.voyage.model.services.applicationservice.ApplicationSvcImpl"      
 *   
 * @author Jason Canney
 *
 */

public class PropertyManager
{
	private static Properties properties;
 
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(PropertyManager.class);
        
        
	/**
	 * Load the properties file so its contents are available
	 * for classes in the Service tier.
	 * 
	 * @param propertyFileLocation
	 * @throws PropertyFileNotFoundException
	 * @return void
	 */
	public static void loadProperties(String propertyFileLocation) throws PropertyFileNotFoundException
	{
	    log.info("loadProperties method, trying to load properties file");
            properties = new Properties();  //uses java.util.Properties.Properties()
	    FileInputStream sf = null;		// set file input stream sf to null
	    try
	    {
	      sf = new FileInputStream(propertyFileLocation);
	      properties.load(sf);
     
	      System.out.println("Property file successfully loaded from location: " + propertyFileLocation);
	      System.out.println("Property Contents: " + properties.toString());

	    }
	    catch (FileNotFoundException fnfe) // This file doesn't exist
		 {
                log.error ("Property file not found.", fnfe); // log file not found error 
	    	throw new PropertyFileNotFoundException ("Property File cannot be found.", fnfe);
		 }
	    catch (IOException ioe)   // some sort of read write issue,, file likely there though
	    {
	    	log.error ("IOException while loading Properties file.", ioe); // log IO error
	    	throw new PropertyFileNotFoundException ("IOException while loading Properties file.", ioe);	    	
	    }
	    catch (Exception excp)  // file exists, I can read it, but there was a problem loading it for some reason
	    {
	    	log.error ("Exception while loading Properties file.", excp); // log exception
	    	throw new PropertyFileNotFoundException ("Exception while loading Properties file.", excp);	    	
	    }
		finally
		{
			if (sf != null)
			{	
			   try {
 			    sf.close();
			   } catch (IOException e) {
				// Can't do much here if exceptions occur, other then logging
				e.printStackTrace();
                                log.error ("All other exceptions passed, something wrong loadProperties", e); // log exception

			   }
		    }	
		}	    
	} //end loadProperties()

	/**
	 * This methods returns the Value for the passed key.
	 * 
	 * @param key - key whose value needs to be returned
	 * @return String - value for the passed key
	 */
    static public String getPropertyValue (String key)
    {
    	return properties.getProperty(key);
    }
} // end class PropertyManager