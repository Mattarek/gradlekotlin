package org.wrzesien.wzorceProjektowePraktyka;

public class ItalianCafeFactory implements CafeFactory {
	@Override
	public Coffee createCoffee() {
		return () -> "Espresso";
	}

	@Override
	public Dessert createDessert() {
		return () -> "Tiramisu";
	}

	@Override
	public String toString() {
		return "ItalianCafeFactory{}";
	}
}
