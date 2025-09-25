package org.wrzesien.$14SpringBean.$5springBeansDemoTwo.controller;

import org.springframework.stereotype.Controller;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Customer;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.service.CustomerService;

@Controller
public class CustomerController {
	private final CustomerService service;

	public CustomerController(final CustomerService service) {
		this.service = service;
	}

	public void addCustomer(final Long id, final String name, final String email) {
		final Customer customer = new Customer(id, name, email);
		service.addCustomer(customer);
	}
}
