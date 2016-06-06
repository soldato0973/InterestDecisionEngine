package com.voyage.model.services.applicationservice;

import com.voyage.model.domain.Application;
import com.voyage.model.services.exception.ApplicationException;
import com.voyage.model.services.factory.HibernateFactory;
import java.util.Set;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * ApplicationSvcHibernateImpl is the service implementation class to store and retrieve Application
 * objects to/from the database through Hibernate
 * @author Jason.Canney
 * 
 */

public class ApplicationSvcHibernateImpl implements IApplicationSvc
{
	
	/*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
 static Logger log = Logger.getLogger("ApplicationSvcHibernateImpl.class");
	
   
 
 /**
  * Set Application data received from GUI and put in database
  * @param application
  * @return boolean
  */
 
  public boolean storeApplication(Application application)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("storeApplication - ApplicationSvcHibernateImpl.java");
 
            Application appdb  = application;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.save(appdb);
                log.info ("session.saved");
                tx.commit();
                log.info("Application saved. Check database for data!");
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
       }  
         
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
     * Not implemented use case.  Pulls data from database through hibernate interface
     * @return <list> of applications
     */
    public Set<Application> getApplication() throws ApplicationException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
	
} // end class ApplicationSvcHibernateImpl