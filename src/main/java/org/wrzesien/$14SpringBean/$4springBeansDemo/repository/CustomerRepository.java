package org.wrzesien.$14SpringBean.$4springBeansDemo.repository;

import org.springframework.stereotype.Repository;
import org.wrzesien.$14SpringBean.$4springBeansDemo.model.Customer;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepository {
	private final Map<Long, Customer> customers = new HashMap<>();

	public void save(final Customer customer) {
		customers.put(customer.id(), customer);
		System.out.println("Saved" + customer);
	}

	public Customer findById(final Long id) {
		return customers.get(id);
	}
}
