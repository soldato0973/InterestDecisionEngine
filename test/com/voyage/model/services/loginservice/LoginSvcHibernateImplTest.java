/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voyage.model.services.loginservice;

import com.voyage.model.domain.User;
import com.voyage.model.services.loginservice.LoginSvcHibernateImpl;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author JasonCanney
 */
public class LoginSvcHibernateImplTest extends TestCase{

    private User user1;

    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
		// factory = Factory.getInstance();
		user1 = new User ("jcanney","","","","canney","","");
        
        }

        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(LoginSvcHibernateImplTest.class);

    /**
     * Test of loginUser method, of class LoginSvcHibernateImpl.
     */
    @Test
    public void testLoginUser() {
        log.info ("LoginSvcHibernateImplTest - testLoginUser");
        LoginSvcHibernateImpl instance = new LoginSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.loginUser(user1);
        assertEquals(expResult, result);
    }
}
