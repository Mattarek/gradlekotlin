package org.pazdziernik.JDBC.projectTwo.src.dao;

import org.pazdziernik.JDBC.projectTwo.src.db.DatabaseConnection;
import org.pazdziernik.JDBC.projectTwo.src.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
	public void addOrderTransactional(final Connection conn, final Order order) throws SQLException {
		final String sql = "INSERT INTO orders (customer_id, total) VALUES (?,?)";
		try (final PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, order.getCustomerId());
			statement.setBigDecimal(2, order.getTotal());
			statement.executeUpdate();
		}
	}

	public List<Order> getOrdersForCustomer(final int customerId) throws SQLException {
		final String sql = "SELECT * FROM orders WHERE customer_id = ?";
		final List<Order> list = new ArrayList<>();

		try (final Connection conn = DatabaseConnection.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, customerId);
			final ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				final Order order = new Order(
						rs.getInt("id"),
						rs.getInt("customer_id"),
						rs.getBigDecimal("total")
				);

				order.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
				list.add(order);
			}

			return list;
		}
	}
}
