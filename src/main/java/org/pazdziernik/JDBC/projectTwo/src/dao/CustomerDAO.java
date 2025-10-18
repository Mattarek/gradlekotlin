package org.pazdziernik.JDBC.projectTwo.src.dao;

import org.pazdziernik.JDBC.projectTwo.src.db.DatabaseConnection;
import org.pazdziernik.JDBC.projectTwo.src.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	public int addCustomerTransactional(final Connection conn, final Customer customer) throws SQLException {
		final String sql = "INSERT INTO customers (name, email) VALUES (?, ?) RETURNING id";
		try (final PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getEmail());
			final ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return rs.getInt("id");
			}
		}
		return -1;
	}

	public void addCustomer(final Customer customer) throws SQLException {
		try (final Connection conn = DatabaseConnection.getConnection()) {
			addCustomerTransactional(conn, customer);
		}
	}

	public List<Customer> getAllCustomers() throws SQLException {
		final String sql = "SELECT * FROM customers";
		final List<Customer> list = new ArrayList<>();

		try (final Connection conn = DatabaseConnection.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(sql);
			 final ResultSet rs = statement.executeQuery()) {
			while (rs.next()) {
				list.add(new Customer(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getTimestamp("created_at").toLocalDateTime()
				));
			}
		}
		return list;
	}
}
