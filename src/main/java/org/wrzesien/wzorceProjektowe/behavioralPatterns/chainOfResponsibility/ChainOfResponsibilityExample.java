package org.wrzesien.wzorceProjektowe.behavioralPatterns.chainOfResponsibility;

public class ChainOfResponsibilityExample {
	public static void main(final String[] args) {
		final Approver employee = new Employee();
		final Approver manager = new Manager();
		final Approver director = new Director();

		employee.setNext(manager);
		manager.setNext(director);

		// Testujemy różne wydatki
		employee.approve(50);     // obsłuży pracownik
		employee.approve(500);    // obsłuży kierownik
		employee.approve(5000);   // obsłuży dyrektor
		employee.approve(20000);  // brak obsługi w łańcuchu
	}
}
