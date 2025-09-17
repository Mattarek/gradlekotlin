package org.wrzesien.$11designPattarns.PrzykladowyProjekt.model;

import org.wrzesien.$11designPattarns.PrzykladowyProjekt.util.ValidationUtils;

/**
 * Simple immutable model class.
 * Principles:
 * - KISS: minimal fields, no behaviour beyond data
 * - YAGNI: no extra metadata (no promo codes, supplier details, etc.)
 * - Fail Fast: constructor validates arguments
 */
public record Product(String id, String name, int priceCents) {

	public Product(final String id, final String name, final int priceCents) {
		this.id = ValidationUtils.requireNonEmpty(id, "id");
		this.name = ValidationUtils.requireNonEmpty(name, "name");
		if (priceCents < 0) {
			throw new IllegalArgumentException("priceCents must be >= 0");
		}
		this.priceCents = priceCents; // price in cents to avoid floating issues
	}
}
