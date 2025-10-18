package org.pazdziernik.hibernate.firstCrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilWithXml {
	private static SessionFactory sessionFactory;

	static {
		try {
			loadSessionFactory();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private static void loadSessionFactory() {
		final Configuration configuration = new Configuration();
		configuration.configure("/META-INFO/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}

	static void closeSessionFactory() {
		try {
			sessionFactory.close();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	static Session getSession() {
		try {
			return sessionFactory.openSession();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
