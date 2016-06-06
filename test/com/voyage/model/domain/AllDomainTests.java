package com.voyage.model.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
 /** runs all domain level classes in this suite */
@RunWith(Suite.class)
@SuiteClasses({ UserTest.class, ApplicationTest.class, ReleaseTest.class})
public class AllDomainTests {

}
