package org.wrzesien.wzorceProjektowe.creationalPatterns.builder;

public class Meal {
	private String burger;
	private String drink;

	public void setBurger(final String burger) {
		this.burger = burger;
	}

	public void setDrink(final String drink) {
		this.drink = drink;
	}

	public void showMeal() {
		System.out.println("Burger: " + burger + ", Drink: " + drink);
	}
}
