package org.wrzesien.wzorceProjektowePraktyka.Strategy;

public class CardPayment implements PaymentStrategy {
	public void pay(final double amount) {
		System.out.println("Paid " + amount + " by Card.");
	}
}
