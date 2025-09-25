package org.wrzesien.$14SpringBean.$5springBeansDemoTwo.repository;

import org.springframework.stereotype.Repository;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Customer;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepository {
	private final Map<Long, Customer> storage = new HashMap<>();

	public void save(final Customer customer) {
		storage.put(customer.id(), customer);
	}

	public Customer findById(final Long id) {
		return storage.get(id);
	}
}