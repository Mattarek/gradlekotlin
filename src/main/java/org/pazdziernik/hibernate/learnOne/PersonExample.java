package org.pazdziernik.hibernate.learnOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersonExample {
	public static void main(final String[] args) {
		try (
				final SessionFactory sessionFactory = createSessionFactory();
				final Session session = sessionFactory.openSession()
		) {
			session.beginTransaction();
			final Person person = new Person();
			person.setName("Robert");
			person.setAge(38);
			session.persist(person);
			session.getTransaction().commit();

			final Person personOne = session.find(Person.class, 1);
			System.out.println(personOne);
		}
	}

	private static SessionFactory createSessionFactory() {
		final Configuration configuration = new Configuration();
		configuration.configure("/META-INFO/hibernate.cfg.xml");
		return configuration.buildSessionFactory();
	}
}
