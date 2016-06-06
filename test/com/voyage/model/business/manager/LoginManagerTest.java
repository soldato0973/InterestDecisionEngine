/**
 * 
 */
package com.voyage.model.business.manager;

import com.voyage.model.domain.User;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * This unit test tests the LoginManager class. Only does positive/happy path testing to set and get an application object.
 * todo : need to extend later for set and get of release metadata
 * 
 * @author Jason Canney
 * 
 *
 */
public class LoginManagerTest extends TestCase {
	/*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
    static Logger log = Logger.getLogger(LoginManagerTest.class);
    
        
	/**
	 * creates user object with seed data to pass the authentication
	 * passes the user object to loginmanager to validate and expects a user1 object back
	 * 
	 * @throws java.lang.Exception
	 */
	@Before	
	protected void setUp() throws Exception {
		
		super.setUp();
		// User user = new User ("foo","canney","jason","jason@canney.net","bar","303-444-1111","303-555-1212");
        log.info ("done with Before setup work");
	}

	
	/**
	 * Test performAction method for setApplication
	 *
	 */
	@Test
	public final void testsetLoginManager() {
            
			User user = new User ("foo","canney","jason","jason@canney.net","bar","303-444-1111","303-555-1212");
			log.info ("inside testsetLoginManager");
            log.info (user.toString());
            boolean result = (new LoginManagerSpring()).authenticate(user);
            assertTrue(result);
	}

	
} //end metadataManagerTest
