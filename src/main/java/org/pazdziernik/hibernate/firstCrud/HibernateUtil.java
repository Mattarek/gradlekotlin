package org.pazdziernik.hibernate.firstCrud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.imageio.spi.ServiceRegistry;
import java.util.Map;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = loadSessionFactory();
	private static final Map<String, Object> SETTINGS = Map.ofEntries()

	private static SessionFactory loadSessionFactory() {
		try {
			final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySetting()
					.build();

			final Metadata metadata =
					new MetadataSources(serviceRegistry)
							.addAnnotatedClass(Employee.class)
							.getMetadataBuilder()
							.build();

			return metadata.getSessionFactoryBuilder().build();
		} catch (final Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
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
