package org.pazdziernik.JDBC.projectOne.src.model;

import java.math.BigDecimal;

public record Account(int id, String ownerName, BigDecimal balance) {
	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", ownerName='" + ownerName + '\'' +
				", balance=" + balance +
				'}';
	}
}
