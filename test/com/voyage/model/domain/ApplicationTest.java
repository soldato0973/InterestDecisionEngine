package com.voyage.model.domain;

import junit.framework.TestCase;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger;

public class ApplicationTest extends TestCase {

	private Application application1, application2;
        Random randomNumbers = new Random();  // object to create for a new random number for the appID
	int randomnum, randomnum2; // stores the random number
        
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(ApplicationTest.class);
        
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
	public void setUp() throws Exception {

		application1 = new Application (randomnum=randomNumbers.nextInt(), "RMF", "Adobe", "Firmware", "Lightning", "Production","OCAP","1239876","A987654321","OCAP Stack","http://www.adobe.com/ocap","Hans Bender","h.bender@adobe.com");
		application2 = new Application (randomnum2=randomNumbers.nextInt(), "RMF", "Adobe", "Firmware", "Lightning", "Production","OCAP","1239876","A987654321","OCAP Stack","http://www.adobe.com/ocap","Hans Bender","h.bender@adobe.com");
		log.info ("created random numbers for application appIDs");
	}

	/**
	 * Test method for {@link com.voyage.model.domain.Application#validate()}.
	 */
	@Test
	public final void testValidateApplication() {
		log.info ("starting testValidateApplication()");
		// c1.validate should assert to True since all variables 
		// being passed to create a new Application are all valid.
		assertTrue ("application validates", application1.validate());

	       log.info("testValidateandHW PASSED");
	}

	/**
	 * Test method for {@link com.Voyage.model.Domain.Application#equals(com.Voyage.model.Domain.Application)}.
	 */
	@Test
	public final void testEqualsApplication() {
		log.info("starting testEqualsApplication()");
		// this should assert to true since the contents of 
		// application1 and application2 class variables are identical.
		assertFalse ("application1 does NOT equal application2", application1.equals(application2));
	    log.info ("testEqualsApplicationandHW PASSED");		

	}
}

