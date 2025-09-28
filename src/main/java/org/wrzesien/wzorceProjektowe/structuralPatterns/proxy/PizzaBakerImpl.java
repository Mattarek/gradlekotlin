package org.wrzesien.wzorceProjektowe.structuralPatterns.proxy;

public class PizzaBakerImpl implements PizzaBaker {

	@Override
	public void bake(final String pizza) {
		System.out.println("Pizza baking");
	}
}
