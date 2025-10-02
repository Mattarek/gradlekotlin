package org.wrzesien.wlasnaPraktyka.Builder;

public class Main {
	public static void main(final String[] args) {
		final Car carOne = new Car.Builder("Toyota", "Corolla")
				.color("red")
				.sunroof(true)
				.gps(true)
				.build();

		final Car carTwo = new Car.Builder("Honda", "Civic")
				.doors(2)
				.build();

		System.out.println(carOne);
		System.out.println(carTwo);
	}
}
