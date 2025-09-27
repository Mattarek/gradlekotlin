package org.wrzesien.wzorceProjektowe.behavioralPatterns.abstractFactory.factory;

import org.wrzesien.wzorceProjektowe.behavioralPatterns.abstractFactory.button.Button;
import org.wrzesien.wzorceProjektowe.behavioralPatterns.abstractFactory.button.MacButton;
import org.wrzesien.wzorceProjektowe.behavioralPatterns.abstractFactory.checkbox.Checkbox;
import org.wrzesien.wzorceProjektowe.behavioralPatterns.abstractFactory.checkbox.MacCheckbox;

public class MacFactory implements GUIFactory {
	public Button createButton() {
		return new MacButton();
	}

	public Checkbox createCheckbox() {
		return new MacCheckbox();
	}
}
