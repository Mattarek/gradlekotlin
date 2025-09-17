package org.wrzesien.$11designPattarns.PrzykladowyProjekt.repository;

import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
	void save(Order order);

	Optional<Order> findById(String id);

	List<Order> findAll();
}
