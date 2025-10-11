package org.pazdziernik.JDBC.src.dao;

import org.pazdziernik.JDBC.src.util.DatabaseUtil;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class TransferDao {
	public boolean executeTransfer(final int senderId, final int reciverId, final BigDecimal amount) {
		final String sql = "CALL transfer_money(?, ?, ?)";
		try (
				final Connection connection = DatabaseUtil.getConnection();
				final CallableStatement callableStatement =
						connection.prepareCall(sql)
		) {
			connection.setAutoCommit(false);
			callableStatement.setInt(1, senderId);
			callableStatement.setInt(2, reciverId);
			callableStatement.setBigDecimal(3, amount);

			callableStatement.execute();
			connection.commit();

			return true;
		} catch (final SQLException e) {
			e.printStackTrace();
			return true;
		}
	}
}
