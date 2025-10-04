package org.pazdziernik.SpringDataAccess.wstep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(final String[] args) throws SQLException {
		final String url = "jdbc:postgresql://localhost:5432/zajavka";
		final String user = "postgresql";
		final String password = "postgresql";

		final Connection connection = DriverManager.getConnection(url, user, password);
		final Statement statement = connection.createStatement();
	}
}
