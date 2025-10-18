package org.pazdziernik.JDBC.projectOne.src.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transfer {
	private final int id;
	private final int senderId;
	private final int receiverId;
	private final BigDecimal amount;
	private final LocalDateTime transferDate;

	public Transfer(final int id, final int senderId, final int receiverId, final BigDecimal amount, final LocalDateTime transferDate) {
		this.id = id;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.amount = amount;
		this.transferDate = transferDate;
	}

	@Override
	public String toString() {
		return "Transfer{" +
				"id=" + id +
				", senderId=" + senderId +
				", receiverId=" + receiverId +
				", amount=" + amount +
				", transferDate=" + transferDate +
				'}';
	}
}
