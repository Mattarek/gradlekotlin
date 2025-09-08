package org.wrzesien.$7lombok.lombokProject.services;

import org.wrzesien.$7lombok.lombokProject.model.InputData;
import org.wrzesien.$7lombok.lombokProject.model.Overpayment;
import org.wrzesien.$7lombok.lombokProject.model.Rate;
import org.wrzesien.$7lombok.lombokProject.model.RateAmounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConstantAmountsCalculationServiceImpl implements ConstantAmountsCalculationService {

	@Override
	public RateAmounts calculate(final InputData inputData, final Overpayment overpayment) {
		final BigDecimal interestPercent = inputData.getInterestPercent();
		final BigDecimal q = AmountsCalculationService.calculateQ(interestPercent);

		final BigDecimal residualAmount = inputData.getAmount();

		final BigDecimal interestAmount = AmountsCalculationService.calculateInterestAmount(residualAmount, interestPercent);
		final BigDecimal rateAmount = calculateConstantRateAmount(q, interestAmount, residualAmount, inputData.getAmount(), inputData.getMonthsDuration());
		final BigDecimal capitalAmount = AmountsCalculationService.compareCapitalWithResidual(rateAmount.subtract(interestAmount), residualAmount);

		return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
	}

	@Override
	public RateAmounts calculate(final InputData inputData, final Overpayment overpayment, final Rate previousRate) {
		final BigDecimal interestPercent = inputData.getInterestPercent();
		final BigDecimal q = AmountsCalculationService.calculateQ(interestPercent);

		final BigDecimal residualAmount = previousRate.mortgageResidual().residualAmount();
		final BigDecimal referenceAmount = previousRate.mortgageReference().referenceAmount();
		final BigDecimal referenceDuration = previousRate.mortgageReference().referenceDuration();

		final BigDecimal interestAmount = AmountsCalculationService.calculateInterestAmount(residualAmount, interestPercent);
		final BigDecimal rateAmount = calculateConstantRateAmount(q, interestAmount, residualAmount, referenceAmount, referenceDuration);
		final BigDecimal capitalAmount = AmountsCalculationService.compareCapitalWithResidual(rateAmount.subtract(interestAmount), residualAmount);

		return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
	}

	private BigDecimal calculateConstantRateAmount(
			final BigDecimal q,
			final BigDecimal interestAmount,
			final BigDecimal residualAmount,
			final BigDecimal referenceAmount,
			final BigDecimal referenceDuration
	) {
		final BigDecimal rateAmount = referenceAmount
				.multiply(q.pow(referenceDuration.intValue()))
				.multiply(q.subtract(BigDecimal.ONE))
				.divide(q.pow(referenceDuration.intValue()).subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);

		return compareRateWithResidual(rateAmount, interestAmount, residualAmount);
	}

	private BigDecimal compareRateWithResidual(final BigDecimal rateAmount, final BigDecimal interestAmount, final BigDecimal residualAmount) {
		if (rateAmount.subtract(interestAmount).compareTo(residualAmount) >= 0) {
			return residualAmount.add(interestAmount);
		}
		return rateAmount;
	}
}
