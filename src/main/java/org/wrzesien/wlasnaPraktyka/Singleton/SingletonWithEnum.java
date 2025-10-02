package org.wrzesien.wlasnaPraktyka.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum SingletonWithEnum {
	INSTANCE;

	private final Connection connection;

	SingletonWithEnum() {
		try {
			final String url = "URL";
			final String user = "user";
			final String password = "password";
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Połączenie z bazą utworzone");
		} catch (final SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Connection getConnection() {
		return connection;
	}
}
