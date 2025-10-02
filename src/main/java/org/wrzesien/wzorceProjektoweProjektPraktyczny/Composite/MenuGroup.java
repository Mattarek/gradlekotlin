package org.wrzesien.wzorceProjektoweProjektPraktyczny.Composite;

import java.util.ArrayList;
import java.util.List;

public class MenuGroup {
	private final String name;
	private final List<MenuComponent> items = new ArrayList<>();

	public MenuGroup(final String name) {
		this.name = name;
	}

	public void add(final MenuComponent item) {
		items.add(item);
	}

	public void show() {
		System.out.println("Category: " + name);
		for (final MenuComponent item : items) {
			item.show();
		}
	}
}
