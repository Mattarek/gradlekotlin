package org.wrzesien.$15mockowanie.$1przypomnenie.model;

public class Order {
	private final String id;
	private final double amount;
	private boolean paid;

	public Order(final String id, final double amount, final boolean paid) {
		this.id = id;
		this.amount = amount;
		this.paid = paid;
	}

	public String getId() {
		return id;
	}

	public boolean isPaid() {
		return paid;
	}

	public double getAmount() {
		return amount;
	}

	public void markPaid() {
		paid = true;
	}
}
