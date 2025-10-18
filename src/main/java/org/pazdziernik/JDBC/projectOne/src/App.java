package org.pazdziernik.JDBC.projectOne.src;

import org.pazdziernik.JDBC.projectOne.src.service.BankService;

import java.math.BigDecimal;

public class App {
	public static void main(final String[] args) {
		final BankService bankService = new BankService();

		System.out.println("=== Initial Accounts ===");
		bankService.showAccounts();

		bankService.makeTransfer(1, 2, new BigDecimal("150.00"));
		System.out.println("\n=== After Transfer ===");
		bankService.showAccounts();
	}
}
