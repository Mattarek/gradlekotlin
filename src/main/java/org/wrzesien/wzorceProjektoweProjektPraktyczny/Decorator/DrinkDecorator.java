package org.wrzesien.wzorceProjektoweProjektPraktyczny.Decorator;

public abstract class DrinkDecorator implements Drink {
	protected final Drink drink;

	public DrinkDecorator(final Drink drink) {
		this.drink = drink;
	}
}
