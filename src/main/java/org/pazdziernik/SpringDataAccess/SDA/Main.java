package org.pazdziernik.SpringDataAccess.SDA;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(final String[] args) {
		final ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);

		final TransactionTemplateExample jdbcTemplateExamplate = context.getBean(TransactionTemplateExample.class);
		jdbcTemplateExamplate.exampleOne();
	}
}

