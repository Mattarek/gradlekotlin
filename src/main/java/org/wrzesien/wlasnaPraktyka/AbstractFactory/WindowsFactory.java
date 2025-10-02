package org.wrzesien.wlasnaPraktyka.AbstractFactory;

public class WindowsFactory implements GUIFactory {
	public Button createButton() {
		return new WindowsButton();
	}

	public TextField createTextField() {
		return new WindowsTextField();
	}
}
