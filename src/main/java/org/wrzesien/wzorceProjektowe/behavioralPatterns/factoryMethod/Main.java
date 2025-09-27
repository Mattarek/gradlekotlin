package org.wrzesien.wzorceProjektowe.behavioralPatterns.factoryMethod;

public class Main {
	public static void main(final String[] args) {
		final Account acc1 = AccountFactory.createAccount(AccountType.CHECKING);
		final Account acc2 = AccountFactory.createAccount(AccountType.SAVINGS);
	}
}
