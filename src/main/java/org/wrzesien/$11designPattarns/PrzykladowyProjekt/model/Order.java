package org.wrzesien.$11designPattarns.PrzykladowyProjekt.model;

import org.wrzesien.$11designPattarns.PrzykladowyProjekt.util.ValidationUtils;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Order aggregate. Keeps responsibilities limited: items, customer, timestamp and total calculation.
 * Principles:
 * - SRP: Order handles order-specific behaviour only
 * - DRY: uses Product.price for totals rather than duplicating logic
 * - LoD: exposes minimal behaviour to clients
 */
public record Order(String id, Customer customer, List<Product> items, Instant createdAt) {
	public Order(final String id, final Customer customer, final List<Product> items, final Instant createdAt) {
		this.id = ValidationUtils.requireNonEmpty(id, "id");
		this.customer = Objects.requireNonNull(customer, "customer");
		if (items == null || items.isEmpty()) {
			throw new IllegalArgumentException("Items cannot be empty.");
		}
		this.items = Collections.unmodifiableList(items);
		this.createdAt = Instant.now();
	}

	public int totalPriceCents() {
		return items.stream().mapToInt(Product::priceCents).sum();
	}
}
