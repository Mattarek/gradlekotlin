package org.wrzesien.wzorceProjektowe.behavioralPatterns.abstractFactory;

import org.wrzesien.$11designPattarns.KreacyjneWPraktyce.AbstractFactory.Button;
import org.wrzesien.$11designPattarns.KreacyjneWPraktyce.AbstractFactory.GUIFactory;
import org.wrzesien.$11designPattarns.KreacyjneWPraktyce.AbstractFactory.WindowsFactory;
import org.wrzesien.wzorceProjektowe.behavioralPatterns.abstractFactory.checkbox.Checkbox;

public class Main {
	public static void main(final String[] args) {
		final GUIFactory guiFactory = new WindowsFactory();
		final Button btn = guiFactory.createButton();
		final Checkbox checkbox = guiFactory.createCheckbox();

		btn.paint();
		checkbox.paint();
	}
}
