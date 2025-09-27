package org.wrzesien.$15mockowanie.$2mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExampleTest {

	@InjectMocks
	private SomeClass someClass;

	@Mock
	private SomeOtherClass someOtherClass;

	@Test
	void nameTest() {
		Mockito.when(someOtherClass.someOtherMethod()).thenReturn("Great");
		someClass.someMethod();
	}
}
