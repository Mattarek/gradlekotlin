package org.wrzesien.wzorceProjektowe.structuralPatterns.composite;

public class Tiger implements Animal {

	@Override
	public void eat(final Food food) {
		System.out.println("Tiger eating food: " + food);
	}
}
