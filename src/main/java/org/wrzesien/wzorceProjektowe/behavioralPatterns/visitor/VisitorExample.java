package org.wrzesien.wzorceProjektowe.behavioralPatterns.visitor;

public class VisitorExample {
	public static void main(final String[] args) {
		final Item[] items = {
				new Book("Java Podstawy", 50),
				new Fruit("Jabłko", 3),
				new Fruit("Banan", 4)
		};

		final Visitor priceVisitor = new PriceVisitor();

		for (final Item item : items) {
			item.accept(priceVisitor);
		}
	}
}
