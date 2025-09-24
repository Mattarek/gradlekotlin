package org.wrzesien.$14Spring.miniProjekt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wrzesien.$14Spring.miniProjekt.config.ApplicationConfiguration;
import org.wrzesien.$14Spring.miniProjekt.service.DataProcessingService;
import org.wrzesien.$14Spring.miniProjekt.service.DataRepository;
import org.wrzesien.$14Spring.miniProjekt.service.MainProcessor;
import org.wrzesien.$14Spring.miniProjekt.service.StringPreparationService;

public class Main {
	public static void main(final String[] args) {
		final ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		final MainProcessor mainProcessor = context.getBean(MainProcessor.class);

		//		final MainProcessor mainProcessor = new MainProcessor(
		//				new DataRepository(),
		//				new DataProcessingService(
		//						new StringPreparationService()
		//				)
		//		);
		mainProcessor.process();
	}
}
