package org.wrzesien.wlasnaPraktyka.Decorator;

public class SugerDecorator extends CoffeeDecorator {
	public SugerDecorator(final Coffee coffee) {
		super(coffee);
	}

	@Override
	public double cost() {
		return super.cost() + 1.0;
	}

	@Override
	public String description() {
		return super.description() + ", Sugar";
	}
}
