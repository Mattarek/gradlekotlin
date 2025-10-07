package org.pazdziernik.SpringDataAccess.wstep;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class Main {
	public static void main(final String[] args) {
		final ApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(DataSourceConfiguration.class);

		final SampleJdbcInsertExample example = applicationContext.getBean(SampleJdbcInsertExample.class);

		final NamedParameterJdbcTemplateExample namedExample =
				applicationContext.getBean(NamedParameterJdbcTemplateExample.class);

		namedExample.example();
	}
}
