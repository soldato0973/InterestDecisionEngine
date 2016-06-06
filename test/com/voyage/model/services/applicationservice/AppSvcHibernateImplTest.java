/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyage.model.services.applicationservice;

import com.voyage.model.domain.Application;
import com.voyage.model.services.applicationservice.ApplicationSvcHibernateImpl;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author JasonCanney
 */
public class AppSvcHibernateImplTest extends TestCase{

    private Application application1;

    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
		// factory = Factory.getInstance();
		application1 = new Application (8675309,"RMF", "Canoe", "Firmware", "Awesomness", "Production","OCAP","1239876","A987654321","OCAP Stack","http://www.adobe.com/ocap","Hans Bender","h.bender@adobe.com");                
        
        }

        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(AppSvcHibernateImplTest.class);

    /**
     * Test of loginUser method, of class LoginSvcHibernateImpl.
     */
    @Test
    public void testAppSvcHibernate() {
        log.info ("AppSvcHibernateImplTest - testAppSvcHibernate");
        ApplicationSvcHibernateImpl instance = new ApplicationSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.storeApplication(application1);
        assertEquals(expResult, result);
    }
}
