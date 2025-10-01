package org.wrzesien.wzorceProjektowe.behavioralPatterns.chainOfResponsibility;

public class Manager extends Approver {

	@Override
	public void approve(final int amount) {
		if (amount <= 1000) {
			System.out.println("Kierownik zatwierdził wydatek: " + amount + " zł");
		} else if (next != null) {
			next.approve(amount);
		}
	}
}
