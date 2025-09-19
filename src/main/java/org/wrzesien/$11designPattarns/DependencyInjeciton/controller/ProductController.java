package org.wrzesien.$11designPattarns.DependencyInjeciton.controller;

import org.wrzesien.$11designPattarns.DependencyInjeciton.model.Product;
import org.wrzesien.$11designPattarns.DependencyInjeciton.service.ProductService;

public class ProductController {
	private final ProductService productService;

	public ProductController(final ProductService service) {
		productService = service;
	}

	public void createProduct(final String id, final String name, final double price) {
		productService.addProduct(new Product(id, name, price));
	}

	public void showAllProducts() {
		productService.listProducts().forEach(p -> System.out.println(p.id() + ": " + p.name() + " - " + p.price()));
	}
}
