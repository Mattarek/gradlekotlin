package org.pazdziernik.SpringDataAccess.wstep;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SimpleJdbcCallEample {
	private final SimpleDriverDataSource simpleDriverDataSource;

	public void example() {
		final SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(simpleDriverDataSource);
		simpleJdbcCall.withFunctionName("calc_sum");
		final SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("value1", 24)
				.addValue("value2", 12);

		final Integer result = simpleJdbcCall.executeFunction(Integer.class, sqlParameterSource);

		System.out.println(result);
	}
}
