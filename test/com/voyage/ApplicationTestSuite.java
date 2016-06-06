package com.voyage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



import com.voyage.model.business.AllBusinessTests;
// import com.voyage.model.business.AllBusinessTests;
import com.voyage.model.domain.AllDomainTests;
// import com.voyage.model.services.AllServicesTests;
import com.voyage.model.services.AllServicesTests;



/** 
 * Runs all test suites in the domain, services and business layers
 * @author JasonCanney
 *
 */
@RunWith(Suite.class)
@SuiteClasses({AllBusinessTests.class, AllServicesTests.class, AllDomainTests.class})
public class ApplicationTestSuite {

}
