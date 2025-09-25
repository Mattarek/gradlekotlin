package org.wrzesien.$14SpringBean.$2miniProjekt.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.wrzesien.$14SpringBean.$2miniProjekt.domain.User;

import java.util.List;

@Component
@AllArgsConstructor
public class MainProcessor {
	private final DataRepository dataRepository;
	private final DataProcessingService dataProcessingService;

	public void process() {
		final List<User> users = dataRepository.readUsers();
		final List<String> processed = dataProcessingService.process(users);
		dataRepository.save(processed);
	}
}
