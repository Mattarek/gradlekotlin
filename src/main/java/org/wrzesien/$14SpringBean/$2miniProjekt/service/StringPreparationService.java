package org.wrzesien.$14SpringBean.$2miniProjekt.service;

import org.springframework.stereotype.Service;
import org.wrzesien.$14SpringBean.$2miniProjekt.domain.User;

@Service
public class StringPreparationService {
	public String prepare(final User user) {
		return String.format("%s;%s", user.getBirth_date(), user.getEmail());
	}
}
