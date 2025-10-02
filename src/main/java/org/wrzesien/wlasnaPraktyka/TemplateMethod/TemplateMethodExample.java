package org.wrzesien.wlasnaPraktyka.TemplateMethod;

public class TemplateMethodExample {
	public static void main(final String[] args) {
		System.out.println("Przygotowuje kawę: ");
		final Beverage coffee = new Coffee();
		coffee.prepareRecipe();

		System.out.println("Przygotowuję herbatę: ");
		final Beverage tea = new Tea();
		tea.prepareRecipe();
	}
}
