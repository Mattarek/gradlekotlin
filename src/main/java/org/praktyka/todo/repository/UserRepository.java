package org.praktyka.todo.repository;

import org.praktyka.todo.model.User;
import org.praktyka.todo.service.FileService;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	private final String fileName;
	private final List<User> usersList = new ArrayList<>();
	private final FileService fileService;

	public UserRepository(final String fileName, final FileService fileService) {
		this.fileName = fileName;
		this.fileService = fileService;
	}

	public List<User> loadUsers() {
		usersList.clear();
		usersList.addAll(fileService.load(fileName));
		return usersList;
	}

	public boolean saveUsers() {
		fileService.save(fileName, usersList);
		return true;
	}

	public boolean addUser(final User user) {
		if (usersList.stream().anyMatch(u -> u.login().equals(user.login()))) {
			return false;
		}
		usersList.add(user);
		saveUsers();
		return true;
	}
}