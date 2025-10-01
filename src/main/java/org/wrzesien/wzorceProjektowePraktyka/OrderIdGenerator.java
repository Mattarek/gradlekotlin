package org.wrzesien.wzorceProjektowePraktyka;

// Singleton
public class OrderIdGenerator {
	private static final OrderIdGenerator INSTANCE = new OrderIdGenerator();
	private long counter;

	private OrderIdGenerator() {
	}

	public static OrderIdGenerator getInstance() {
		return INSTANCE;
	}

	public synchronized String nextId() {
		return "ORD-" + ++counter;
	}
}
