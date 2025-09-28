package org.wrzesien.wzorceProjektowe.structuralPatterns.composite;

public class Elephant implements Animal {
	@Override
	public void eat(final Food food) {
		System.out.println("Elephant eating food: " + food);
	}
}
