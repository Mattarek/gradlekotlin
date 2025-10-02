package org.wrzesien.wlasnaPraktyka.Proxy;

public class Main {
	public static void main(final String[] args) {
		final Image imageOne = new ProxyImage("photo1.jpg");
		final Image imageTwo = new ProxyImage("photo2.jpg");

		imageOne.display();
		imageTwo.display();

		imageTwo.display();
	}
}
