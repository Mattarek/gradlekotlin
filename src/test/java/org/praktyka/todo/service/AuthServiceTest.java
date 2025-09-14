package org.praktyka.todo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.praktyka.todo.model.User;
import org.praktyka.todo.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

class AuthServiceTest {

	private FileService fileServiceMock;
	private UserRepository userRepository;
	private AuthService authService;

	@BeforeEach
	void setUp() {
		fileServiceMock = mock(FileService.class);
		userRepository = new UserRepository("users_test.txt", fileServiceMock);
		authService = new AuthService(userRepository);
	}

	@Test
	void shouldRegisterAndLoginUser() {
		when(fileServiceMock.load(anyString())).thenReturn(new ArrayList<>());

		assertTrue(authService.register("marcin", "123qweasd"));

		when(fileServiceMock.load(anyString()))
				.thenReturn(List.of(new User("marcin", "123qweasd")));

		assertTrue(authService.login("marcin", "123qweasd"));

		verify(fileServiceMock, atLeastOnce()).load(anyString());
		verify(fileServiceMock, atLeastOnce()).save(anyString(), anyList());
	}

	@Test
	void shouldNotRegisterDuplicateLogin() {
		when(fileServiceMock.load(anyString())).thenReturn(new ArrayList<>());
		assertTrue(authService.register("adam", "1111"));

		// Symulujemy, że load zwraca już istniejącego usera
		when(fileServiceMock.load(anyString())).thenReturn(List.of(new User("adam", "1111")));
		assertFalse(authService.register("adam", "2222"));
	}

	@Test
	void shouldFailLoginWithWrongPassword() {
		when(fileServiceMock.load(anyString()))
				.thenReturn(List.of(new User("kasia", "haslo")));
		assertFalse(authService.login("kasia", "zlehaslo"));
	}

	@Test
	void shouldFailLoginForNonExistingUser() {
		when(fileServiceMock.load(anyString())).thenReturn(new ArrayList<>());
		assertFalse(authService.login("ghost", "1234"));
	}

	@Test
	void shouldNotAllowEmptyLogin() {
		assertFalse(authService.register("", "pass"));
	}
}