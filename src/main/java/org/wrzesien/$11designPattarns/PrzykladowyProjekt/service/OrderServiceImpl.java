package org.wrzesien.$11designPattarns.PrzykladowyProjekt.service;

import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Customer;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Order;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Product;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of OrderService. Responsibilities:
 * - validate inputs (Fail-Fast)
 * - create Order aggregate and persist it (SRP)
 * Principles:
 * - DIP: depends on OrderRepository abstraction
 * - KISS: straightforward logic
 * - YAGNI: no transactional or distributed concerns - those would be added only when needed
 */
public class OrderServiceImpl implements OrderService {
	private final OrderRepository orderRepository;

	public OrderServiceImpl(final OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order createOrder(final String orderId, final Customer customer, final List<Product> items) {
		// Fast fail validation
		final String id = orderId == null || orderId.isBlank() ? UUID.randomUUID().toString() : orderId;
		if (customer == null) {
			throw new IllegalArgumentException("Customer is required.");
		}
		if (items == null || items.isEmpty()) {
			throw new IllegalArgumentException("Items required");
		}

		final Order order = new Order(id, customer, items);
		orderRepository.save(order);
		return order;
	}
}
