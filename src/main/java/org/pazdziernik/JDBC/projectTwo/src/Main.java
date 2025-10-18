package org.pazdziernik.JDBC.projectTwo.src;

import org.pazdziernik.JDBC.projectTwo.src.model.Customer;
import org.pazdziernik.JDBC.projectTwo.src.model.Order;
import org.pazdziernik.JDBC.projectTwo.src.service.CoffeeShopService;

import java.math.BigDecimal;

public class Main {
	public static void main(final String[] args) {
		final CoffeeShopService service = new CoffeeShopService();
		final Customer customer = new Customer("Marcin", "marcin@example.pl");
		final Order order = new Order(null, null, new BigDecimal("15.50"));

		service.createOrderWithNewCustomer(customer, order);
	}
}
