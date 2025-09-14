package org.wrzesien.$12wersjeJavy.$3java8;

@FunctionalInterface
public interface Swim {
	static void someMethod() {
		System.out.println("Calling static method");
	}

	String someMethodToImplementLmabda();

	default String canSwim() {
		return "No, I can't!";
	}
}
