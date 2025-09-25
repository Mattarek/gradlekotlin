package org.wrzesien.$14SpringBean.$5springBeansDemoTwo.repository;

import org.springframework.stereotype.Repository;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Order;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {
	private final Map<Long, Order> storage = new HashMap<>();

	public void save(final Order order) {
		storage.put(order.id(), order);
	}

	public Order findById(final Long id) {
		return storage.get(id);
	}
}
