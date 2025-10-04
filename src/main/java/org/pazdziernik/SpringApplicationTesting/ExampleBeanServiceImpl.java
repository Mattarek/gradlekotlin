package org.pazdziernik.SpringApplicationTesting;

public class ExampleBeanServiceImpl implements ExampleBeanService {
	private InjectedBeanService injectedBeanService;

	@Override
	public boolean sampleMethod() {
		return injectedBeanService.anotherSampleMethod();
	}
}
