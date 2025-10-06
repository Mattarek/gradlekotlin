package org.pazdziernik.SpringDataAccess.wstep;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NamedParameterJdbcTemplateExample {
	private final SimpleDriverDataSource simpleDriverDataSource;

	public void example() {
		final NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(simpleDriverDataSource);

		final String sql = "INSERT INTO PERSON (NAME, AGE) VALUES (:name, :age)";
		// Sposób nr.1
		//		final Map<String, Object> params1 = new HashMap<>();
		//		params1.put("name", "Romek");
		//		params1.put("age", 22);

		// Sposób nr.2

		final MapSqlParameterSource params2 = new MapSqlParameterSource()
				.addValue("name", "Andrzej")
				.addValue("age", 102);

		final Person person = Person.builder()
				.name("Agnieszka")
				.age(25)
				.build();

		final BeanPropertySqlParameterSource params3 = new BeanPropertySqlParameterSource(person);
		template.update(sql, params3);
	}
}
