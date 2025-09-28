package org.wrzesien.wzorceProjektowe.structuralPatterns.decorator;

import javax.management.Attribute;

public class Main {
	public static void main(final String[] args) {
		// Decorator
		final CarImpl carNotDecorated = new CarImpl();
		System.out.println(carNotDecorated.create());

		final Car carOne = new SpoilerDecorator(new CarImpl());
		System.out.println(carOne.create());

		final Car carTwo = new RimsDecorator(
				new SpoilerDecorator(
						new NeonDecorator(
								new CarImpl()
						)
				)
		);

		System.out.println(carTwo.create());

		// Decorator Attribute
		final Attribute attributeOne = new AttributeBeforeDecorator(new Attribute("key", "value"));
		System.out.println(attributeOne.getName());
	}
}
