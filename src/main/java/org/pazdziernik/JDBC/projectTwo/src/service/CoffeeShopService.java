package org.pazdziernik.JDBC.projectTwo.src.service;

import org.pazdziernik.JDBC.projectTwo.src.dao.CustomerDAO;
import org.pazdziernik.JDBC.projectTwo.src.dao.OrderDAO;
import org.pazdziernik.JDBC.projectTwo.src.db.DatabaseConnection;
import org.pazdziernik.JDBC.projectTwo.src.model.Customer;
import org.pazdziernik.JDBC.projectTwo.src.model.Order;

import java.sql.Connection;
import java.sql.SQLException;

public class CoffeeShopService {
	private final CustomerDAO customerDAO = new CustomerDAO();
	private final OrderDAO orderDAO = new OrderDAO();

	public void createOrderWithNewCustomer(final Customer customer, final Order order) {
		try (final Connection connection = DatabaseConnection.getConnection()) {
			connection.setAutoCommit(false);
			final int customerId = customerDAO.addCustomerTransactional(connection, customer);
			order.setCustomerId(customerId);
			orderDAO.addOrderTransactional(connection, order);

			connection.commit();
			System.out.println("✅ Transakcja zakończona sukcesem!");
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
}
