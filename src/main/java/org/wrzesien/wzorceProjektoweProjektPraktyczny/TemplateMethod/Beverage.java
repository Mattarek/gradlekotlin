package org.wrzesien.wzorceProjektoweProjektPraktyczny.TemplateMethod;

public abstract class Beverage {
	public final void prepare() {
		boilWater();
		brew();
		pour();
		addExtras();
	}

	protected void boilWater() {
		System.out.println("Boiling water...");
	}

	protected abstract void brew();

	protected void pour() {
		System.out.println("Pouring into cup");
	}

	protected void addExtras() {
	}
}
