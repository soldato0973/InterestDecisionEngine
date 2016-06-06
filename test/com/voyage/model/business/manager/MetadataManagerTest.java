/**
 * 
 */
package com.voyage.model.business.manager;

import com.voyage.model.domain.Application;
import com.voyage.model.domain.Release;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This unit test tests the MetadataManager class. Only does positive/happy path testing to set and get an application object.
 * todo : need to extend later for set and get of release metadata
 * 
 * @author Jason Canney
 * 
 *
 */
public class MetadataManagerTest extends TestCase {	
	private Application application1;
	private Release release1;

	// pull in the spring config file
        ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
        
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(MetadataManagerTest.class);
    
        
	/**
	 * Setup code that creates a new factory for use in all tests
	 * Creates two application objects to be used for set and get tests
	 * Creates a hardware object that gets added to the application1 object
	 * creates a metadatamanager instance
	 * @throws java.lang.Exception
	 */
	@Before	
	protected void setUp() throws Exception {
		
		super.setUp();
		application1 = new Application (8765409,"RMF", "Canoe", "Firmware", "Lightning", "Production","OCAP","1239876","A987654321","OCAP Stack","http://www.adobe.com/ocap","Hans Bender","h.bender@adobe.com");
		release1 = new Release ("RMF", "1", "Firmware");
                log.info ("done with Before setup work");

	}

	
	/**
	 * Test performAction method for setApplication
	 *
	 */
	@Test
	public final void testsetMetadatasetApplication() {
                        
			log.info ("inside testsetMetadatasetApplication");
                        log.info (application1.toString());
                        MetadataManager metadataManager = (MetadataManager)context.getBean("MetadataManager");                
                        boolean action = metadataManager.setMetadata("setApp", application1);
			assertTrue(action);
	}

	/**
	 * Test performAction method for getApplication
	 */
	/* @Test */
/*	public final void testgetMetadatagetApplication() {
		application2 = metadataManager.getMetadata("getApp", 0);			
		assertTrue(true);
	} */
	/**
	 * Test performAction method for setRelease
	 *
	 */
	@Test
	public final void testsetMetadatasetRelease() {
                        log.info ("inside testsetMetadatasetRelease");
                        log.info (release1.toString());
                        MetadataManager metadataManager = (MetadataManager)context.getBean("MetadataManager");                
			boolean action = metadataManager.setMetadata("setRel", release1);			
			assertTrue(action);
	}

	/**
	 * Test performAction method for getRelease
	 */
	
        /* @Test */
	/* public final void testgetMetadatagetRelease() {
		application2 = metadataManager.getMetadata("getRel", 0);			
		assertTrue(true);
	}
	*/
	
} //end metadataManagerTest
