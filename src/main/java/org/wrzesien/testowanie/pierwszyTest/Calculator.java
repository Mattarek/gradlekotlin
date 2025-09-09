package org.wrzesien.testowanie.pierwszyTest;

public class Calculator {
	public Calculator() {
		
	}

	public int add(final int left, final int right) {
		System.out.println("Add");
		return left + right;
	}

	public int subtract(final int left, final int right) {
		System.out.println("Subtract");
		return left - right;
	}

	public int multiply(final int left, final int right) {
		System.out.println("Multiply");
		return left * right;
	}

	public int divide(final int left, final int right) {
		System.out.println("Divide");
		return left / right;
	}
}
