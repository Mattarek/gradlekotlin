package org.wrzesien.$14Spring.Intro;

public class ExampleBean {
	private final InjectedBean injectedBean;
	private final AnotherInjectedBean anotherInjectedBean;

	public ExampleBean(final InjectedBean injectedBean, final AnotherInjectedBean anotherInjectedBean) {
		this.injectedBean = injectedBean;
		this.anotherInjectedBean = anotherInjectedBean;
	}

	public void exampleMethod() {
		System.out.println("exampleMethod();");
	}
}
