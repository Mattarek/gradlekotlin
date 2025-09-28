package org.wrzesien.wzorceProjektowe.structuralPatterns.bridge;

public class Square extends Shape {
	public Square(final Color color) {
		super(color);
	}

	@Override
	public void applyColor() {
		System.out.println("Square with color: " + color.apply());
	}

	@Override
	public String toString() {
		return "Square{" +
				"color=" + color +
				"} " + super.toString();
	}
}
