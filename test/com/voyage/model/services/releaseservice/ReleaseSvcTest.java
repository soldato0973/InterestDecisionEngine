package com.voyage.model.services.releaseservice;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.voyage.model.domain.Release;
import com.voyage.model.business.manager.MetadataManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * This class is responsible for testing functionality associated with IReleaseSvc
 * @author Jason Canney
 *
 */
public class ReleaseSvcTest extends TestCase {
	
	/*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
    static Logger log = Logger.getLogger(ReleaseSvcTest.class);
	
	private Release release1;
	
 	ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");	
	
	/**
	 * Setup code that creates a new factory for use in all tests
	 * @throws java.lang.Exception
	 */
	@Before	
	protected void setUp() throws Exception {
		
		// super.setUp();
		super.setUp();
		release1 = new Release ("RMF", "2", "Firmware");
		log.info("got the bean");
		log.info ("created the release");
	}
	
     
        
        
	/**
	 * Test ability of service to store a release in the file system
	 */
	@Test
	public final void testStoreRelease() {
		
		MetadataManager releaseSvc;
			releaseSvc = (MetadataManager)context.getBean("MetadataManager"); 
			log.info("got the bean");
//			assertTrue(releaseSvc.setRelease(null, release1));
			assertTrue(releaseSvc.setRelease("setRel", release1));
            log.info ("testStoreRelease PASSED");
	}

	/**
	 * @throws ClassNotFoundException 
	 * Test ability of service to retrieve a given release from file system
	 * @throws  
	 */
	/* @Test
	public void testGetRelease() throws ClassNotFoundException, ReleaseException {
		
		IReleaseSvc releaseSvc;
		try {
			releaseSvc = (IReleaseSvc)factory.getService(IReleaseSvc.NAME);
			release1=releaseSvc.getRelease();
	        System.out.println("testGetRelease PASSED");			
		} catch (ServiceLoadException e) {
                        log.error ("ServiceLoadException triggered in testGetRelease", e); // logging serviceload exception
			e.printStackTrace();
			fail("ServiceLoadException");	
                } 
	} */
}
