package org.pazdziernik.JDBC.src.service;

import org.pazdziernik.JDBC.src.dao.AccountDao;
import org.pazdziernik.JDBC.src.dao.TransferDao;
import org.pazdziernik.JDBC.src.model.Account;

import java.math.BigDecimal;
import java.util.List;

public class BankService {
	private final AccountDao accountDao;
	private final TransferDao transferDao;

	public BankService() {
		accountDao = new AccountDao();
		transferDao = new TransferDao();
	}

	public void showAccounts() {
		final List<Account> accounts = accountDao.findAll();
		accounts.forEach(System.out::println);
	}

	public void makeTransfer(final int senderId, final int receiverId, final BigDecimal amount) {
		System.out.println("Executing transfer...");
		final boolean success = transferDao.executeTransfer(senderId, receiverId, amount);

		if (success) {
			System.out.println("✅ Transfer completed successfully!");
		} else {
			System.out.println("❌ Transfer failed!");
		}
	}
}
