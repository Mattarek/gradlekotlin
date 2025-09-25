package org.wrzesien.$14SpringBean.$5springBeansDemoTwo.controller;

import org.springframework.stereotype.Controller;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Product;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.service.ProductService;

@Controller
public class ProductController {
	private final ProductService productService;

	public ProductController(final ProductService productService) {
		this.productService = productService;
	}

	public void addProduct(final Long id, final String name, final double price) {
		final Product product = new Product(id, name, price);
		productService.addProduct(product);
	}
}
