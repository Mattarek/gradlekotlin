package org.praktyka.todo;

import org.praktyka.todo.repository.UserRepository;
import org.praktyka.todo.service.AuthService;
import org.praktyka.todo.service.FileService;

import java.util.Map;
import java.util.Scanner;

public class Main {
	static final Scanner scanner = new Scanner(System.in);
	private static final String FILE_NAME = "users.txt";
	private static final FileService fileService = new FileService();
	static final UserRepository userRepository = new UserRepository(FILE_NAME, fileService);
	static final AuthService authService = new AuthService(userRepository);

	public static void main(final String[] args) {
		while (true) {
			System.out.println("==== ToDo Menedżer ====");
			System.out.println("1. Rejestracja");
			System.out.println("2. Logowanie");
			System.out.println("3. Wyjście");
			System.out.print("Wybór: ");

			final String choice = scanner.nextLine();

			final Map<String, Runnable> actions = Map.of(
					"1", Main::register,
					"2", Main::login,
					"3", Main::exit
			);

			actions.getOrDefault(choice, () -> System.out.println("Niepoprawna opcja.")).run();
		}
	}

	private static void register() {
		System.out.print("Login: ");
		final String regLogin = scanner.nextLine();
		System.out.print("Hasło: ");
		final String regPass = scanner.nextLine();
		if (authService.register(regLogin, regPass)) {
			System.out.println("Rejestracja udana!");
		} else {
			System.out.println("Login już istnieje.");
		}
	}

	private static void login() {
		System.out.print("Login: ");
		final String logLogin = scanner.nextLine();
		System.out.print("Hasło: ");
		final String logPass = scanner.nextLine();
		if (authService.login(logLogin, logPass)) {
			System.out.println("Zalogowano pomyślnie!");
		} else {
			System.out.println("Błędny login lub hasło.");
		}
	}

	private static void exit() {
		System.out.println("Do widzenia!");
		System.exit(0);
	}
}