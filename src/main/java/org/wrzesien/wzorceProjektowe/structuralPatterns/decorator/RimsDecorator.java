package org.wrzesien.wzorceProjektowe.structuralPatterns.decorator;

public class RimsDecorator extends CarDecorator {
	public RimsDecorator(final Car car) {
		super(car);
	}

	@Override
	public String create() {
		return super.create() + withRims();
	}

	private String withRims() {
		return " with " + getClass().getSimpleName();
	}
}
