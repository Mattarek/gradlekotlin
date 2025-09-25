package org.wrzesien.$14SpringBean.$5springBeansDemoTwo.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	public void pay(final double amount) {
		System.out.println("PaymentService: Paid " + amount);
	}
}