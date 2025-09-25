package org.wrzesien.$14SpringBean.$5springBeansDemoTwo.service;

import org.springframework.stereotype.Service;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Product;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository repository;

	public ProductService(final ProductRepository repository) {
		this.repository = repository;
	}

	public void addProduct(final Product product) {
		repository.save(product);
	}

	public Product getProduct(final Long id) {
		return repository.findById(id);
	}
}
