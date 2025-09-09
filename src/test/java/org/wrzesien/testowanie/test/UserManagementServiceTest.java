package org.wrzesien.testowanie.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class UserManagementServiceTest {

	private UserManagementService userManagementService;

	private static User someUser() {
		return User.builder()
				.name("name")
				.surname("surname")
				.email("email@gmail.com")
				.build();
	}

	@BeforeEach
	void init() {
		userManagementService = new UserManagementService();
	}

	@Test
	void shouldCreateUserCorrectly() {
		// given
		final var user = someUser();

		// when
		userManagementService.create(user);

		final var result = userManagementService.findByEmail(user.getEmail());

		// then
		Assertions.assertTrue(result.isPresent());
		Assertions.assertEquals(user, result.get());
	}

	@Test
	void shouldCreateMultipleUsersCorrectly() {
		// given
		final var user1 = someUser().withEmail("email1@gmail.com");
		final var user2 = someUser().withEmail("email2@gmail.com");
		final var user3 = someUser().withEmail("email3@gmail.com");

		// when
		userManagementService.create(user1);
		userManagementService.create(user2);
		userManagementService.create(user3);

		final var result1 = userManagementService.findByEmail(user1.getEmail());
		final var result2 = userManagementService.findByEmail(user2.getEmail());
		final var result3 = userManagementService.findByEmail(user3.getEmail());
		final var all = userManagementService.findAll();

		// then
		Assertions.assertEquals(3, all.size());
		Assertions.assertTrue(result1.isPresent());
		Assertions.assertEquals(user1, result1.get());
		Assertions.assertTrue(result2.isPresent());
		Assertions.assertEquals(user2, result2.get());
		Assertions.assertTrue(result3.isPresent());
		Assertions.assertEquals(user3, result3.get());
	}

	@Test
	void shouldFailWhenDuplicatedUserIsCreated() {
		// given
		final var user1 = someUser();
		final var user2 = someUser();

		// when, then
		userManagementService.create(user1);
		final Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> userManagementService.create(user2));
		Assertions.assertEquals(String.format("User with email: [%s] is already created", user1.getEmail()), exception.getMessage());
	}

	@Test
	void shouldFindUsersWithName() {
		// given
		final var user1 = someUser().withEmail("email1@gmail.com");
		final var user2 = someUser().withEmail("email2@gmail.com");
		final var user3 = someUser().withName("newName").withEmail("email3@gmail.com");

		// when
		userManagementService.create(user1);
		userManagementService.create(user2);
		userManagementService.create(user3);

		final var result1 = userManagementService.findByName(user1.getName());
		final var result2 = userManagementService.findByName(user2.getName());
		final var result3 = userManagementService.findByName(user3.getName());
		final var all = userManagementService.findAll();

		// then
		Assertions.assertEquals(3, all.size());
		Assertions.assertEquals(
				Stream.of(user1, user2).sorted().collect(Collectors.toList()),
				result1.stream().sorted().collect(Collectors.toList())
		);
		Assertions.assertEquals(
				Stream.of(user1, user2).sorted().collect(Collectors.toList()),
				result2.stream().sorted().collect(Collectors.toList())
		);
		Assertions.assertEquals(List.of(user3), result3);
	}

	@Test
	void shouldModifyUserDataCorrectly() {
		// given
		final var user1 = someUser().withEmail("email1@gmail.com");
		final var user2 = someUser().withEmail("email2@gmail.com");
		final var user3 = someUser().withEmail("email3@gmail.com");
		final String newEmail = "newEmail@gmail.com";

		// when
		userManagementService.create(user1);
		userManagementService.create(user2);
		userManagementService.create(user3);

		final var all = userManagementService.findAll();
		Assertions.assertEquals(3, all.size());

		final var result1 = userManagementService.findByEmail(user1.getEmail());
		userManagementService.update(user1.getEmail(), user1.withEmail(newEmail));
		final var result2 = userManagementService.findByEmail(user1.getEmail());
		final var result3 = userManagementService.findByEmail(newEmail);
		final var allAgain = userManagementService.findAll();

		// then
		Assertions.assertEquals(3, allAgain.size());
		Assertions.assertTrue(result1.isPresent());
		Assertions.assertEquals(user1, result1.get());
		Assertions.assertTrue(result2.isEmpty());
		Assertions.assertTrue(result3.isPresent());
		Assertions.assertEquals(user1.withEmail(newEmail), result3.get());
	}

	@Test
	void shouldThrowWhenModifyingNonExistingUser() {
		// given
		final var user1 = someUser();
		final String newEmail = "email1@gmail.com";

		// when, then
		final Throwable exception = Assertions.assertThrows(RuntimeException.class,
				() -> userManagementService.update(user1.getEmail(), user1.withEmail(newEmail)));
		Assertions.assertEquals(String.format("User with email: [%s] doesn't exist", user1.getEmail()), exception.getMessage());
	}

	@Test
	void shouldDeleteUserCorrectly() {
		// given
		final var user1 = someUser().withEmail("email1@gmail.com");
		final var user2 = someUser().withEmail("email2@gmail.com");
		final var user3 = someUser().withEmail("email3@gmail.com");

		// when
		userManagementService.create(user1);
		userManagementService.create(user2);
		userManagementService.create(user3);

		final var all = userManagementService.findAll();
		Assertions.assertEquals(3, all.size());

		userManagementService.delete(user1.getEmail());

		final var result1 = userManagementService.findByEmail(user1.getEmail());
		final var result2 = userManagementService.findByEmail(user2.getEmail());
		final var result3 = userManagementService.findByEmail(user3.getEmail());
		final var allAgain = userManagementService.findAll();

		// then
		Assertions.assertEquals(2, allAgain.size());
		Assertions.assertTrue(result1.isEmpty());
		Assertions.assertTrue(result2.isPresent());
		Assertions.assertEquals(user2, result2.get());
		Assertions.assertTrue(result3.isPresent());
		Assertions.assertEquals(user3, result3.get());
	}

	@Test
	void shouldThrowWhenDeletingNonExistingUser() {
		// given
		final var user1 = someUser().withEmail("email1@gmail.com");

		// when, then
		final Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> userManagementService.delete(user1.getEmail()));
		Assertions.assertEquals(String.format("User with email: [%s] doesn't exist", user1.getEmail()), exception.getMessage());
	}
}