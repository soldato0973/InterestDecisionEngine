/**
 * 
 */
package com.voyage.model.services.applicationservice;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.voyage.model.business.manager.MetadataManager;
import com.voyage.model.domain.Application;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class is responsible for testing functionality associated with IApplicationSvc
 * @author Jason Canney
 *
 */
public class ApplicationSvcTst extends TestCase {

	
	
	
	private Application application1;
    ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");	
        
    /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
     static Logger log = Logger.getLogger(ApplicationSvcTst.class);
        
	/**
	 * Setup code that creates a new factory for use in all tests
	 * @throws java.lang.Exception
	 */
	@Before	
	protected void setUp() throws Exception {
		
		super.setUp();
		
		application1 = new Application (869088843,"RMF", "Adobe", "Firmware", "Lightning", "Production","OCAP","1239876","A987654321","OCAP Stack","http://www.adobe.com/ocap","Hans Bender","h.bender@adobe.com");                
        } 

	/**
	 * Test method for {@link com.voyage.model.services.applicationservice.ApplicationSvcHibernateImpl#storeApplication(com.voyage.model.domain.Application)}.
	 */
	@Test
	public void testStoreApplication() {
		
		MetadataManager applicationSvc;
		applicationSvc = (MetadataManager)context.getBean("MetadataManager"); 
		applicationSvc.setApplication(null, application1);
                        log.info ("testStoreApplication PASSED");	}

	/**
	 * Test method for {@link com.voyage.model.services.applicationservice.ApplicationSvcHibernateImpl#getApplication()}.
	 */
	@Test
	public void testGetApplication() {
		fail("Not yet implemented");
	}

}
