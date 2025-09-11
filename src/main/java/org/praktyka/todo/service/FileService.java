package org.praktyka.todo.service;

import org.praktyka.todo.model.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
	public List<User> load(final String fileName) {
		final List<User> users = new ArrayList<>();
		final File file = new File(fileName);
		if (!file.exists()) {
			return users;
		}

		try (final BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				final String[] parts = line.split(";");
				if (parts.length == 2) {
					users.add(new User(parts[0], parts[1]));
				}
			}
		} catch (final IOException ioException) {
			System.out.println(ioException.getMessage());
		}

		return users;
	}

	public void save(final String fileName, final List<User> users) {
		try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
			for (final User user : users) {
				bufferedWriter.write(user.login() + ";" + user.password());
				bufferedWriter.newLine();
			}
		} catch (final IOException ioException) {
			ioException.getMessage();
		}
	}
}
