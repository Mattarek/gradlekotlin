package org.wrzesien.wlasnaPraktyka.AbstractFactory;

public class Main {
	public static void main(final String[] args) {
		GUIFactory factory;

		// Tworzymy GUI w stylu Windows
		factory = new WindowsFactory();
		final Button winButton = factory.createButton();
		final TextField winText = factory.createTextField();
		winButton.paint();
		winText.render();

		// Tworzymy GUI w stylu MacOS
		factory = new MacFactory();
		final Button macButton = factory.createButton();
		final TextField macText = factory.createTextField();
		macButton.paint();
		macText.render();
	}
}
