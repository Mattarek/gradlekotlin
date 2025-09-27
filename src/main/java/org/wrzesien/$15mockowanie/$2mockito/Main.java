package org.wrzesien.$15mockowanie.$2mockito;

public class Main {
	public static void main(final String[] args) {
		final InjectedBeanServiceImpl injectedBeanService = new InjectedBeanServiceImpl();
		final ExampleBeanService exampleBeanService = new ExampleBeanServiceImpl();
		exampleBeanService.setInjectedBeanService(injectedBeanService);

		System.out.println(exampleBeanService.sampleMethod());
	}
}
