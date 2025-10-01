package org.wrzesien.wzorceProjektowePraktyka;

public class AmericanCafeFactory implements CafeFactory {
	public Coffee createCoffee() {
		return () -> "Drip Coffee";
	}

	public Dessert createDessert() {
		return () -> "Cheesecake";
	}
}
