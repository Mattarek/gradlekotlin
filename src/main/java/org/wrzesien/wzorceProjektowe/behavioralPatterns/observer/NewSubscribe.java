package org.wrzesien.wzorceProjektowe.behavioralPatterns.observer;

import java.util.Objects;

public class NewSubscribe implements Observer {
	private final String username;

	public NewSubscribe(final String username) {
		this.username = username;
	}

	public void update(final String message) {
		if (Objects.isNull(message)) {
			System.out.printf("%s - Message null%n", username);
		} else {
			System.out.printf("%s - Message %s%n", username, message);
		}
	}
}
