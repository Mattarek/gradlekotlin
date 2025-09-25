package org.wrzesien.$14SpringBean.$4springBeansDemo.repository;

import org.springframework.stereotype.Repository;
import org.wrzesien.$14SpringBean.$4springBeansDemo.model.Order;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {
	private final Map<Long, Order> orders = new HashMap<>();

	public void save(final Order order) {
		orders.put(order.id(), order);
	}

	public Order findById(final Long id) {
		return orders.get(id);
	}
}
