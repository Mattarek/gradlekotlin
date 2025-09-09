package org.wrzesien.testowanie.pierwszyTest;

import org.w3c.dom.css.Counter;

public class Main {
	static final Calculator counter = new Calculator();

	public static void main(final String[] args) {
		counter.add(1, 3);
		counter.divide(12, 3);
		counter.subtract(10, 3);
		final int subtract = counter.subtract(5, 3);
		counter.multiply(3, 3);
		counter.add(1, 3);
	}
}
