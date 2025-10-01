package org.wrzesien.wzorceProjektowePraktyka.Proxy;

public class MenuProxy implements Menu {
	private final boolean isManager;
	private RealMenu realMenu;

	public MenuProxy(final boolean isManager) {
		this.isManager = isManager;
	}

	public void show() {
		if (isManager) {
			if (realMenu == null) {
				realMenu = new RealMenu();
			}
			realMenu.show();
		} else {
			System.out.println("Access denied. Limited menu available.");
		}
	}
}
