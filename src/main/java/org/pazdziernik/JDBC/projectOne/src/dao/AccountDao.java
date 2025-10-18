package org.pazdziernik.JDBC.projectOne.src.dao;

import org.pazdziernik.JDBC.projectOne.src.model.Account;
import org.pazdziernik.JDBC.projectOne.src.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
	public List<Account> findAll() {
		final List<Account> accounts = new ArrayList<>();
		final String sql = "SELECT id, owner_name, balance FROM accounts";

		try (final Connection connection = DatabaseUtil.getConnection();
			 final Statement statement = connection.createStatement();
			 final ResultSet resultSet = statement.executeQuery(sql)
		) {
			while (resultSet.next()) {
				accounts.add(
						new Account(
								resultSet.getInt("id"),
								resultSet.getString("owner_name"),
								resultSet.getBigDecimal("balance")
						)
				);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
}
