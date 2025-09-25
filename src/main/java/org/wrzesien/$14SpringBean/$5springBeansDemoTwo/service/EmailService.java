package org.wrzesien.$14SpringBean.$5springBeansDemoTwo.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	public void send(final String to, final String body) {
		System.out.println("EmailService: Sending email to " + to + " body: " + body);
	}
}