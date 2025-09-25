package org.wrzesien.$14SpringBean.$3SpringBeansProblem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import org.wrzesien.$14SpringBean.$3SpringBeansProblem.code.PrototypeBean;
import org.wrzesien.$14SpringBean.$3SpringBeansProblem.code.SingletonBean;
import org.wrzesien.$14SpringBean.$3SpringBeansProblem.configuration.ExampleConfigurationClass;

@ComponentScan("org.wrzesien.$14Spring.SpringBeansProblem")
public class Main {
	public static void main(final String[] args) {
		final AbstractApplicationContext context = new AnnotationConfigApplicationContext(ExampleConfigurationClass.class);

		final SingletonBean firstSingletonBean = context.getBean(SingletonBean.class);
		final PrototypeBean firstPrototype = firstSingletonBean.callPrototype();

		final SingletonBean secondSingletonBean = context.getBean(SingletonBean.class);
		final PrototypeBean secondPrototype = secondSingletonBean.callPrototype();

		System.out.println("FirstPrototype == SecondPrototype: " + (firstPrototype == secondPrototype));
	}
}
