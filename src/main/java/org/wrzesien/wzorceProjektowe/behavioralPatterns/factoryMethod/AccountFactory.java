package org.wrzesien.wzorceProjektowe.behavioralPatterns.factoryMethod;

public class AccountFactory {
	public static Account createAccount(final AccountType type) {
		return switch (type) {
			case SAVINGS -> new SavingsAccount();
			case CHECKING -> new CheckingAccount();
			default -> throw new IllegalArgumentException("Nieznany typ konta");
		};
	}
}
