package org.wrzesien.$15mockowanie.$2mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleBeanServiceImplTest {

	@Test
	public void sampleMethod() {
		// given
		final ExampleBeanService exampleBeanService = new ExampleBeanServiceImpl();
		exampleBeanService.setInjectedBeanService(new StubInjectedBeanService());

		// when
		final boolean result = exampleBeanService.sampleMethod();

		// then
		Assertions.assertTrue(result);
	}

	static class StubInjectedBeanService implements InjectedBeanService {
		@Override
		public boolean anotherSampleMethod() {
			return false;
		}
	}
}
