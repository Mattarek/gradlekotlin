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

	// dodatkowy konstruktor, np. do tworzenia "teraz"
	public Order(final String id, final Customer customer, final List<Product> items) {
		this(id, customer, items, Instant.now());
	}

	public Order {
		id = ValidationUtils.requireNonEmpty(id, "id");
		customer = Objects.requireNonNull(customer, "customer");
		if (items == null || items.isEmpty()) {
			throw new IllegalArgumentException("items cannot be empty");
		}
		items = Collections.unmodifiableList(items);
	}

	public int totalPriceCents() {
		return items.stream().mapToInt(Product::priceCents).sum();
	}
}
