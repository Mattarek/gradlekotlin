package org.wrzesien.wzorceProjektowe.structuralPatterns.composite;

public class Main {
	public static void main(final String[] args) {
		final ZOO zoo = new ZOO();
		zoo.add(new Monkey());
		zoo.add(new Elephant());
		zoo.add(new Tiger());
		zoo.add(new Elephant());
		zoo.add(new Monkey());
		zoo.add(new Tiger());
		zoo.add(new Tiger());
		zoo.add(new Monkey());
		zoo.add(new Monkey());
	}
}
