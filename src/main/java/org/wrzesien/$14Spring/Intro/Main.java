package org.wrzesien.$14Spring.Intro;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.wrzesien.$14Spring.Intro.code.ExamplePrototypeBean;
import org.wrzesien.$14Spring.Intro.code.ExampleSingletonBean;
import org.wrzesien.$14Spring.Intro.code.InjectedBean;
import org.wrzesien.$14Spring.Intro.configuration.ExampleConfigurationClass;

import java.util.Arrays;

public class Main {
	// Konfiguacja jawna
	// - pliki XML
	// - Oparta o Javę
	// Konfiguracja automatczna (niejawna)
	// - Adnotacje

	public static void main(final String[] args) {
		final AbstractApplicationContext context = new AnnotationConfigApplicationContext(ExampleConfigurationClass.class);

		System.out.println();
		System.out.println("### Singleton ###");
		final ExampleSingletonBean singletonBeanOne = context.getBean(ExampleSingletonBean.class);
		final ExampleSingletonBean singletonBeanTwo = context.getBean(ExampleSingletonBean.class);

		System.out.println("PrototypeOne.exampleValue = " + singletonBeanOne.getExampleValue());
		System.out.println("PrototypeTwo.exampleValue = " + singletonBeanTwo.getExampleValue());

		System.out.println("### singletonBeanOne.setExampleValue(2) ###");
		singletonBeanOne.setExampleValue(2);

		System.out.println("singletonBeanOne.exampleValue = " + singletonBeanOne.getExampleValue());
		System.out.println("singletonBeanTwo.exampleValue = " + singletonBeanTwo.getExampleValue());
		System.out.println();
		System.out.println("### Prototype ###");
		final ExamplePrototypeBean prototypeBeanOne = context.getBean(ExamplePrototypeBean.class);
		final ExamplePrototypeBean prototypeBeanTwo = context.getBean(ExamplePrototypeBean.class);

		System.out.println("PrototypeOne.exampleValue = " + prototypeBeanOne.getExampleValue());
		System.out.println("PrototypeTwo.exampleValue = " + prototypeBeanTwo.getExampleValue());

		System.out.println("### prototypeBeanOne.setExampleValue(2) ###");
		prototypeBeanOne.setExampleValue(2);

		System.out.println("PrototypeOne.exampleValue = " + prototypeBeanOne.getExampleValue());
		System.out.println("PrototypeTwo.exampleValue = " + prototypeBeanTwo.getExampleValue());
	}
}
