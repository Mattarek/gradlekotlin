package org.wrzesien.$14SpringBean.$4springBeansDemo.service;

import org.springframework.stereotype.Service;
import org.wrzesien.$14SpringBean.$4springBeansDemo.model.Order;
import org.wrzesien.$14SpringBean.$4springBeansDemo.repository.OrderRepository;

@Service
public class OrderService {
	private final OrderRepository orderRepository;
	private final PaymentService paymentService;
	private final EmailService emailService;

	public OrderService(final OrderRepository orderRepository, final PaymentService paymentService, final EmailService emailService) {
		this.orderRepository = orderRepository;
		this.paymentService = paymentService;
		this.emailService = emailService;
	}

	public void placeOrder(final Order order) {
		orderRepository.save(order);
		paymentService.processPayment(order.product().price() * order.quantity());
		emailService.sendEmail(order.customer().email(), "Your order " + order.id() + "has been placed!");
	}
}
