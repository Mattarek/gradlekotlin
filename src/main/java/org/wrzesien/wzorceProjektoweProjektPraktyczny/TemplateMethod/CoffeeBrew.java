package org.wrzesien.wzorceProjektoweProjektPraktyczny.TemplateMethod;

public class CoffeeBrew extends Beverage {

	protected void brew() {
		System.out.println("Dripping coffee through filter");
	}

	protected void addExtras() {
		System.out.println("Adding sugar & milk");
	}
}
