package org.wrzesien.wzorceProjektowe.structuralPatterns.bridge;

public class Main {
	public static void main(final String[] args) {
		final Shape shapeOne = new Square(new Green());

		System.out.println(shapeOne);
		final Shape shapeTwo = new Triangle(new Red());
		System.out.println(shapeTwo);
	}
}
