package org.wrzesien.testowanie.pierwszyTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator(); // inicjalizacja przed każdym testem
	}

	@Test
	@DisplayName("Dodawanie dwóch liczb")
	void testAdd() {
		assertEquals(5, calculator.add(2, 3));
		assertEquals(0, calculator.add(-2, 2));
		assertEquals(-7, calculator.add(-3, -4));
	}

/*	@Test
	@DisplayName("Odejmowanie dwóch liczb")
	void testSubtract() {
		assertEquals(1, calculator.subtract(3, 2));
		assertEquals(-5, calculator.subtract(-3, 2));
		assertEquals(7, calculator.subtract(3, -4));
	}

	@Test
	@DisplayName("Mnożenie dwóch liczb")
	void testMultiply() {
		assertEquals(6, calculator.multiply(2, 3));
		assertEquals(-6, calculator.multiply(-2, 3));
		assertEquals(12, calculator.multiply(-3, -4));
		assertEquals(0, calculator.multiply(0, 5));
	}

	@Test
	@DisplayName("Dzielenie dwóch liczb")
	void testDivide() {
		assertEquals(2, calculator.divide(6, 3));
		assertEquals(-2, calculator.divide(-6, 3));
		assertEquals(3, calculator.divide(-9, -3));
	}

	@Test
	@DisplayName("Dzielenie przez zero powinno rzucać wyjątek")
	void testDivideByZero() {
		assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
	}*/

	//	Calculator calculator;
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
	//	@SuppressWarnings("unused")
	//	static int[][] testData() {
	//		return new int[][]{
	//				{5, 2, 3},
	//				{8, 3, 5},
	//				{9, 2, 7}
	//		};
	//	}
	//
	//	@Test
	//	void testAddD() {
	//		// givne
	//		final int left = 5;
	//		final int right = 7;
	//		final int expected = 12;
	//
	//		final int result = right + left;
	//
	//		// when
	//		Assertions.assertEquals(expected, result);
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
	//
	//	@ParameterizedTest
	//	@MethodSource("testData")
	//	void testCalculator(final int[] testData) {
	//		calculator = new Calculator();
	//
	//		Assertions.assertEquals(testData[0], calculator.add(testData[1], testData[2]));
	//	}
	//
	//	@Test
	//	@DisplayName("Testing method with tests adding behaviour.")
	//	void testAdd() {
	//		calculator = new Calculator();
	//		// given
	//		final int left = 5;
	//		final int right = 7;
	//		final int expcted = 12;
	//
	//		// when
	//		final Integer result = calculator.add(left, right);
	//
	//		// then
	//		Assertions.assertEquals(expcted, result);
	//	}
	//
	//	@Test
	//	@DisplayName("Testing method with tests subtracting behaviour.")
	//	void testSubtract() {
	//		// given
	//		calculator = new Calculator();
	//		final int left = 5;
	//		final int right = 7;
	//		final int expcted = -2;
	//
	//		// when
	//		final Integer result = calculator.subtract(left, right);
	//
	//		// then
	//		Assertions.assertEquals(expcted, result);
	//	}
	//
	//	@Test
	//	@DisplayName("Testing method with tests multiplying behaviour.")
	//	void testMultiply() {
	//		// given
	//		calculator = new Calculator();
	//		final int left = 2;
	//		final int right = 2;
	//		final int expcted = 4;
	//
	//		// when
	//		final Integer result = calculator.multiply(left, right);
	//
	//		// then
	//		Assertions.assertEquals(expcted, result);
	//	}
	//
	//	@Test
	//	@Disabled("Explenation why this test is disable!")
	//	void assertionsTest() {
	//		Assertions.assertAll(
	//				() -> Assertions.assertEquals("Test1", "Test1", () -> "my custom message 1"),
	//				() -> Assertions.assertEquals("Test1", "test2", () -> "my custom message 2"),
	//				() -> Assertions.assertEquals("Test1", "test3", () -> "my custom message 3")
	//		);
	//	}
	//
	//	@Test
	//	void testCalculator() {
	//		final int left = 5;
	//		final int right = 7;
	//		final int expected = 12;
	//	}
	//
	//	@Test
	//	@DisplayName("Testing method with tests dividing behaviour.")
	//	void testDivide() {
	//		// given
	//		calculator = new Calculator();
	//		final int left = 6;
	//		final int right = 3;
	//		final int expcted = 2;
	//
	//		// when
	//		final Integer result = calculator.divide(left, right);
	//
	//		// then
	//		Assertions.assertEquals(expcted, result);
	//	}
}