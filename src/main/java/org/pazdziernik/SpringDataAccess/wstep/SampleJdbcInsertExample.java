package org.pazdziernik.SpringDataAccess.wstep;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class SampleJdbcInsertExample {
	private final SimpleDriverDataSource simpleDriverDataSource;

	public void smpleJdbcInsertExample() {
		final SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(simpleDriverDataSource);
		simpleJdbcInsert.setTableName("PERSON");
		final Person person = Person.builder()
				.id(39)
				.name("Sławek")
				.age(22)
				.build();

		simpleJdbcInsert.execute(new BeanPropertySqlParameterSource(person));

		// Sposób nr.2
		//		final Map<String, Object> params = new HashMap<>();
		//		params.put("ID", 12);
		//		params.put("NAME", "Karol");
		//		params.put("AGE", 19);
		//		final int execute = simpleJdbcInsert.execute(params);
		//		System.out.println(execute);
	}
}
