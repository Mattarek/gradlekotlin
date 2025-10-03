package org.wrzesien.wlasnaPraktyka.Decorator;

public class MilkDecorator extends CoffeeDecorator {
	public MilkDecorator(final Coffee coffee) {
		super(coffee);
	}

	@Override
	public double cost() {
		return super.cost() + 2.0;
	}

	@Override
	public String description() {
		return super.description() + ", Milk";
	}
}
