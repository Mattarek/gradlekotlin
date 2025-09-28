package org.wrzesien.wzorceProjektowe.structuralPatterns.composite;

public class Monkey implements Animal {
	@Override
	public void eat(final Food food) {
		System.out.println("Monkey eating food: " + food);
	}
}
