package org.wrzesien.$14Spring.Intro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class Main {
	// Konfiguacja jawna
	// - pliki XML
	// - Oparta o Javę
	// Konfiguracja automatczna (niejawna)
	// - Adnotacje

	public static void main(final String[] args) {
		final ApplicationContext context = new AnnotationConfigApplicationContext(ExampleConfigurationClass.class);
		System.out.println("Context created.");
		final ExampleBean exampleBean = context.getBean("exampleBean", ExampleBean.class);
		Arrays.asList(context.getBeanDefinitionNames()).forEach(System.out::println);
		exampleBean.exampleMethod();
	}
}
