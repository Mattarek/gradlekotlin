package org.wrzesien.$15mockowanie.$1przypomnenie.repository;

import org.wrzesien.$15mockowanie.$1przypomnenie.model.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OrderRepository {
	private final Map<String, Order> storage = new HashMap<>();

	public void save(final Order order) {
		storage.put(order.getId(), order);
	}

	public Optional<Order> findById(final String id) {
		return Optional.of(storage.get(id));
	}
}
