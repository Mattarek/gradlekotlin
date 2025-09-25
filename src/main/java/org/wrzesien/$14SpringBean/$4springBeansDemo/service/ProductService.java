package org.wrzesien.$14SpringBean.$4springBeansDemo.service;

import org.springframework.stereotype.Service;
import org.wrzesien.$14SpringBean.$4springBeansDemo.model.Product;
import org.wrzesien.$14SpringBean.$4springBeansDemo.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

	public ProductService(final ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void addProduct(final Product product) {
		productRepository.save(product);
	}
}
