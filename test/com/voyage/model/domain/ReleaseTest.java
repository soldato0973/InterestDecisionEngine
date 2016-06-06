package com.voyage.model.domain;

import junit.framework.TestCase;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger;

public class ReleaseTest extends TestCase {
	
	private Release release1, release2;
    Random randomNumbers = new Random();  // object to create for a new random number for the appID
	
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(ReleaseTest.class);
        
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
	public void setUp() throws Exception {

        release1 = new Release ("RMF", "1", "Firmware");
		release2 = new Release ("RMF", "1", "Firmware");
	}

	/**
	 * Test method for {@link com.Voyage.model.Domain.Release#validate()}.
	 */
	@Test
	public final void testValidateRelease() {
		log.info("starting testValidateRelease()");
		// c1.validate should assert to True since all variables 
		// being passed to create a new Application are all valid.
		assertTrue ("release validates", release1.validate());
	       log.info("testValidate PASSED");
	}

	/**
	 * Test method for {@link com.Voyage.model.Domain.Release#equals(com.Voyage.model.Domain.Release)}.
	 */
	@Test
	public final void testEqualsRelease() {
		log.info("starting testEqualsRelease()");
		// this should assert to true since the contents of 
		// release1 and release2 class variables are identical.
		assertTrue ("release1 equals release2", release1.equals(release2));
	    log.info ("testEqualsRelease PASSED");		

	}
}
