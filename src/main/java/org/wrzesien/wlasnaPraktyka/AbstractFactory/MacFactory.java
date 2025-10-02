package org.wrzesien.wlasnaPraktyka.AbstractFactory;

public class MacFactory implements GUIFactory {
	public Button createButton() {
		return new WindowsButton();
	}

	public TextField createTextField() {
		return new MacTextField();
	}
}
