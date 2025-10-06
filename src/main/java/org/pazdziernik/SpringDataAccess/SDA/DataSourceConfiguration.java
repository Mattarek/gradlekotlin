package org.pazdziernik.SpringDataAccess.SDA;

import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@ComponentScan(basePackages = "org.pazdziernik.SpringDataAccess.SDA")
public class DataSourceConfiguration {
	@Bean
	public SimpleDriverDataSource databaseDataSource() {
		final SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new Driver());
		dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(databaseDataSource());
	}

	@Bean
	public TransactionTemplate transactionTemplate(final PlatformTransactionManager transactionManager) {
		return new TransactionTemplate(transactionManager);
	}
}
