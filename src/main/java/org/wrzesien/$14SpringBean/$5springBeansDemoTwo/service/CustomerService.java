package org.wrzesien.$14SpringBean.$5springBeansDemoTwo.service;

import org.springframework.stereotype.Service;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Customer;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.repository.CustomerRepository;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;

	public CustomerService(final CustomerRepository repository) {
		customerRepository = repository;
	}

	public void addCustomer(final Customer customer) {
		customerRepository.save(customer);
	}

	public Customer getCustomer(final Long id) {
		return customerRepository.findById(id);
	}
}
