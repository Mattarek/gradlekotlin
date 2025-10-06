package org.pazdziernik.SpringDataAccess.wstep;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcTemplateExample {
	private final SimpleDriverDataSource simpleDriverDataSource;

	public void delete() {
		final JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
		final String sql = "DELETE FROM PERSON WHERE NAME = ?";
		final int result = jdbcTemplate.update(sql, "Andrzej");
		System.out.println(result);
	}

	public void select() {
		final JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
		final String sql = "SELECT * FROM PERSON";
		final RowMapper<Person> personRowMapper = (resultSet, rowNum) -> Person.builder()
				.id(resultSet.getLong("ID"))
				.name(resultSet.getString("NAME"))
				.age(resultSet.getInt("AGE"))
				.build();

		final List<Person> resultOne = jdbcTemplate.query(sql, personRowMapper);
		System.out.println(resultOne);

		final BeanPropertyRowMapper<Person> personBeanPropertyMapper = BeanPropertyRowMapper.newInstance(Person.class);
		jdbcTemplate.query(sql, personBeanPropertyMapper);
	}

	public void update() {

		final JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
		final String sql = "UPDATE person SET age = ? WHERE name = ?";
		jdbcTemplate.update(sql, 40, "Roman");
	}

	public void insert() {
		final JdbcTemplate jdbcTemplate = new JdbcTemplate(simpleDriverDataSource);
		final String sql = "INSERT INTO PERSON (NAME, AGE) VALUES (?,?)";
		jdbcTemplate.update(sql, "Andrzej", 30);
	}
}
