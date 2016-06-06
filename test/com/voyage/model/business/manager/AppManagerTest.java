/**
 * 
 */
package com.voyage.model.business.manager;

import com.voyage.model.domain.Application;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * This unit test tests the AppManager class. Only does positive/happy path testing to set and get an application object.
 * todo : need to extend later for set and get of release metadata
 * 
 * @author Jason Canney
 * 
 *
 */
public class AppManagerTest extends TestCase {
	/*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
    static Logger log = Logger.getLogger(AppManagerTest.class);
    
        
	/**
	 * creates user object with seed data to pass the authentication
	 * passes the user object to appmanager to validate and expects a user1 object back
	 * 
	 * @throws java.lang.Exception
	 */
	@Before	
	protected void setUp() throws Exception {
		
		super.setUp();
        log.info ("done with Before setup work");
	}

	
	/**
	 * Test performAction method for setApplication
	 *
	 */
	@Test
	public final void testsetAppManager() {
            
			Application application = new Application (12345,"foo","bar","","","","","","","","","","");
			log.info ("inside testsetAppManager");
            log.info (application.toString());
            boolean result = (new AppManagerSpring()).authenticate(application);
            assertTrue(result);
	}

	
} //end AppManagerTest
