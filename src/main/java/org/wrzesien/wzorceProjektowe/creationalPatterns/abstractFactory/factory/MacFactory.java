package org.wrzesien.wzorceProjektowe.creationalPatterns.abstractFactory.factory;

import org.wrzesien.wzorceProjektowe.creationalPatterns.abstractFactory.button.Button;
import org.wrzesien.wzorceProjektowe.creationalPatterns.abstractFactory.button.MacButton;
import org.wrzesien.wzorceProjektowe.creationalPatterns.abstractFactory.checkbox.Checkbox;
import org.wrzesien.wzorceProjektowe.creationalPatterns.abstractFactory.checkbox.MacCheckbox;

public class MacFactory implements GUIFactory {
	public Button createButton() {
		return new MacButton();
	}

	public Checkbox createCheckbox() {
		return new MacCheckbox();
	}
}
