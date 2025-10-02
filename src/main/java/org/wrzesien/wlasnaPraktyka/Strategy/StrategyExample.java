package org.wrzesien.wlasnaPraktyka.Strategy;

public class StrategyExample {
	public static void main(final String[] args) {
		final double basePrice = 100.00;
		final Ticket ticket = new Ticket(new NoDiscount());
		System.out.println("Cena normalna: " + ticket.getFinalPrice(basePrice));

		ticket.setDiscountStrategy(new StudentDiscount());
		System.out.println("Cena dla studenta: " + ticket.getFinalPrice(basePrice));

		ticket.setDiscountStrategy(new SeniorDiscount());
		System.out.println("Cena dla seniora: " + ticket.getFinalPrice(basePrice));
	}
}
