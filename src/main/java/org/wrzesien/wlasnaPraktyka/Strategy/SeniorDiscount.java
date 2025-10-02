package org.wrzesien.wlasnaPraktyka.Strategy;

public class SeniorDiscount implements DiscountStrategy {
	@Override
	public double applyDiscount(final double price) {
		return price * 0.7;
	}
}
