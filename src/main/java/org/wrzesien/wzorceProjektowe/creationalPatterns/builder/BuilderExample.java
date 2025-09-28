package org.wrzesien.wzorceProjektowe.creationalPatterns.builder;

public class BuilderExample {
	public static void main(final String[] args) {
		final Meal meal = new MealBuilder()
				.addBurger("Cheese burger")
				.addDrink("Coke")
				.build();

		meal.showMeal();
	}
}
