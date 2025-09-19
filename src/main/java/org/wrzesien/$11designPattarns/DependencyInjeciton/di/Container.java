package org.wrzesien.$11designPattarns.DependencyInjeciton.di;

import org.wrzesien.$11designPattarns.DependencyInjeciton.controller.ProductController;
import org.wrzesien.$11designPattarns.DependencyInjeciton.repository.ProductRepository;
import org.wrzesien.$11designPattarns.DependencyInjeciton.service.ProductService;

public class Container {
	public final ProductRepository repository = new ProductRepository();
	public final ProductService service = new ProductService(repository);
	public final ProductController controller = new ProductController(service);
}
