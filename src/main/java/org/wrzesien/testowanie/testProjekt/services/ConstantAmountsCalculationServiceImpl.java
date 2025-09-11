package org.wrzesien.testowanie.testProjekt.services;

import lombok.extern.slf4j.Slf4j;
import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.Overpayment;
import org.wrzesien.testowanie.testProjekt.model.Rate;
import org.wrzesien.testowanie.testProjekt.model.RateAmounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
public class ConstantAmountsCalculationServiceImpl implements ConstantAmountsCalculationService {

	@Override
	public RateAmounts calculate(final InputData inputData, final Overpayment overpayment) {
		final BigDecimal interestPercent = inputData.getInterestPercent();
		log.debug("InterestPercent: [{}]", interestPercent);
		final BigDecimal q = AmountsCalculationService.calculateQ(interestPercent);
		log.trace("Q: [{}]", q);

		final BigDecimal residualAmount = inputData.getAmount();
		log.info("ResidualAmount: [{}]", residualAmount);

		final BigDecimal interestAmount = AmountsCalculationService.calculateInterestAmount(residualAmount, interestPercent);
		log.info("InterestAmount: [{}]", interestAmount);
		final BigDecimal rateAmount = calculateConstantRateAmount(q, interestAmount, residualAmount, inputData.getAmount(), inputData.getMonthsDuration());
		log.info("RateAmount: [{}]", rateAmount);
		final BigDecimal capitalAmount = AmountsCalculationService.compareCapitalWithResidual(rateAmount.subtract(interestAmount), residualAmount);
		log.info("CapitalAmount: [{}]", capitalAmount);

		return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
	}

	@Override
	public RateAmounts calculate(final InputData inputData, final Overpayment overpayment, final Rate previousRate) {
		final BigDecimal interestPercent = inputData.getInterestPercent();
		log.debug("InterestPercent: [{}]", interestPercent);
		final BigDecimal q = AmountsCalculationService.calculateQ(interestPercent);
		log.trace("Q: [{}]", q);

		final BigDecimal residualAmount = previousRate.mortgageResidual().residualAmount();
		log.info("ResidualAmount: [{}]", residualAmount);
		final BigDecimal referenceAmount = previousRate.mortgageReference().referenceAmount();
		log.info("ReferenceAmount: [{}]", referenceAmount);
		final BigDecimal referenceDuration = previousRate.mortgageReference().referenceDuration();
		log.info("ReferenceDuration: [{}]", referenceDuration);

		final BigDecimal interestAmount = AmountsCalculationService.calculateInterestAmount(residualAmount, interestPercent);
		log.info("InterestAmount: [{}]", interestAmount);
		final BigDecimal rateAmount = calculateConstantRateAmount(q, interestAmount, residualAmount, referenceAmount, referenceDuration);
		log.info("RateAmount: [{}]", rateAmount);
		final BigDecimal capitalAmount = AmountsCalculationService.compareCapitalWithResidual(rateAmount.subtract(interestAmount), residualAmount);
		log.info("CapitalAmount: [{}]", capitalAmount);

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

		log.info("RateAmount: [{}]", rateAmount);
		return compareRateWithResidual(rateAmount, interestAmount, residualAmount);
	}

	private BigDecimal compareRateWithResidual(final BigDecimal rateAmount, final BigDecimal interestAmount, final BigDecimal residualAmount) {
		if (rateAmount.subtract(interestAmount).compareTo(residualAmount) >= 0) {
			return residualAmount.add(interestAmount);
		}
		return rateAmount;
	}
}
