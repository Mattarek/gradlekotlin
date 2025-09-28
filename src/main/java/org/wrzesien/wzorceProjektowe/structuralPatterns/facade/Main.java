package org.wrzesien.wzorceProjektowe.structuralPatterns.facade;

import org.wrzesien.wzorceProjektowe.structuralPatterns.facade.Car.CarFactoryFacade;

public class Main {
	public static void main(final String[] args) {
		// Facade
		final CarFactoryFacade carFactoryFacade = new CarFactoryFacade();
		carFactoryFacade.produceCar();
	}
}
