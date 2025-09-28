package org.wrzesien.wzorceProjektowe.creationalPatterns.prototype;

public class Enums {
	private final String type;
	private int health;

	public Enums(final String type, final int health) {
		this.type = type;
		this.health = health;
	}

	public Enums copy() {
		return new Enums(type, health); // proste kopiowanie
	}

	public void show() {
		System.out.println(type + " ma " + health + " HP");
	}

	public void setHp(final int health) {
		this.health = health;
	}
}
