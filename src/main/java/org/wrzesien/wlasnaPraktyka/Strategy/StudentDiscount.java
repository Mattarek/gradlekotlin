package org.wrzesien.wlasnaPraktyka.Strategy;

public class StudentDiscount implements DiscountStrategy {
	@Override
	public double applyDiscount(final double price) {
		return price * 0.5;
	}
}
