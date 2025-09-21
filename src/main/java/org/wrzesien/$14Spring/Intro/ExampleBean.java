package org.wrzesien.$14Spring.Intro;

public class ExampleBean {
	private InjectedBean injectedBean;
	private AnotherInjectedBean anotherInjectedBean;

	public ExampleBean() {
		System.out.println("Calling ExampleBean() default constructor.");
	}

	public ExampleBean(final InjectedBean injectedBean, final AnotherInjectedBean anotherInjectedBean) {
		this.injectedBean = injectedBean;
		this.anotherInjectedBean = anotherInjectedBean;
		System.out.println("Calling ExampleBean().");
	}

	public void exampleMethod() {
		System.out.println("Calling exampleMethod.");
	}

	public void setInjectedBean(final InjectedBean injectedBean) {
		this.injectedBean = injectedBean;
	}

	public void setAnotherInjectedBean(final AnotherInjectedBean anotherInjectedBean) {
		this.anotherInjectedBean = anotherInjectedBean;
	}
}
