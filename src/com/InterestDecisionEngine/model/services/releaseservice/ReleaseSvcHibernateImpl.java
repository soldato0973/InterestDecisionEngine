package com.voyage.model.services.releaseservice;

import com.voyage.model.domain.Release;
import com.voyage.model.services.exception.ReleaseException;
import com.voyage.model.services.factory.HibernateFactory;
import java.util.Set;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * ReleaseSvcHibernateImpl is the service implementation class to store and retrieve Release
 * objects to/from the database through Hibernate
 * @author Jason.Canney
 *
 * 
 */

public class ReleaseSvcHibernateImpl implements IReleaseSvc
{
	
	/*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
 static Logger log = Logger.getLogger(ReleaseSvcHibernateImpl.class);
	
   
 
 /**
  * storeRelease stores a release object in the database through Hibernate
  * @param release takes a release object
  * @return boolean returns true if the save of the object to the database was successful
  */
 
        public boolean storeRelease(Release release)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("storeRelease - ReleaseSvcHibernateImpl.java");
 
            Release reldb  = release; // store the release that the method received in a local release object
            Transaction tx = null; // create a hibernate transaction
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.save(reldb);
                log.info ("session.saved");
                tx.commit();
                log.info("Release saved. Check database for data!");
            }
            catch(Exception e)
            {
              if (tx!=null) 
                            {
                                     tx.rollback();
                                     e.printStackTrace();

                            }
              log.error (e.getClass() + ": " + e.getMessage(), e);
            }
            return status;
       }  // end of storeRelease
         
	/**
	 * Gets a hibernate session from HibernateFactory
	 * 
	 * @return org.hibernate.Session
	 * 
	 */
	private Session fetchSession()
	{
			log.info ("******Fetching Hibernate Session");

			Session session = HibernateFactory.currentSession();

			return session;
	    
	} //end fetchConnection

    /**
     * getRelease method not implemented yet.  future use case
     * @return <list> of release objects
     * @throws ReleaseException
     * @throws ClassNotFoundException
     */
    public Set<Release> getRelease() throws ReleaseException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
	
} // end class ReleaseSvcHibernateImpl