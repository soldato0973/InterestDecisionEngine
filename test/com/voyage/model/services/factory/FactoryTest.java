package com.voyage.model.services.factory;

import com.voyage.model.business.exception.ServiceLoadException;
import com.voyage.model.services.applicationservice.ApplicationSvcHibernateImpl;
import com.voyage.model.services.applicationservice.IApplicationSvc;
import com.voyage.model.services.releaseservice.IReleaseSvc;
import com.voyage.model.services.releaseservice.ReleaseSvcHibernateImpl;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the services.Factory class
 * @author Jason Canney
 *
 */
public class FactoryTest extends TestCase {
	Factory factory = null;
	
	@Before
	public void setUp() throws Exception {
		factory = new Factory();
		factory = Factory.getInstance();		
	}
	
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(FactoryTest.class);

        
    /**
     * Test Factory to return the applicationservice and assert it by 
     * checking it is an instance of ApplicationSvcImpl_Archive
     * 
     * This should be true since ApplicationSvcImpl_Archive implements IApplicationSvc
     */
	@Test
	public void testFactoryApplicationService() {
 		IApplicationSvc applicationService;
		try {
                    log.info ("Starting testApplicationService");
			applicationService = (IApplicationSvc)factory.getService(IApplicationSvc.NAME);
	  	    assertTrue(applicationService instanceof ApplicationSvcHibernateImpl);
	           log.info ("testApplicationService PASSED");	  	    
		} catch (ServiceLoadException e) {
                        log.error ("ServiceLoadException triggered in testApplicationService FactoryTest",e); // service load logger in FactoryTest
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

	 /**
     * Test Factory to return the releaseservice and assert it by 
     * checking it is an instance of ReleaseSvcImpl_Archive
     * 
     * This should be true since ReleaseSvcImpl_Archive implements IReleaseSvc
     */
	@Test
	public void testFactoryReleaseService() {
 		IReleaseSvc releaseService;
		try {
		    log.info ("Starting testReleaseService");
                    releaseService = (IReleaseSvc)factory.getService(IReleaseSvc.NAME);
	  	    assertTrue(releaseService instanceof ReleaseSvcHibernateImpl);
                        log.info ("testReleaseService PASSED");
		} catch (ServiceLoadException e) {
                        log.error ("ServiceLoadException triggered in testReleaseService FactoryTest",e); // service load logger in FactoryTest
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}
}
