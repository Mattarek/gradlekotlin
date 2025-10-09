package org.pazdziernik.SpringDataAccess.project.business;

import org.pazdziernik.SpringDataAccess.project.domain.Customer;

public interface CustomerRepository {
	Customer create(Customer customer);
}
