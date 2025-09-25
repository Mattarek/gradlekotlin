package org.wrzesien.$14SpringBean.$4springBeansDemo.repository;

import org.springframework.stereotype.Repository;
import org.wrzesien.$14SpringBean.$4springBeansDemo.model.Product;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
	private final Map<Long, Product> products = new HashMap<>();

	public void save(final Product product) {
		products.put(product.id(), product);
		System.out.println("Saved: " + product);
	}

	public Product findById(final Long id) {
		return products.get(id);
	}
}
