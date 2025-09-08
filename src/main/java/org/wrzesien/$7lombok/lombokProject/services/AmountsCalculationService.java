package org.wrzesien.$7lombok.lombokProject.services;

import org.wrzesien.$7lombok.lombokProject.model.InputData;
import org.wrzesien.$7lombok.lombokProject.model.Overpayment;
import org.wrzesien.$7lombok.lombokProject.model.Rate;
import org.wrzesien.$7lombok.lombokProject.model.RateAmounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface AmountsCalculationService {

	BigDecimal YEAR = BigDecimal.valueOf(12);

	static BigDecimal calculateInterestAmount(final BigDecimal residualAmount, final BigDecimal interestPercentValue) {
		return residualAmount.multiply(interestPercentValue).divide(YEAR, 2, RoundingMode.HALF_UP);
	}

	static BigDecimal calculateQ(final BigDecimal interestPercent) {
		return interestPercent.divide(YEAR, 10, RoundingMode.HALF_UP).add(BigDecimal.ONE);
	}

	static BigDecimal compareCapitalWithResidual(final BigDecimal capitalAmount, final BigDecimal residualAmount) {
		if (capitalAmount.compareTo(residualAmount) >= 0) {
			return residualAmount;
		}
		return capitalAmount;
	}

	RateAmounts calculate(final InputData inputData, final Overpayment overpayment);

	RateAmounts calculate(final InputData inputData, final Overpayment overpayment, final Rate previousRate);
}
