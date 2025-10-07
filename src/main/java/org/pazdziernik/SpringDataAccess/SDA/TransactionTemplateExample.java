package org.pazdziernik.SpringDataAccess.SDA;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class TransactionTemplateExample {
	private SomeOtherBean someOtherBean;

	@Transactional
	private Integer someMethod() {
		return someOtherBean.example();
	}
}
