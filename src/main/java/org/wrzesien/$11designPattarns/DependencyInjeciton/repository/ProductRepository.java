package org.wrzesien.$11designPattarns.DependencyInjeciton.repository;

import org.wrzesien.$11designPattarns.DependencyInjeciton.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
	private final Map<String, Product> db = new HashMap<>();

	public void save(final Product p) {
		db.put(p.id(), p);
	}

	public List<Product> findAll() {
		return new ArrayList<>(db.values());
	}

	public Product findById(final String id) {
		return db.get(id);
	}
}
