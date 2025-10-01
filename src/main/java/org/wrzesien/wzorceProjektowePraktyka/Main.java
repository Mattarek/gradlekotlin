package org.wrzesien.wzorceProjektowePraktyka;

import org.wrzesien.wzorceProjektowePraktyka.Command.Command;
import org.wrzesien.wzorceProjektowePraktyka.Command.PlaceOrderCommand;
import org.wrzesien.wzorceProjektowePraktyka.Composite.MenuGroup;
import org.wrzesien.wzorceProjektowePraktyka.Composite.MenuItem;
import org.wrzesien.wzorceProjektowePraktyka.Decorator.BasicCoffee;
import org.wrzesien.wzorceProjektowePraktyka.Decorator.Drink;
import org.wrzesien.wzorceProjektowePraktyka.Decorator.MilkDecorator;
import org.wrzesien.wzorceProjektowePraktyka.Proxy.Menu;
import org.wrzesien.wzorceProjektowePraktyka.Proxy.MenuProxy;
import org.wrzesien.wzorceProjektowePraktyka.Strategy.CardPayment;
import org.wrzesien.wzorceProjektowePraktyka.Strategy.PaymentStrategy;
import org.wrzesien.wzorceProjektowePraktyka.TemplateMethod.Beverage;
import org.wrzesien.wzorceProjektowePraktyka.TemplateMethod.Tea;

public class Main {
	public static void main(final String[] args) {
		// Abstract Factory
		final CafeFactory factory = new ItalianCafeFactory();
		final Coffee coffee = factory.createCoffee();
		final Dessert dessert = factory.createDessert();

		// Builder
		final Order order = new Order.Builder()
				.coffee(coffee)
				.dessert(dessert)
				.takeaway(true)
				.build();

		// Strategy
		final PaymentStrategy paymentStrategy = new CardPayment();
		paymentStrategy.pay(15.0);

		// Template Method
		final Beverage tea = new Tea();
		tea.prepare();

		// Command
		final Command placeOrder = new PlaceOrderCommand(order);
		placeOrder.execute();

		// Proxy
		final Menu menu = new MenuProxy(false);
		menu.show();

		// Decorator
		final Drink decoratedCoffee = new MilkDecorator(new BasicCoffee());
		System.out.println(decoratedCoffee.getDescription() + " = " + decoratedCoffee.cost());

		// Composite
		final MenuGroup drinks = new MenuGroup("Drinks");
		drinks.add(new MenuItem("Latte"));
		drinks.add(new MenuItem("Espresso"));
		drinks.show();
	}
}
