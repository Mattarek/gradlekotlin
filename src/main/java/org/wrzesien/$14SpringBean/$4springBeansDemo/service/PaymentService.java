package org.wrzesien.$14SpringBean.$4springBeansDemo.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	public void processPayment(final double amount) {
		System.out.println("Processing payment of " + amount + " PLN");
	}
}
