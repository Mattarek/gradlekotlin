package org.wrzesien.wzorceProjektowe.behavioralPatterns.abstractFactory.factory;

import org.wrzesien.wzorceProjektowe.behavioralPatterns.abstractFactory.button.Button;
import org.wrzesien.wzorceProjektowe.behavioralPatterns.abstractFactory.checkbox.Checkbox;

interface GUIFactory {
	Button createButton();

	Checkbox createCheckbox();
}
