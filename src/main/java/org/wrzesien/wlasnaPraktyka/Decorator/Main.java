package org.wrzesien.wlasnaPraktyka.Decorator;

public class Main {
	public static void main(final String[] args) {
		final Coffee coffee = new SimpleCoffee();
		System.out.println(coffee.description() + " $" + coffee.cost());

		final Coffee milkCoffee = new MilkDecorator(coffee);
		System.out.println(milkCoffee.description() + " $" + milkCoffee.cost());

		final Coffee milkSugarCoffee = new SugerDecorator(milkCoffee);
		System.out.println(milkSugarCoffee.description() + " $" + milkSugarCoffee.cost());
	}
}
