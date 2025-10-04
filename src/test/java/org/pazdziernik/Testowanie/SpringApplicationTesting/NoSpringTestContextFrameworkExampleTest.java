package org.pazdziernik.SpringApplicationTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wrzesien.$15mockowanie.$2mockito.ExampleBeanService;

public class NoSpringTestContextFrameworkExampleTest {
	@Autowired
	private ExampleBeanService exampleBeanService;

	@BeforeEach
	public void setUp() {
		final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigScanBean.class);
		exampleBeanService = applicationContext.getBean(ExampleBeanService.class);
		Assertions.assertNotNull(exampleBeanService);
	}

	@AfterEach
	public void tearDown() {
		exampleBeanService = null;

		Assertions.assertNull(exampleBeanService);
	}

	@Test
	public void testSameMethod() {
		final boolean result = exampleBeanService.sampleMethod();
		Assertions.assertFalse(result);
	}
}
