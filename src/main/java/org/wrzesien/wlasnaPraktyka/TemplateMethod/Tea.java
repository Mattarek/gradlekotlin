package org.wrzesien.wlasnaPraktyka.TemplateMethod;

public class Tea extends Beverage {
	@Override
	protected void brew() {
		System.out.println("Zaparzam herbatę");
	}

	@Override
	protected void addCondiments() {
		System.out.println("Dodaje cytrynę");
	}
}
