package org.wrzesien.$14Spring.Intro.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleBean {
	private InjectedBean injectedBean;
	private AnotherInjectedBean anotherInjectedBean;

	public ExampleBean() {
		System.out.println("Calling example beans.");
	}

	//	@Autowired
	public ExampleBean(final InjectedBean injectedBean, final AnotherInjectedBean anotherInjectedBean) {
		this.injectedBean = injectedBean;
		this.anotherInjectedBean = anotherInjectedBean;
		System.out.println("Calling ExampleBean(...)");
	}

	public void exampleMethod() {
		System.out.println("exampleMethod();" + injectedBean + ", " + anotherInjectedBean);
	}

	@Autowired
	public void setInjectedBean(final InjectedBean injectedBean) {
		this.injectedBean = injectedBean;
		System.out.println("setInjectedBean");
	}

	@Autowired
	public void setAnotherInjectedBean(final AnotherInjectedBean anotherInjectedBean) {
		this.anotherInjectedBean = anotherInjectedBean;
		System.out.println("setAnotherInjectedBean");
	}
}
