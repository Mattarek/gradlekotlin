package org.praktyka.todo.service;

import org.praktyka.todo.model.User;
import org.praktyka.todo.repository.UserRepository;

import java.util.List;

public class AuthService {
	private final UserRepository userRepository;

	public AuthService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public boolean register(final String login, final String password) {
		if (login == null || login.isEmpty() || password == null || password.isEmpty()) {
			return false;
		}

		final List<User> users = userRepository.loadUsers();
		if (users.stream().anyMatch(u -> u.login().equals(login))) {
			return false;
		}

		users.add(new User(login, password));
		userRepository.saveUsers();
		return true;
	}

	public boolean login(final String login, final String password) {
		final List<User> users = userRepository.loadUsers();
		return users.stream().anyMatch(u -> u.login().equals(login) && u.password().equals(password));
	}
}
