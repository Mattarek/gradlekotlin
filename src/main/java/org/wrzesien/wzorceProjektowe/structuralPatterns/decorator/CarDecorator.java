package org.wrzesien.wzorceProjektowe.structuralPatterns.decorator;

public abstract class CarDecorator implements Car {
	private final Car car;

	public CarDecorator(final Car car) {
		this.car = car;
	}

	@Override
	public String create() {
		return car.create();
	}
}
