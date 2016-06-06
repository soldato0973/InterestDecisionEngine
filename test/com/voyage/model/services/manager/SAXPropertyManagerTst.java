/**
 * 
 */
package com.voyage.model.services.manager;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.voyage.model.business.exception.PropertyFileNotFoundException;

/**
 * @author JasonCanney
 *
 */
public class SAXPropertyManagerTst {

	 public SAXPropertyManagerTst() {
	    }
	
	   /*
		 * Category set in config/log4j.properties as
		 * log4j.category.com.classexercise=DEBUG, A1
		 */
	        static Logger log = Logger.getLogger(SAXPropertyManagerTst.class);
	
	
	/**
	 * Test method for {@link com.voyage.model.services.manager.SAXPropertyManager#loadProperties(java.lang.String)}.
	 */
	@Test
	public void testLoadProperties() {
		
		log.info ("loadProperties");
        String propertyFileLocation = "";
        SAXPropertyManager instance = new SAXPropertyManager();
        
        try {
           instance.loadProperties(propertyFileLocation);
	   log.info ("testApplicationService PASSED");
        } catch (PropertyFileNotFoundException e) {
                log.error ("PropertyFileNotFound Exception triggered in testLoadProperties", e); // logging serviceload exception
                e.printStackTrace();
                fail("PropertyFileNotFouncException");	
        }	
        
	}



}
