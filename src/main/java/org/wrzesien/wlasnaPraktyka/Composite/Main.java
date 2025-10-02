package org.wrzesien.wlasnaPraktyka.Composite;

public class Main {
	public static void main(final String[] args) {
		final Circle c1 = new Circle();
		final Circle c2 = new Circle();

		final GraphicGroup group = new GraphicGroup();

		group.add(c1);
		group.add(c2);

		group.draw();
	}
}
