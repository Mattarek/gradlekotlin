package org.wrzesien.$15mockowanie.$1przypomnenie.service;

import org.wrzesien.$15mockowanie.$1przypomnenie.exception.PaymentFailedException;
import org.wrzesien.$15mockowanie.$1przypomnenie.model.Order;
import org.wrzesien.$15mockowanie.$1przypomnenie.repository.OrderRepository;

public class OrderService {
	private final OrderRepository orderRepository;
	private final PaymentGateway paymentGateway;

	public OrderService(final OrderRepository orderRepository, final PaymentGateway paymentGateway) {
		this.orderRepository = orderRepository;
		this.paymentGateway = paymentGateway;
	}

	public void placeOrder(final Order order) {
		final boolean charged = paymentGateway.charge(order.getAmount());
		if (!charged) {
			throw new PaymentFailedException("Payment failed for order " + order.getId());
		}
		order.markPaid();
		orderRepository.save(order);
	}
}
