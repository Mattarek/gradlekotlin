package org.wrzesien.wzorceProjektoweProjektPraktyczny.TemplateMethod;

public class Tea extends Beverage {
	protected void brew() {
		System.out.println("Steeping the tea bag");
	}

	protected void addExtras() {
		System.out.println("Adding lemon");
	}
}
