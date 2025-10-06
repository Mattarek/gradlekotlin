package org.pazdziernik.SpringDataAccess.SDA;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class TransactionTemplateExample {
	private static final String SQL = "INSERT INTO PERSON (NAME, AGE) VALUES (:name, :age)";
	private final SimpleDriverDataSource simpleDriverDataSource;
	private TransactionTemplate transactionTemplate;

	public void exampleOne() {
		final Integer result = transactionTemplate.execute(status -> {
			final Integer res = someMethod();
			status.setRollbackOnly();
			log.error("Transaction rollback");
			return res;
		});
	}

	public void exampleTwo() {
	}

	private Integer someMethod() {
		int result = 0;

		final NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(simpleDriverDataSource);

		final Person personOne = Person.builder().name("Roman").age(55).build();
		final Person personTwo = Person.builder().name("Tomasz").age(22).build();
		final Person personThree = Person.builder().name("Roman").age(21).build();

		result += jdbcTemplate.update(SQL, new BeanPropertySqlParameterSource(personOne));
		result += jdbcTemplate.update(SQL, new BeanPropertySqlParameterSource(personTwo));
		result += jdbcTemplate.update(SQL, new BeanPropertySqlParameterSource(personThree));

		return result;
	}

	private void someVoidMethod() {
		final NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(simpleDriverDataSource);

		final Person personOne = Person.builder().name("Roman").age(55).build();
		final Person personTwo = Person.builder().name("Tomasz").age(25).build();
		final Person personThree = Person.builder().name("Andrzej").age(21).build();

		jdbcTemplate.update(SQL, new BeanPropertySqlParameterSource(personOne));
		jdbcTemplate.update(SQL, new BeanPropertySqlParameterSource(personTwo));
		jdbcTemplate.update(SQL, new BeanPropertySqlParameterSource(personThree));
	}
}
