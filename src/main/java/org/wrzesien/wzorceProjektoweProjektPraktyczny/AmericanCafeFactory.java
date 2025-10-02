package org.wrzesien.wzorceProjektoweProjektPraktyczny;

public class AmericanCafeFactory implements CafeFactory {
	public Coffee createCoffee() {
		return () -> "Drip Coffee";
	}

	public Dessert createDessert() {
		return () -> "Cheesecake";
	}
}
