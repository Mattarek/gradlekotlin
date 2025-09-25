package org.wrzesien.$14SpringBean.$4springBeansDemo.service;

import org.springframework.stereotype.Service;
import org.wrzesien.$14SpringBean.$4springBeansDemo.model.Customer;
import org.wrzesien.$14SpringBean.$4springBeansDemo.repository.CustomerRepository;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;

	public CustomerService(final CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void addCustomer(final Customer customer) {
		customerRepository.save(customer);
	}
}
