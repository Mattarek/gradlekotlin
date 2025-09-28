package org.wrzesien.wzorceProjektowe.structuralPatterns.bridge;

public class Triangle extends Square {

	public Triangle(final Color color) {
		super(color);
	}

	@Override
	public void applyColor() {
		System.out.println("Triangle with color: " + color.apply());
	}

	@Override
	public String toString() {
		return "Triangle{" +
				"color=" + color +
				"} " + super.toString();
	}
}
