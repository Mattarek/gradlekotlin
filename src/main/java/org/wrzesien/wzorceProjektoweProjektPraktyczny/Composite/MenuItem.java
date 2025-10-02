package org.wrzesien.wzorceProjektoweProjektPraktyczny.Composite;

public class MenuItem implements MenuComponent {
	private final String name;

	public MenuItem(final String name) {
		this.name = name;
	}

	public void show() {
		System.out.println("Item: " + name);
	}
}
