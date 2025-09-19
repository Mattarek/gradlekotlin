package org.wrzesien.$11designPattarns.DependencyInjeciton;

import org.wrzesien.$11designPattarns.DependencyInjeciton.di.Container;

public class Main {
	public static void main(final String[] args) {
		final Container container = new Container();
		container.controller.createProduct("1", "Latte", 12.5);
		container.controller.createProduct("2", "Espresso", 10.0);
		System.out.println("All products:");
		container.controller.showAllProducts();
	}
}
