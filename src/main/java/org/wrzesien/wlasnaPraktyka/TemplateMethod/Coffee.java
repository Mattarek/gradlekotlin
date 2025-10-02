package org.wrzesien.wlasnaPraktyka.TemplateMethod;

public class Coffee extends Beverage {
	@Override
	protected void brew() {
		System.out.println("Zaparzam kawe");
	}

	@Override
	protected void addCondiments() {
		System.out.println("Dodaje cytryne");
	}
}
