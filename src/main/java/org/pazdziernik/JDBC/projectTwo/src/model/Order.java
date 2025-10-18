package org.pazdziernik.JDBC.projectTwo.src.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
	private Integer id;
	private Integer customerId;
	private BigDecimal total;
	private LocalDateTime createdAt;

	public Order() {
	}

	public Order(final Integer id, final Integer customerId, final BigDecimal total) {
		this.id = id;
		this.customerId = customerId;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(final Integer customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(final BigDecimal total) {
		this.total = total;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", customerId=" + customerId +
				", total=" + total +
				", createdAt=" + createdAt +
				'}';
	}
}
