package org.wrzesien.wzorceProjektowe.behavioralPatterns.visitor;

public record Fruit(String name, double price) implements Item {

	@Override
	public void accept(final Visitor visitor) {
		visitor.visit(this);
	}
}
