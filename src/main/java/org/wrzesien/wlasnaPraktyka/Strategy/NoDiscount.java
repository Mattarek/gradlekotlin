package org.wrzesien.wlasnaPraktyka.Strategy;

public class NoDiscount implements DiscountStrategy {
	@Override
	public double applyDiscount(final double price) {
		return price;
	}
}
