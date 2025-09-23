package org.wrzesien.$14Spring.Intro.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ExampleSingletonBean {
	private final InjectedBean injectedBean;

	@Autowired
	public ExampleSingletonBean(final InjectedBean injectedBean) {
		this.injectedBean = injectedBean;
	}

	public void exampleMethod() {
		injectedBean.someMethod();
	}

	public InjectedBean getInjectedBean() {
		return injectedBean;
	}
}
