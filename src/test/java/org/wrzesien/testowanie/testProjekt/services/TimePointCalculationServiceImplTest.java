package org.wrzesien.testowanie.testProjekt.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.Rate;
import org.wrzesien.testowanie.testProjekt.model.TimePoint;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;

class TimePointCalculationServiceImplTest {

	private TimePointCalculationService timePointCalculationService;

	public static Stream<Arguments> testMortgageData() {
		return Stream.of(
				arguments(
						LocalDate.of(2010, 2, 1),
						BigDecimal.valueOf(12),
						BigDecimal.valueOf(1),
						BigDecimal.valueOf(12),
						LocalDate.of(2010, 1, 1)),
				arguments(
						LocalDate.of(2010, 2, 1),
						BigDecimal.valueOf(15),
						BigDecimal.valueOf(2),
						BigDecimal.valueOf(3),
						LocalDate.of(2010, 1, 1)),
				arguments(
						LocalDate.of(2013, 10, 1),
						BigDecimal.valueOf(76),
						BigDecimal.valueOf(7),
						BigDecimal.valueOf(4),
						LocalDate.of(2013, 9, 1))
		);
	}

	@BeforeEach
	public void setup() {
		timePointCalculationService = new TimePointCalculationServiceImpl();
	}

	@Test
	@DisplayName("Should calculate first rate time point successfully")
	void calculateTimePointForFirstRate() {
		// given
		final InputData inputData = TestData.someInputData();
		final TimePoint expected = TestData.someTimePoint();

		// when
		final TimePoint result = timePointCalculationService.calculate(BigDecimal.valueOf(1), inputData);

		// then
		Assertions.assertEquals(expected, result);
	}

	@ParameterizedTest
	@MethodSource(value = "testMortgageData")
	@DisplayName("Should calculate other rate time point than first successfully")
	void calculateTimePointForOtherRates(final LocalDate expectedDate, final BigDecimal rateNumber, final BigDecimal year, final BigDecimal month, final LocalDate date) {
		// given
		final TimePoint timePoint = TestData.someTimePoint()
				.withYear(year)
				.withMonth(month)
				.withDate(date);
		final Rate rate = TestData.someRate().withTimePoint(timePoint);
		final TimePoint expected = timePoint.withDate(expectedDate);

		// when
		final TimePoint result = timePointCalculationService.calculate(rateNumber, rate);

		// then
		Assertions.assertEquals(expected, result);
	}
}