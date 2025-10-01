package org.wrzesien.wzorceProjektowePraktyka.Decorator;

public class BasicCoffee implements Drink {

	public String getDescription() {
		return "Coffee";
	}

	public double cost() {
		return 5.0;
	}
}
