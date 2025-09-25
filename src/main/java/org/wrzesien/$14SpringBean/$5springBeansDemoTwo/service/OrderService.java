package org.wrzesien.$14SpringBean.$5springBeansDemoTwo.service;

import org.springframework.stereotype.Service;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Order;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.repository.OrderRepository;

@Service
public class OrderService {
	private final OrderRepository repository;

	public OrderService(final OrderRepository repository) {
		this.repository = repository;
	}

	public void placeOrder(final Order order) {
		repository.save(order);
	}

	public Order getOrder(final Long id) {
		return repository.findById(id);
	}
}