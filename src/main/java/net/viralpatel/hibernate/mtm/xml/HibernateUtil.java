package net.viralpatel.hibernate.mtm.xml;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	//Raccourcis : Alt+Shift+S, R	OU Control-1 
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory annotationsSessionFactory = null;
	private static SessionFactory buildSessionFactory() {
		try {
			
			 // Create the SessionFactory for Annotations mapping, from hibernate.cfg.xml
			annotationsSessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            
			// Create the SessionFactory For XML mapping, from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static SessionFactory getAnnotationsSessionFactory() {
		return annotationsSessionFactory;
	}

	
	
	
	
}
