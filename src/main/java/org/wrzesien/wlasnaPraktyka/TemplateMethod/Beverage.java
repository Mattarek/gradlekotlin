package org.wrzesien.wlasnaPraktyka.TemplateMethod;

public abstract class Beverage {
	public final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	private void boilWater() {
		System.out.println("Gotuje wodę");
	}

	private void pourInCup() {
		System.out.println("Wlewam do kubka");
	}

	protected abstract void brew();

	protected abstract void addCondiments();
}
