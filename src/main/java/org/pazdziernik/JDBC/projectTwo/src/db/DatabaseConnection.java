package org.pazdziernik.JDBC.projectTwo.src.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String URL = "jdbc:postgresql://localhost:5432/coffee_shop";
	private static final String USER = "postgres";
	private static final String PASSWORD = "postgres";

	private DatabaseConnection() {
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}