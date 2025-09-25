package org.wrzesien.$14SpringBean.$4springBeansDemo.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	public void sendEmail(final String to, final String message) {
		System.out.println("Sending email to " + to + " with message: " + message);
	}
}
