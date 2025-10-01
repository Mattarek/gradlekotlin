package org.wrzesien.wzorceProjektowePraktyka.TemplateMethod;

public class Tea extends Beverage {
	protected void brew() {
		System.out.println("Steeping the tea bag");
	}

	protected void addExtras() {
		System.out.println("Adding lemon");
	}
}
