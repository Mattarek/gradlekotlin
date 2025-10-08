package org.pazdziernik.SpringDataAccess.project.infrastructure;

import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {
	@Bean
	public SimpleDriverDataSource simpleDriverDataSource() {
		final SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new Driver());
		dataSource.setUrl("jdbc:postgresql://localhost:5432/zajavka_store");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		System.out.println(dataSource);
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(simpleDriverDataSource());
	}
}
