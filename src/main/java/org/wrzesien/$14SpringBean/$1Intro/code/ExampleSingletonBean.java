package org.wrzesien.$14SpringBean.$1Intro.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ExampleSingletonBean {
	private final InjectedBean injectedBean;
	private int exampleValue = 1;

	@Autowired
	public ExampleSingletonBean(final InjectedBean injectedBean) {
		this.injectedBean = injectedBean;
	}

	public int getExampleValue() {
		return exampleValue;
	}

	public void setExampleValue(final int exampleValue) {
		this.exampleValue = exampleValue;
	}

	public void exampleMethod() {
		injectedBean.someMethod();
	}

	public InjectedBean getInjectedBean() {
		return injectedBean;
	}
}
