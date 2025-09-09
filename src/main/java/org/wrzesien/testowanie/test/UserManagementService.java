package org.wrzesien.testowanie.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class UserManagementService {
	private final Map<String, User> usersMap = new TreeMap<>();

	public void create(final User user) {
		if (usersMap.containsKey(user.getEmail())) {
			throw new RuntimeException(
					String.format("User with email: [%s] is already created", user.getEmail())
			);
		}
		usersMap.put(user.getEmail(), user);
	}

	public Optional<User> findByEmail(final String email) {
		return Optional.ofNullable(usersMap.get(email));
	}

	public List<User> findByName(final String name) {
		return usersMap.values().stream()
				.filter(user -> user.getName().equals(name))
				.toList();
	}

	public List<User> findAll() {
		return new ArrayList<>(usersMap.values());
	}

	public Optional<User> update(final String email, final User updatedUser) {
		if (!usersMap.containsKey(email)) {
			throw new RuntimeException(
					String.format("User with email: [%s] doesn't exist", email)
			);
		}

		return Optional.of(updatedUser);
	}

	public boolean delete(final String email) {
		if (!usersMap.containsKey(email)) {
			throw new RuntimeException(
					String.format("User with email: [%s] doesn't exist", email)
			);
		}
		return usersMap.remove(email) != null;
	}
}
