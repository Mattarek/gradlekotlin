package org.praktyka.selfEEnvolving;

public class Auto extends Vehicle {
	private final Engine engine;

	public Auto(final int wheels, final Engine engine) {
		super(wheels);
		this.engine = engine;
	}
}
