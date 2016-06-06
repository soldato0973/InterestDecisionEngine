package com.voyage.model.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.voyage.model.services.applicationservice.AppSvcHibernateImplTest;
import com.voyage.model.services.applicationservice.ApplicationSvcTst;
import com.voyage.model.services.factory.*;
import com.voyage.model.services.loginservice.LoginSvcHibernateImplTest;
import com.voyage.model.services.manager.SAXPropertyManagerTst;
import com.voyage.model.services.releaseservice.ReleaseSvcTest;
/** Test suite runs all service level tests */
@RunWith(Suite.class)
@SuiteClasses({ 
		SAXPropertyManagerTst.class,
		AppSvcHibernateImplTest.class,
        ApplicationSvcTst.class,
        ReleaseSvcTest.class,
        LoginSvcHibernateImplTest.class,
        HibernateFactoryTest.class
})
public class AllServicesTests {

}
