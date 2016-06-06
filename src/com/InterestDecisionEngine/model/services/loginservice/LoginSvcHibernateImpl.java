package com.voyage.model.services.loginservice;

import com.voyage.model.domain.User;
import com.voyage.model.services.factory.HibernateFactory;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * LoginSvcHibernateImpl is the service implementation class to store and retrieve User
 * objects to/from the database through Hibernate
 * @author Jason.Canney
 * 
 */

public class LoginSvcHibernateImpl implements ILoginService
{
	
	/*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
 static Logger log = Logger.getLogger(LoginSvcHibernateImpl.class);
	
   
 
 /**
  * Set Application data received from GUI and put in database
  * @param application
  * @return boolean
  */
 
  
        public boolean loginUser(User user)
        {
          boolean status = false;
            log.info("-------------------------------");
            log.info("Using Hibernate Login Implementation");
            log.info("-------------------------------");

            log.info ("getLogin - LoginSvcHibernateImpl.java");
 
            User userdb  = user;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                
                
                /* ResultSet rs = (ResultSet)session.createSQLQuery("select * from user where userName = '"+userdb.getUserName()+"' and password ='"+userdb.getPassword()+"'");
                
                if ( rs.next() ) {
                    // curser has moved to first result of the ResultSet 
                    // thus here are matches with this query.
                    status = true;
                    log.info ("UID and PWD match found");
                }  
                */
                
                // through the session sends a contains message with the UID and PWD from the GUI to Mysql through hibernate
                // will get a true/false response
                // the boolean gets sent back to the gui and a response presented to the user
                // Send user object from GUI to hibernate to see if its is there with getUserName
                User checkUser = (User) session.get(User.class, userdb.getUserName()); 
                if (checkUser == null) {
                    log.info("No Such User");
                } else {
                    if (checkUser.getPassword().equals(userdb.getPassword()))
                    {
                        log.info ("Passwords match");
                        status = true;
                    }
                    else 
                        log.info ("Passwords don't match");
                }
                          
             
                // status = session.contains(userdb);
                //log.info ("The status passed back from session.contains was " + status.toString());
                
                tx.commit();
                log.info("LoginSvcHibernateImpl session closed");
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
            log.info ("LoginSvcHibernateImpl.java getLogin return status True");
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

	
} // end class LoginSvcHibernateImpl