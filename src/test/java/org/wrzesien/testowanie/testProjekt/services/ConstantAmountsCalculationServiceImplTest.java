package org.wrzesien.testowanie.testProjekt.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.Rate;
import org.wrzesien.testowanie.testProjekt.model.RateAmounts;

import java.math.BigDecimal;

class ConstantAmountsCalculationServiceImplTest {

	private ConstantAmountsCalculationService constantAmountsCalculationService;

	@BeforeEach
	public void setup() {
		constantAmountsCalculationService = new ConstantAmountsCalculationServiceImpl();
	}

	@Test
	@DisplayName("Calculate rate amounts for first rate")
	void shouldCalculateFirstRateAmountsCorrectly() {
		// given
		final InputData inputData = TestData.someInputData();
		final RateAmounts expected = TestData.someRateAmounts();

		// when
		final RateAmounts result = constantAmountsCalculationService.calculate(inputData, null);

		// then
		Assertions.assertEquals(expected, result);
	}

	@Test
	@DisplayName("Calculate rate amounts for other rates")
	void shouldCalculateOtherRateAmountsCorrectly() {
		// given
		final InputData inputData = TestData.someInputData();
		final Rate rate = TestData.someRate();
		final RateAmounts expected = TestData.someRateAmounts()
				.withRateAmount(new BigDecimal("3303.45"))
				.withInterestAmount(new BigDecimal("2483.87"))
				.withCapitalAmount(new BigDecimal("819.58"));

		// when
		final RateAmounts result = constantAmountsCalculationService.calculate(inputData, null, rate);

		// then
		Assertions.assertEquals(expected, result);
	}
}