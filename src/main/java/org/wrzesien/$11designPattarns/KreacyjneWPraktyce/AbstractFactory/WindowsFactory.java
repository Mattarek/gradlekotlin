package org.wrzesien.$11designPattarns.KreacyjneWPraktyce.AbstractFactory;

public class WindowsFactory implements GUIFactory {
	public Button createButton() {
		return new WindowsButton();
	}
}
