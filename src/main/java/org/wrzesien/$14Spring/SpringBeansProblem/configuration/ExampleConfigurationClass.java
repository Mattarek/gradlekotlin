package org.wrzesien.$14Spring.SpringBeansProblem.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.wrzesien.$14Spring.Intro.Main;
import org.wrzesien.$14Spring.SpringBeansProblem.code.PrototypeBean;
import org.wrzesien.$14Spring.SpringBeansProblem.code.SingletonBean;

@Configuration
@ComponentScan(basePackageClasses = Main.class)
public class ExampleConfigurationClass {

	@Bean
	public SingletonBean singletonBean(final PrototypeBean prototypeBean) {
		return new SingletonBean(prototypeBean);
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PrototypeBean prototypeBean() {
		return new PrototypeBean();
	}
}
