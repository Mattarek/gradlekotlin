package org.wrzesien.$11designPattarns.PrzykladowyProjekt.repository;

import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Order;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryOrderRepository implements OrderRepository {
	private final Map<String, Order> store = new LinkedHashMap<>();

	@Override
	public void save(final Order order) {
		store.put(order.id(), order);
	}

	@Override
	public Optional<Order> findById(final String id) {
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public List<Order> findAll() {
		return new ArrayList<>(store.values());
	}
}
