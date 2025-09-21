package org.wrzesien.$14Spring.Intro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //
public class ExampleConfigurationClass {
	@Bean
	public ExampleBean exampleBean(final InjectedBean injectedBean, final AnotherInjectedBean anotherInjectedBean) {
		return new ExampleBean(injectedBean, anotherInjectedBean);
	}

	@Bean
	public InjectedBean injectedBean() {
		return new InjectedBean();
	}

	@Bean
	public AnotherInjectedBean anotherInjectedBean() {
		return new AnotherInjectedBean();
	}
}
