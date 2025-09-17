package org.wrzesien.$11designPattarns.PrzykladowyProjekt.model;

import org.wrzesien.$11designPattarns.PrzykladowyProjekt.util.ValidationUtils;

/**
 * Customer model with only necessary fields.
 * Principles:
 * - SRP: only holds customer data
 * - YAGNI: no loyalty system or addresses beyond email (kept minimal)
 */
public record Customer(String id, String email) {
	public Customer(final String id, final String email) {
		this.id = ValidationUtils.requireNonEmpty(id, "id");
		this.email = ValidationUtils.requireNonEmpty(email, "email");
		if (!email.contains("@")) {
			throw new IllegalArgumentException("Invalid email");
		}
	}
}
