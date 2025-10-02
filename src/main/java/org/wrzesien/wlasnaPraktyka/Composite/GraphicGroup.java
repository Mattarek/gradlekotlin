package org.wrzesien.wlasnaPraktyka.Composite;

import java.util.ArrayList;
import java.util.List;

public class GraphicGroup implements Graphic {
	private final List<Graphic> children = new ArrayList<>();

	public void add(final Graphic g) {
		children.add(g);
	}

	public void remove(final Graphic g) {
		children.remove(g);
	}

	@Override
	public void draw() {
		for (final Graphic g : children) {
			g.draw();
		}
	}
}
