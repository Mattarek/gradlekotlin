package org.wrzesien.$11designPattarns.PrzykladowyProjekt.repository;

import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Simple in-memory implementation used for the demo.
 * Principles:
 * - KISS: straightforward map-backed store
 * - YAGNI: no DB, no complex queries
 */
public class InMemoryProductRepository implements ProductRepository {
	private final Map<String, Product> storage = new HashMap<>();

	public InMemoryProductRepository(final List<Product> seed) {
		for (final Product p : seed) {
			storage.put(p.id(), p);
		}
	}

	@Override
	public Optional<Product> findById(final String id) {
		return Optional.ofNullable(storage.get(id));
	}

	@Override
	public List<Product> findAll() {
		return new ArrayList<>(storage.values());
	}
}
