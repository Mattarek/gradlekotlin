package org.wrzesien.wzorceProjektowePraktyka.Decorator;

public class MilkDecorator extends DrinkDecorator {
	public MilkDecorator(final Drink drink) {
		super(drink);
	}

	public String getDescription() {
		return drink.getDescription() + ", Milk";
	}

	public double cost() {
		return drink.cost() + 1.5;
	}
}
