package org.wrzesien.$11designPattarns.DependencyInjeciton.service;

import org.wrzesien.$11designPattarns.DependencyInjeciton.model.Product;
import org.wrzesien.$11designPattarns.DependencyInjeciton.repository.ProductRepository;

import java.util.List;

public class ProductService {
	private final ProductRepository repository;

	public ProductService(final ProductRepository repository) {
		this.repository = repository;
	}

	public void addProduct(final Product product) {
		repository.save(product);
	}

	public List<Product> listProducts() {
		return repository.findAll();
	}
}
