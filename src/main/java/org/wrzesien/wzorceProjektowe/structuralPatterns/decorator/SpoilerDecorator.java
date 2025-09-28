package org.wrzesien.wzorceProjektowe.structuralPatterns.decorator;

public class SpoilerDecorator extends CarDecorator {
	public SpoilerDecorator(final Car car) {
		super(car);
	}

	@Override
	public String create() {
		return super.create() + withSpoiler();
	}

	private String withSpoiler() {
		return " with " + getClass().getSimpleName();
	}
}

