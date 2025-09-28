package org.wrzesien.wzorceProjektowe.creationalPatterns.abstractFactory.factory;

import org.wrzesien.wzorceProjektowe.creationalPatterns.abstractFactory.button.Button;
import org.wrzesien.wzorceProjektowe.creationalPatterns.abstractFactory.checkbox.Checkbox;

interface GUIFactory {
	Button createButton();

	Checkbox createCheckbox();
}
