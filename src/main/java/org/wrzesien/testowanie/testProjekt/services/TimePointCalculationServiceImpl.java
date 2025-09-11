package org.wrzesien.testowanie.testProjekt.services;

import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.Rate;
import org.wrzesien.testowanie.testProjekt.model.TimePoint;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class TimePointCalculationServiceImpl implements TimePointCalculationService {

	public TimePoint calculate(final BigDecimal rateNumber, final InputData inputData) {
		if (!BigDecimal.ONE.equals(rateNumber)) {
			throw new RuntimeException("This method only accepts rateNumber equal to ONE");
		}
		final BigDecimal year = calculateYear(rateNumber);
		final BigDecimal month = calculateMonth(rateNumber);
		final LocalDate date = inputData.getRepaymentStartDate();
		return new TimePoint(year, month, date);
	}

	public TimePoint calculate(final BigDecimal rateNumber, final Rate previousRate) {
		final BigDecimal year = calculateYear(rateNumber);
		final BigDecimal month = calculateMonth(rateNumber);
		final LocalDate date = previousRate.timePoint().date().plusMonths(1);
		return new TimePoint(year, month, date);
	}

	private BigDecimal calculateYear(final BigDecimal rateNumber) {
		return rateNumber.divide(AmountsCalculationService.YEAR, RoundingMode.UP).max(BigDecimal.ONE);
	}

	private BigDecimal calculateMonth(final BigDecimal rateNumber) {
		return BigDecimal.ZERO.equals(rateNumber.remainder(AmountsCalculationService.YEAR))
				? AmountsCalculationService.YEAR
				: rateNumber.remainder(AmountsCalculationService.YEAR);
	}
}
