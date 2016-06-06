package com.voyage.model.services.factory;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Configures and provides access to Hibernate sessions, tied to the
 * current thread of execution.  Follows the Thread Local Session
 * pattern, see {@link http://hibernate.org/42.html}.
 */
public class HibernateFactory {

    static Logger log = Logger.getLogger(HibernateFactory.class);
    
    /**
     * Location of hibernate.cfg.xml file.
     * NOTICE: Location should be on the classpath as Hibernate uses
     * #resourceAsStream style lookup for its configuration file. That
     * is place the config file in a Java package - the default location
     * is the default Java package.<br><br>
     * Examples: <br>
     * <code>CONFIG_FILE_LOCATION = "/hibernate.conf.xml".
     * CONFIG_FILE_LOCATION = "/com/foo/bar/myhiberstuff.conf.xml".</code>
     */
    //private static String CONFIG_FILE_LOCATION = "config/hibernate.cfg.xml";
	
	   // In NetBeans, it is copied to the build\classes folder and hence can be
	   // found without having to refer to the config folder
    private static String CONFIG_FILE_LOCATION = "hibernate.cfg.xml";

    /** Holds a single instance of Session */
   private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

    /** The single instance of hibernate configuration */
    private static final Configuration cfg = new Configuration();

    /** The single instance of hibernate SessionFactory */
    private static org.hibernate.SessionFactory sessionFactory;

    private static ServiceRegistry serviceRegistry;

    /**
     * Returns the ThreadLocal Session instance.  Lazy initialize
     * the <code>SessionFactory</code> if needed.
     *
     *  @return Session
     *  @throws HibernateException
     */
    public static Session currentSession() throws HibernateException 
				{
  Session session = (Session) threadLocal.get();

    if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                try {
                    cfg.configure(CONFIG_FILE_LOCATION);
                    log.info ("got config file");
                    // NOTE: buildSessionFactory() is deprecated in Hibernate 4.1.X
                    //sessionFactory = cfg.buildSessionFactory();				
									
         serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();        
         sessionFactory = cfg.buildSessionFactory(serviceRegistry);
									
                } catch (Exception e) {
                        log.error("%%%% Error Creating SessionFactory %%%%", e);
                }
        }
        session = (sessionFactory != null) ? sessionFactory.openSession() : null;
        threadLocal.set(session);
        }
      return session;
    }

    /**
     *  Close the single hibernate session instance.
     *
     *  @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

    /**
     * Default constructor.
     */
    private HibernateFactory() {
    }

}
