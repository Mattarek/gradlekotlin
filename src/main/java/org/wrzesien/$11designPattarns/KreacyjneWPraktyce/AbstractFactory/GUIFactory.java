package org.wrzesien.$11designPattarns.KreacyjneWPraktyce.AbstractFactory;

import org.wrzesien.wzorceProjektowe.creationalPatterns.abstractFactory.checkbox.Checkbox;

public interface GUIFactory {
	Button createButton();

	Checkbox createCheckbox();
}
