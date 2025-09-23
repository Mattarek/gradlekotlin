package org.wrzesien.$14Spring.Intro.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope("prototype")
public class ExamplePrototypeBean {
	private final InjectedBean injectedBean;
	private int exampleValue = 1;

	@Autowired
	public ExamplePrototypeBean(final InjectedBean injectedBean) {
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
