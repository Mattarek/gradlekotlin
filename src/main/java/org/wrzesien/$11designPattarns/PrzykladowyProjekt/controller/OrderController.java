package org.wrzesien.$11designPattarns.PrzykladowyProjekt.controller;

import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Customer;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Order;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Product;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.service.OrderService;

import java.util.List;

/**
 * Thin controller that translates input into service calls.
 * Principles:
 * - SRP: only orchestrates input->service->output
 * - LoD: interacts with service (its direct collaborator) only
 * - KISS: avoids embedding business logic here
 */
public class OrderController {
	private final OrderService orderService;

	public OrderController(final OrderService orderService) {
		this.orderService = orderService;
	}

	public Order handleCreateOrder(final String orderId, final Customer customer, final List<Product> items) {
		return orderService.createOrder(orderId, customer, items);
	}
}
