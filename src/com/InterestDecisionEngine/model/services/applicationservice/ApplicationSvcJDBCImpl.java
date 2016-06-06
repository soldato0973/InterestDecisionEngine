package com.voyage.model.services.applicationservice;

import com.voyage.model.domain.Application;
import com.voyage.model.services.exception.ApplicationException;
import com.voyage.model.services.manager.PropertyManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import org.apache.log4j.Logger;


/**
 * ApplicationSvcJDBCImpl is the service implementation class to store and retrieve Appplication
 * objects to/from the database through JDBC
 * @author Jason Canney
 *
 *
 */

public class ApplicationSvcJDBCImpl implements IApplicationSvc
{
	
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
 	  static Logger log = Logger.getLogger(ApplicationSvcJDBCImpl.class);
			
	/**
         * Using the connection parameters from the property files, loads and
	 * registers the JDBC driver and gets the database connection and returns in.
	 *
         * @return Connection Connection returned on success otherwise returns null
	 * @throws SQLException
	 */
        private Connection fetchConnection() throws SQLException
        {
                        log.info ("Fetching Database Connection");

                        // Connection conn = null;
                        /*
                                * Values come out of the ...JDBCDAOSample\config\application.properties
                                * file
                                */
                                String url      = PropertyManager.getPropertyValue("jdbc.url");
                                String userid   = PropertyManager.getPropertyValue("jdbc.user");
                                String password = PropertyManager.getPropertyValue("jdbc.password");
                                Connection conn = DriverManager.getConnection(url, userid, password);

                                //load and register JDBC driver then connect to database
                                try
                                {
                                DriverManager.registerDriver( new com.mysql.jdbc.Driver());
                                log.info("connection with database successful");
                                }
                                catch (NullPointerException e)
                                {
                                    log.info("Null Pointer Exception", e);
                                    log.error  (e.getClass()+": "+ e.getMessage(), e);         
                                }
                                catch (SQLException e)
                                {
                                 log.error("Could not load and register JDBC driver or connect to database.");         
                                 log.error  (e.getClass()+": "+ e.getMessage(), e);         
                                }
                        return conn;
        } //end fetchConnection

       /**
        * Set Application data received from GUI and put in database
        * @param application takes an application object into the method
        * @return boolean
        */
        public boolean storeApplication(Application application)
        {
          boolean status = true;
          log.info("-------------------------------");
          log.info("Using JDBC Implementation");
          log.info("-------------------------------");

          log.info ("Inside store Application");

          Application appdb  = application;
          Statement stmt = null;
          Connection conn = null;
          int appID = appdb.getAppID(); 
          log.info (appID);  
          String appName = appdb.getAppName();
          log.info (appName);
          String appVendor = appdb.getAppVendor();
          log.info (appVendor);          
          String applicationType = appdb.getApplicationType();
          log.info (applicationType);
          String appVers = appdb.getAppVers();
          log.info (appVers);
          String appState = appdb.getAppState();
          log.info (appState);
          String appProdName = appdb.getAppProdName();
          log.info (appProdName);
          String appFileSize = appdb.getAppFileSize();
          log.info (appFileSize);
          String appCheckSum = appdb.getAppCheckSum();
          log.info (appCheckSum);
          String appDescription = appdb.getAppDescription();
          log.info (appDescription);
          String appURL = appdb.getAppURL();
          log.info (appURL);
          String appContactName = appdb.getAppContactName();
          log.info (appContactName);
          String appContactEmail = appdb.getAppContactEmail();
          log.info (appContactEmail);              
          
          String insertTableSQL = "INSERT INTO application"
                                  + "("
                                  + "appID"
                                  + ",appName"
                                  + ",appVendor"
                                  + ",applicationType"
                                  + ",appVers"
                                  + ",appState"
                                  + ",appProdName"
                                  + ",appFileSize"
                                  + ",appCheckSum"
                                  + ",appDescription"
                                  + ",appURL"
                                  + ",appContactName"
                                  + ",appContactEmail"
                                  + ") VALUES ('"
                                  + appID + "','"
                                  + appName + "','"
                                  + appVendor + "','"
                                  + applicationType + "','"
                                  + appVers + "','"
                                  + appState + "','"
                                  + appProdName + "','"
                                  + appFileSize + "','"
                                  + appCheckSum + "','"
                                  + appDescription + "','"
                                  + appURL + "','"
                                  + appContactName + "','"
                                  + appContactEmail
                                  + "')";
          
          try
          {
            // Create a connection
          conn = fetchConnection();
          log.info("---->made a jdbc connection within store application!");
 
            if (conn != null)
            {	
              // Create a statement.
              stmt = conn.createStatement();
              log.info (insertTableSQL);

              //NOTE: Not using a PreparedStatement since we are not binding any variables
              stmt.executeUpdate(insertTableSQL);
              log.info ("Record is inserted into application table!");
            }
          }
          catch(SQLException e)
          {
            log.error  (e.getClass()+": "+ e.getMessage(), e);
          }
          finally //must close resources in finally block
          {
          try 
            {
              // check for null first before closing resources
              if (stmt != null) {
                 stmt.close();
              }
              if (conn != null) {
                 conn.close();
              }												
            }
            catch (SQLException e)
            {// No need to propagate as storedApplications state conveys										
              log.error  (e.getClass()+": "+ e.getMessage(), e);									
            } 
          }						
    return status;
    } // storeApplication

     
     /**
      * getApplication method pulls a <list> of application objects from the database using JDBC
      * @returns <list> of application objects
      */
        public Set<Application> getApplication() throws ApplicationException, ClassNotFoundException {
                log.info("Entering method getApplication");
		// boolean isValid = true;

		ObjectInputStream input = null;
		
		try { // beginning of try/catch/finally logic
			input = new ObjectInputStream (new FileInputStream("Applications.out"));
			Set<Application> mySetIn;
                        mySetIn = (Set<Application>) input.readObject();
                                            
    			if (mySetIn !=null){
				
                                return mySetIn;}
			else
			{
				throw new ApplicationException ("Null Application passed to input stream, file empty");
			}			
			
		} catch (IOException ioe) { /** File present but cannot read for some reason */
			log.error ("IOException while accessing file to read application!", ioe); // logging file not found error
			throw new ApplicationException ("IOException while accessing file to read application", ioe);
		} catch (ClassNotFoundException cnfe) { /** file does not contain the class you think it 
		contains.  Not an IO error or a file empty error, but just wrong type of class */
                        log.error ("ClassNotFoundException while reading file containing application!", cnfe); // logging class not found errors
                        throw new ClassNotFoundException ("ClassNotFoundException while reading file containing application", cnfe);
	}		
        finally
        {
			if (input != null)
			{	
			   try {
				   input.close();
			   } catch (IOException e) {
				// catches exception error
				e.printStackTrace();
                                log.error ("All other errors passed, something wrong getApplication", e);  // default logging error
			   }
		    }
        } // end try/catch/finally
    
    } // end getApplication
} // end class ApplicationSvcJDBCImpl