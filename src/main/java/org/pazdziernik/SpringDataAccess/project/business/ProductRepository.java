package org.pazdziernik.SpringDataAccess.project.business;

import org.pazdziernik.SpringDataAccess.project.domain.Product;

public interface ProductRepository {
	Product create(Product product);
}
