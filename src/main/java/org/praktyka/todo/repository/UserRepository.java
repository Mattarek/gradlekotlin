package org.praktyka.todo.repository;

import org.praktyka.todo.model.User;
import org.praktyka.todo.service.FileService;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	private final String fileName;
	private final List<User> users;
	private final FileService fileService = new FileService();

	public UserRepository(final String fileName, final List<User> users) {
		this.fileName = fileName;
		this.users = users;
	}

	public List<User> loadUsers() {
		if (fileName.isEmpty()) {
			return new ArrayList<>();
		}
		final List<User> users = fileService.load(fileName);
		return users;
	}

	public boolean saveUsers() {
		if (fileName.isEmpty()) {
			return false;
		}
		fileService.save(fileName, users);
		return true;
	}
}
