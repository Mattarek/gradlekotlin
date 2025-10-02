package org.wrzesien.wlasnaPraktyka.Strategy;

public class Ticket {
	private DiscountStrategy discountStrategy;

	public Ticket(final DiscountStrategy discountStrategy) {
		this.discountStrategy = discountStrategy;
	}

	public void setDiscountStrategy(final DiscountStrategy discountStrategy) {
		this.discountStrategy = discountStrategy;
	}

	public double getFinalPrice(final double basePrice) {
		return discountStrategy.applyDiscount(basePrice);
	}
}
