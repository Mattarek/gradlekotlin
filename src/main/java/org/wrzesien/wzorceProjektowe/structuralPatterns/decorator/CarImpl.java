package org.wrzesien.wzorceProjektowe.structuralPatterns.decorator;

public class CarImpl implements Car {
	public CarImpl() {
		System.out.println("Calling Car constructor");
	}

	@Override
	public String create() {
		return "Car";
	}
}
