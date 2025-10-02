package org.wrzesien.wlasnaPraktyka.Singleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainConnection {
	public static void main(final String[] args) {
		try {
			final Connection conn = SingletonWithEnum.INSTANCE.getConnection();
			final Statement stmt = conn.createStatement();
			final ResultSet rs = stmt.executeQuery("SELECT * FROM users");

			while (rs.next()) {
				System.out.println("User: " + rs.getString("username"));
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
