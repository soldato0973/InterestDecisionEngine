package com.voyage.model.business;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.voyage.model.business.factory.FactoryTest;
import com.voyage.model.business.manager.AppManagerTest;
import com.voyage.model.business.manager.LoginManagerTest;
import com.voyage.model.business.manager.MetadataManagerTest;

/**
 * Properties are being passed is using the -D option.
 * This test suite runs all business layer test cases 
 * 
 * @author Jason Canney
 *
 */

@RunWith(Suite.class)
@SuiteClasses({ MetadataManagerTest.class, LoginManagerTest.class, AppManagerTest.class, FactoryTest.class})
public class AllBusinessTests {

}
