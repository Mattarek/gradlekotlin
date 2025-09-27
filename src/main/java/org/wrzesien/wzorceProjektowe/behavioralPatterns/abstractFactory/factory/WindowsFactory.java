package org.wrzesien.wzorceProjektowe.behavioralPatterns.abstractFactory.factory;

import org.wrzesien.wzorceProjektowe.behavioralPatterns.abstractFactory.button.Button;
import org.wrzesien.wzorceProjektowe.behavioralPatterns.abstractFactory.button.WindowsButton;
import org.wrzesien.wzorceProjektowe.behavioralPatterns.abstractFactory.checkbox.Checkbox;
import org.wrzesien.wzorceProjektowe.behavioralPatterns.abstractFactory.checkbox.WindowsCheckbox;

class WindowsFactory implements GUIFactory {
	public Button createButton() {
		return new WindowsButton();
	}

	public Checkbox createCheckbox() {
		return new WindowsCheckbox();
	}
}