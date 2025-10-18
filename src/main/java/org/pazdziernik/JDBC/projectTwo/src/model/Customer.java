package org.pazdziernik.JDBC.projectTwo.src.model;

import java.time.LocalDateTime;

public class Customer {
	private Integer id;
	private String name;
	private String email;
	private LocalDateTime createdAt;

	public Customer() {
	}

	public Customer(final String name, final String email) {
		this.name = name;
		this.email = email;
	}

	public Customer(final Integer id, final String name, final String email, final LocalDateTime createdAt) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", createdAt=" + createdAt +
				'}';
	}
}
