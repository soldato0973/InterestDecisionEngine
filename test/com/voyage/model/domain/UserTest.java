/**
 * 
 */
package com.voyage.model.domain;

import com.voyage.model.domain.User;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jason Canney
 *
 */
public class UserTest extends TestCase {

	private User user1, user2;

     /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(UserTest.class);
        
        
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
	public void setUp() throws Exception {

		user1 = new User ("hsimpson", "Simpson", "Homer", "homer@duff.com", "duff", "619.111.1234","619.111.1234");
		user2 = new User ("jcanney", "Canney", "Jason", "j@canney.com", "canney", "619.111.1234","619.111.1234");

	}


	/**
	 * Test method for {@link com.fleetrental.model.domain.User#validate()}.
	 */
        @Test
	public final void testValidateUser() {
		log.info ("starting testValidateUser()");
		// c1.validate should assert to True since all variables 
		// being passed to create a new User are all valid.
		assertTrue ("user validates", user1.validate());
	       log.info ("testValidate PASSED");
	}

	/**
	 * Test method for {@link com.fleetrental.model.domain.User#equals(com.fleetrental.model.domain.User)}.
	 */
        @Test
	public final void testEqualsUser() {
		log.info("starting testEqualsUser()");
		// this should assert to true since the contents of 
		// c1 and c2 class variables are identical.
		assertFalse ("user1 does NOT equal user2", user1.equals(user2));
	        log.info("testEqualsUser PASSED");		

	}

}
