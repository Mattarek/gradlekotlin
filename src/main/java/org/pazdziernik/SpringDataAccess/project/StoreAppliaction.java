package org.pazdziernik.SpringDataAccess.project;

import org.pazdziernik.SpringDataAccess.project.business.RandomDataService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wrzesien.$14SpringBean.$2miniProjekt.config.ApplicationConfiguration;

public class StoreAppliaction {
	public static void main(final String[] args) {
		final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

		final RandomDataService randomDataService = applicationContext.getBean(RandomDataService.class);
		randomDataService.create();
	}
}
