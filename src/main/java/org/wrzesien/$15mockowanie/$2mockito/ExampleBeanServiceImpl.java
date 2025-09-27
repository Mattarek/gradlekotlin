package org.wrzesien.$15mockowanie.$2mockito;

public class ExampleBeanServiceImpl implements ExampleBeanService {

	private InjectedBeanService injectedBeanService;

	@Override
	public void setInjectedBeanService(final InjectedBeanService injectedBeanService) {
		this.injectedBeanService = injectedBeanService;
	}

	@Override
	public boolean sampleMethod() {
		return injectedBeanService.anotherSampleMethod();
	}
}
