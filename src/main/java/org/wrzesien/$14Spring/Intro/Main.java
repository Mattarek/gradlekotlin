package org.wrzesien.$14Spring.Intro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	// Konfiguacja jawna
	// - pliki XML
	// - Oparta o Javę
	// Konfiguracja automatczna (niejawna)
	// - Adnotacje

	public static void main(final String[] args) {
		final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		System.out.println("Context created");
		final ExampleBean exampleBean = applicationContext.getBean("exampleBean", ExampleBean.class);
		exampleBean.exampleMethod();
	}
}
