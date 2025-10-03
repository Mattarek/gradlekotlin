package org.wrzesien.wlasnaPraktyka.Decorator;

public abstract class CoffeeDecorator implements Coffee {
	protected Coffee decoratedCoffee;

	public CoffeeDecorator(final Coffee coffee) {
		decoratedCoffee = coffee;
	}

	public double cost() {
		return decoratedCoffee.cost();
	}

	public String description() {
		return decoratedCoffee.description();
	}
}
