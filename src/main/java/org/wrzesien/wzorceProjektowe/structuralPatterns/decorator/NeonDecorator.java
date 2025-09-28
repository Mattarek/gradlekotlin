package org.wrzesien.wzorceProjektowe.structuralPatterns.decorator;

public class NeonDecorator extends CarDecorator {
	public NeonDecorator(final Car car) {
		super(car);
	}

	@Override
	public String create() {
		System.out.println(getClass().getSimpleName() + " before super calling");
		final String created = super.create();
		System.out.println(getClass().getSimpleName() + " after super calling");

		return created + withNeon();
	}

	private String withNeon() {
		return " with " + getClass().getSimpleName();
	}
}
