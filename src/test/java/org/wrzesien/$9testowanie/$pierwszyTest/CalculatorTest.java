package org.wrzesien.$9testowanie.$pierwszyTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {
	Calculator calculator;
	//
	//	@BeforeAll
	//	static void beforeAll() {
	//		System.out.println("Before All!");
	//	}
	//
	//	@AfterAll
	//	static void afterAll() {
	//		System.out.println("After All!");
	//	}
	//
	//	@BeforeEach
	//	void beforeEach() {
	//		System.out.println("Before each!");
	//	}
	//
	//	@AfterEach
	//	void afterEach() {
	//		System.out.println("After each!");
	//	}

	@SuppressWarnings("unused")
	static int[][] testData() {
		return new int[][]{
				{5, 2, 3},
				{8, 3, 5},
				{9, 2, 7}
		};
	}

	@ParameterizedTest
	@MethodSource("testData")
	void testCalculator(final int[] testData) {
		calculator = new Calculator();

		Assertions.assertEquals(testData[0], calculator.add(testData[1], testData[2]));
	}

	@Test
	@DisplayName("Testing method with tests adding behaviour.")
	void testAdd() {
		calculator = new Calculator();
		// given
		final int left = 5;
		final int right = 7;
		final int expcted = 12;

		// when
		final Integer result = calculator.add(left, right);

		// then
		Assertions.assertEquals(expcted, result);
	}

	@Test
	@DisplayName("Testing method with tests subtracting behaviour.")
	void testSubtract() {
		// given
		calculator = new Calculator();
		final int left = 5;
		final int right = 7;
		final int expcted = -2;

		// when
		final Integer result = calculator.subtract(left, right);

		// then
		Assertions.assertEquals(expcted, result);
	}

	@Test
	@DisplayName("Testing method with tests multiplying behaviour.")
	void testMultiply() {
		// given
		calculator = new Calculator();
		final int left = 2;
		final int right = 2;
		final int expcted = 4;

		// when
		final Integer result = calculator.multiply(left, right);

		// then
		Assertions.assertEquals(expcted, result);
	}

	@Test
	@Disabled("Explenation why this test is disable!")
	void assertionsTest() {
		Assertions.assertAll(
				() -> Assertions.assertEquals("Test1", "Test1", () -> "my custom message 1"),
				() -> Assertions.assertEquals("Test1", "test2", () -> "my custom message 2"),
				() -> Assertions.assertEquals("Test1", "test3", () -> "my custom message 3")
		);
	}

	@Test
	void testCalculator() {
		final int left = 5;
		final int right = 7;
		final int expected = 12;
	}

	@Test
	@DisplayName("Testing method with tests dividing behaviour.")
	void testDivide() {
		// given
		calculator = new Calculator();
		final int left = 6;
		final int right = 3;
		final int expcted = 2;

		// when
		final Integer result = calculator.divide(left, right);

		// then
		Assertions.assertEquals(expcted, result);
	}
}