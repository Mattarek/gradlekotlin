package org.wrzesien.$14SpringBean.$5springBeansDemoTwo.controller;

import org.springframework.stereotype.Controller;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Customer;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Order;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Product;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.service.OrderService;

@Controller
public class OrderController {
	private final OrderService orderService;

	public OrderController(final OrderService service) {
		orderService = service;
	}

	public void createAndPlaceOrder(final Customer customer, final Product product, final int quantity, final Long orderId) {
		final Order order = new Order(orderId, customer, product, quantity);
		orderService.placeOrder(order);
	}
}
