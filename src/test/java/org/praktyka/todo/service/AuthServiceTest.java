package org.praktyka.todo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.praktyka.todo.repository.UserRepository;

class AuthServiceTest {
	private static final String FILE_NAME_TEST = "users_test.txt";
	private AuthService authService;
	private UserRepository userRepository;

	@Test
	void shouldRegisterAndLoginUser() {
		Assertions.assertTrue(authService.register("marcin", "123qweasd"));
		Assertions.assertTrue(authService.login("marcin", "123qweasd"));
	}

	@Test
	void shouldNotRegisterDuplicateLogin() {
		Assertions.assertTrue(authService.register("adam", "1111"));
		Assertions.assertFalse(authService.register("adam", "2222"));
	}

	@Test
	void shouldFailLoginWithWrongPassword() {
		authService.register("kasia", "haslo");
		Assertions.assertFalse(authService.login("kasia", "zlehaslo"));
	}

	@Test
	void shouldFailLoginForNonExistingUser() {
		Assertions.assertFalse(authService.login("ghost", "1234"));
	}

	@Test
	void shouldNotAllowEmptyLogin() {
		Assertions.assertFalse(authService.register("", "pass"));
	}
}