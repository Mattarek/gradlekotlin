package org.wrzesien.$14SpringBean.$4springBeansDemo.repository;

import org.wrzesien.$14SpringBean.$4springBeansDemo.model.Product;

public interface IProductRepository {
	void save(Product product);

	Product findById(Long id);
}
