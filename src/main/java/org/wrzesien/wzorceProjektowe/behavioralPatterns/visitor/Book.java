package org.wrzesien.wzorceProjektowe.behavioralPatterns.visitor;

public record Book(String name, double price) implements Item {

	@Override
	public void accept(final Visitor visitor) {
		visitor.visit(this);
	}
}
