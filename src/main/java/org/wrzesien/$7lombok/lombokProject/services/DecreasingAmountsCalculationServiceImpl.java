package org.wrzesien.$7lombok.lombokProject.services;

import org.wrzesien.$7lombok.lombokProject.model.InputData;
import org.wrzesien.$7lombok.lombokProject.model.Overpayment;
import org.wrzesien.$7lombok.lombokProject.model.Rate;
import org.wrzesien.$7lombok.lombokProject.model.RateAmounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecreasingAmountsCalculationServiceImpl implements DecreasingAmountsCalculationService {

	@Override
	public RateAmounts calculate(final InputData inputData, final Overpayment overpayment) {
		final BigDecimal interestPercent = inputData.getInterestPercent();

		final BigDecimal residualAmount = inputData.getAmount();
		final BigDecimal residualDuration = inputData.getMonthsDuration();

		final BigDecimal interestAmount = AmountsCalculationService.calculateInterestAmount(residualAmount, interestPercent);
		final BigDecimal capitalAmount = AmountsCalculationService.compareCapitalWithResidual(
				calculateDecreasingCapitalAmount(residualAmount, residualDuration), residualAmount);
		final BigDecimal rateAmount = capitalAmount.add(interestAmount);

		return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
	}

	@Override
	public RateAmounts calculate(final InputData inputData, final Overpayment overpayment, final Rate previousRate) {
		final BigDecimal interestPercent = inputData.getInterestPercent();

		final BigDecimal residualAmount = previousRate.mortgageResidual().residualAmount();
		final BigDecimal referenceAmount = previousRate.mortgageReference().referenceAmount();
		final BigDecimal referenceDuration = previousRate.mortgageReference().referenceDuration();

		final BigDecimal interestAmount = AmountsCalculationService.calculateInterestAmount(residualAmount, interestPercent);
		final BigDecimal capitalAmount = AmountsCalculationService.compareCapitalWithResidual(
				calculateDecreasingCapitalAmount(referenceAmount, referenceDuration), residualAmount);
		final BigDecimal rateAmount = capitalAmount.add(interestAmount);

		return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
	}

	private BigDecimal calculateDecreasingCapitalAmount(final BigDecimal residualAmount, final BigDecimal residualDuration) {
		return residualAmount.divide(residualDuration, 2, RoundingMode.HALF_UP);
	}
}
