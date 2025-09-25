package org.wrzesien.$14SpringBean.$5springBeansDemoTwo.repository;

import org.springframework.stereotype.Repository;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Product;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {
	private final Map<Long, Product> storage = new HashMap<>();

	public void save(final Product product) {
		storage.put(product.id(), product);
	}

	public Product findById(final Long id) {
		return storage.get(id);
	}
}
