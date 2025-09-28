package org.wrzesien.wzorceProjektowe.structuralPatterns.bridge;

public abstract class Shape {
	protected Color color;

	public Shape(final Color color) {
		this.color = color;
	}

	public abstract void applyColor();

	@Override
	public String toString() {
		return "Shape{" +
				"color=" + color +
				'}';
	}
}
