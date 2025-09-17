package org.wrzesien.$11designPattarns.PrzykladowyProjekt.service;

import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Customer;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Order;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Product;

import java.util.List;

/**
 * Service interface: defines use-cases (SRP, DIP)
 */
public interface OrderService {
	Order createOrder(String orderId, Customer customer, List<Product> items);
}
