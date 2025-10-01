package org.wrzesien.wzorceProjektowe.behavioralPatterns.chainOfResponsibility;

public class Employee extends Approver {
	@Override
	public void approve(final int amount) {
		if (amount <= 100) {
			System.out.println("Pracownik zatwierdził wydatek: " + amount + " zł.");
		} else if (next != null) {
			next.approve(amount);
		}
	}
}
