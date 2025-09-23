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
		System.out.println("### Before context ###");
		final AbstractApplicationContext context = new AnnotationConfigApplicationContext(ExampleConfigurationClass.class);
		final ExampleSingletonBean singletonOne = context.getBean(ExampleSingletonBean.class);
		final ExampleSingletonBean singletonTwo = context.getBean(ExampleSingletonBean.class);

		final ExamplePrototypeBean prototypeOne = context.getBean(ExamplePrototypeBean.class);
		final ExamplePrototypeBean prototypeTwo = context.getBean(ExamplePrototypeBean.class);

		System.out.println("SingletonOne == SingletonTwo: " + (singletonOne == singletonTwo));
		System.out.println("PrototypeOne == PrototypeTwo: " + (prototypeOne == prototypeTwo));

		final InjectedBean injectedBean = context.getBean(InjectedBean.class);
		final boolean isInjectedBeanAsSingleton = injectedBean == singletonOne.getInjectedBean()
				&& injectedBean == singletonOne.getInjectedBean()
				&& injectedBean == prototypeOne.getInjectedBean()
				&& injectedBean == prototypeTwo.getInjectedBean();

		System.out.println("Is injectedBean a Singleton? " + isInjectedBeanAsSingleton);
	}
}
