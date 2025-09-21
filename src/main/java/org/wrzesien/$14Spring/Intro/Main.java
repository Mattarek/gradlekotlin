package org.wrzesien.$14Spring.Intro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wrzesien.$14Spring.Intro.code.InjectedBean;
import org.wrzesien.$14Spring.Intro.configuration.ExampleConfigurationClass;

public class Main {
	// Konfiguacja jawna
	// - pliki XML
	// - Oparta o Javę
	// Konfiguracja automatczna (niejawna)
	// - Adnotacje

	public static void main(final String[] args) {
		final ApplicationContext context = new AnnotationConfigApplicationContext(ExampleConfigurationClass.class);

		System.out.println("Context created.");

		final InjectedBean bean = context.getBean(InjectedBean.class);
		bean.someMethod();
	}
}
