package org.wrzesien.wzorceProjektowe.structuralPatterns.proxy;

import java.util.List;

public class PizzaBakerProxy implements PizzaBaker {
	private static final List<String> DENIED_PIZZAS = List.of("Hawaiian");
	private final PizzaBaker pizzaBaker;

	public PizzaBakerProxy(final PizzaBaker pizzaBaker) {
		this.pizzaBaker = pizzaBaker;
	}

	@Override
	public void bake(final String pizza) {
		if (DENIED_PIZZAS.contains(pizza)) {
			throw new RuntimeException("%s? We don't do this here: " + pizza);
		}
		pizzaBaker.bake(pizza);
	}
}
