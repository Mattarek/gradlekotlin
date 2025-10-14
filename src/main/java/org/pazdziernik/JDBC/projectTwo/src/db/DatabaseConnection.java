package org.pazdziernik.JDBC.projectTwo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseConnection {

	private static final String PROPERTIES_FILE = "/db.properties";

	public static Connection getConnection() throws SQLException {
		try (final InputStream input = DatabaseConnection.class.getResourceAsStream(PROPERTIES_FILE)) {
			final Properties props = new Properties();
			props.load(input);

			final String url = props.getProperty("db.url");
			final String user = props.getProperty("db.user");
			final String pass = props.getProperty("db.password");

			return DriverManager.getConnection(url, user, pass);
		} catch (final Exception e) {
			throw new SQLException("Nie udało się nawiązać połączenia z bazą danych", e);
		}
	}
}
