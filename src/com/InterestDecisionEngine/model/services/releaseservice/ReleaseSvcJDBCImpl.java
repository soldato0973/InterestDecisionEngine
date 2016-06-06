package com.voyage.model.services.releaseservice;

import com.voyage.model.domain.Release;
import com.voyage.model.services.exception.ReleaseException;
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
 * ReleaseSvcJDBCImpl is the service implementation class to store and retrieve Release
 * objects to/from the database through JDBC
 * @author Jason Canney
 *
 *
 */

public class ReleaseSvcJDBCImpl implements IReleaseSvc
{
	
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
 	  static Logger log = Logger.getLogger(ReleaseSvcJDBCImpl.class);
			
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
                        
                        /*
                                * Values come out of the ...JDBCDAOSample\config\application.properties
                                * file
                                */
                                String url      = PropertyManager.getPropertyValue("jdbc.url");
                                String userid   = PropertyManager.getPropertyValue("jdbc.user");
                                String password = PropertyManager.getPropertyValue("jdbc.password");
          //                    Connection conn = null;
                                Connection conn = DriverManager.getConnection(url, userid, password);
                                log.info ("got property manager jdbc values");
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
        * @param release object to push into the database through JDBC
        * @return boolean
        */
        
        public boolean storeRelease(Release release)
        {
          boolean status = true;
          log.info("-------------------------------");
          log.info("Using JDBC Implementation");
          log.info("-------------------------------");

          log.info ("Inside store Release");

          Release reldb  = release;
          Statement stmt = null;
          Connection conn = null;
          String relName = reldb.getReleaseName();
          log.info (relName);  
          String relNumber = reldb.getReleaseNumber();
          log.info (relNumber);       
          String relType = reldb.getReleaseType();
          log.info (relType);
          
          
          String insertTableSQL = "INSERT INTO releases"
                                  + "("
                                  + "relName"
                                  + ",relNumber"
                                  + ",relType"
                                  + ") VALUES ('"
                                  + relName + "','"
                                  + relNumber + "','"
                                  + relType
                                  + "')";
          
          try
          {
            // Create a connection
          conn = fetchConnection();
          log.info("---->made a jdbc connection within store release!");
 
            if (conn != null)
            {	
              // Create a statement.
              stmt = conn.createStatement();
              log.info (insertTableSQL);

              //NOTE: Not using a PreparedStatement since we are not binding any variables
              stmt.executeUpdate(insertTableSQL);
              log.info ("Record is inserted into release table!");
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
    } // storeRelease

        /**
         * getRelease method to pull a <list> of Release objects from the database through JDBC
         * @return <list> Release
         * @throws ClassNotFoundException
         * @throws ReleaseException 
         */
        public Set<Release> getRelease() throws ClassNotFoundException, ReleaseException {
                log.info("Entering method getRelease");
		// boolean isValid = true;

		ObjectInputStream input = null;
		
		try { // beginning of try/catch/finally logic
			input = new ObjectInputStream (new FileInputStream("Applications.out"));
			Set<Release> mySetIn;
                        mySetIn = (Set<Release>) input.readObject();
                                            
    			if (mySetIn !=null){
				
                                return mySetIn;}
			else
			{
				throw new ReleaseException ("Null Release passed to input stream, file empty");
			}			
			
		} catch (IOException ioe) { /** File present but cannot read for some reason */
			log.error ("IOException while accessing file to read release!", ioe); // logging file not found error
			throw new ReleaseException ("IOException while accessing file to read release", ioe);
		} catch (ClassNotFoundException cnfe) { /** file does not contain the class you think it 
		contains.  Not an IO error or a file empty error, but just wrong type of class */
                        log.error ("ClassNotFoundException while reading file containing release!", cnfe); // logging class not found errors
                        throw new ClassNotFoundException ("ClassNotFoundException while reading file containing release", cnfe);
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
                                log.error ("All other errors passed, something wrong getRelease", e);  // default logging error
			   }
		    }
        } // end try/catch/finally
    
    } // end getRelease
    
} // end class ReleaseSvcJDBCImpl