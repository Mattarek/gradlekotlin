package org.pazdziernik.JDBC.src.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	private static final String URL = "jdbc:postgresql://localhost:5432/postgrebank";
	private static final String USER = "postgres";
	private static final String PASSWORD = "postgres";

	private DatabaseUtil() {
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
