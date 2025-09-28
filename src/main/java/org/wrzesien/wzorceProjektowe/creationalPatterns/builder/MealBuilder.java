package org.wrzesien.wzorceProjektowe.creationalPatterns.builder;

public class MealBuilder {
	private final Meal meal = new Meal();

	public MealBuilder addBurger(final String burger) {
		meal.setBurger(burger);
		return this;
	}

	public MealBuilder addDrink(final String drink) {
		meal.setDrink(drink);
		return this;
	}

	public Meal build() {
		return meal;
	}
}
