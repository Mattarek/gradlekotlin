package org.wrzesien.wzorceProjektowe.behavioralPatterns.visitor;

public class PriceVisitor implements Visitor {

	@Override
	public void visit(final Book book) {
		System.out.println("Książka: " + book.name() + " kosztuje " + book.price() + " zł");
	}

	@Override
	public void visit(final Fruit fruit) {
		System.out.println("Owoc: " + fruit.name() + " kosztuje " + fruit.price() + " zł");
	}
}
