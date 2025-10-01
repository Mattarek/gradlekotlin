package org.wrzesien.wzorceProjektowe.behavioralPatterns.chainOfResponsibility;

public class Director extends Approver {

	@Override
	public void approve(final int amount) {
		if (amount <= 10000) {
			System.out.println("Dyrektor zatwierdził wydatek: " + amount + " zł");
		} else {
			System.out.println("Wydatek " + amount + " zł wymaga specjalnego zatwierdzenia!");
		}
	}
}
