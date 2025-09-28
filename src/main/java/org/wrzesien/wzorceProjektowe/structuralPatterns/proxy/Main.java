package org.wrzesien.wzorceProjektowe.structuralPatterns.proxy;

public class Main {
	public static void main(final String[] args) {
		final PizzaBaker executor = new PizzaBakerProxy(new PizzaBakerImpl());
		executor.bake("Peperoni");
		executor.bake("Margaritta");
		executor.bake("Hawaiian");
	}
}
