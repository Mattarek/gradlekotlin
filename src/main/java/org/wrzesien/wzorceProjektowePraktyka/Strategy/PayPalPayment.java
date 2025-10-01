package org.wrzesien.wzorceProjektowePraktyka.Strategy;

public class PayPalPayment implements PaymentStrategy {
	public void pay(final double amount) {
		System.out.println("Paid " + amount + " via PayPal");
	}
}
