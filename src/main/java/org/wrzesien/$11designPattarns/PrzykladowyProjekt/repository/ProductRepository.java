package org.wrzesien.$11designPattarns.PrzykladowyProjekt.repository;

import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface - DIP and ISP
 * Principles:
 * - Dependency Inversion: code depends on this abstraction
 * - Interface Segregation: small focused repo interface
 */
public interface ProductRepository {
	Optional<Product> findById(String id);

	List<Product> findAll();
}
