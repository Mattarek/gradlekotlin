package org.wrzesien.wzorceProjektowe.creationalPatterns.abstractFactory.factory;

import org.wrzesien.wzorceProjektowe.creationalPatterns.abstractFactory.button.Button;
import org.wrzesien.wzorceProjektowe.creationalPatterns.abstractFactory.button.WindowsButton;
import org.wrzesien.wzorceProjektowe.creationalPatterns.abstractFactory.checkbox.Checkbox;
import org.wrzesien.wzorceProjektowe.creationalPatterns.abstractFactory.checkbox.WindowsCheckbox;

class WindowsFactory implements GUIFactory {
	public Button createButton() {
		return new WindowsButton();
	}

	public Checkbox createCheckbox() {
		return new WindowsCheckbox();
	}
}