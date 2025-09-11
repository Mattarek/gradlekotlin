package org.wrzesien.testowanie.testProjekt.services;

import lombok.extern.slf4j.Slf4j;
import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.Overpayment;
import org.wrzesien.testowanie.testProjekt.model.Rate;
import org.wrzesien.testowanie.testProjekt.model.RateAmounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
public class DecreasingAmountsCalculationServiceImpl implements DecreasingAmountsCalculationService {

	@Override
	public RateAmounts calculate(final InputData inputData, final Overpayment overpayment) {
		final BigDecimal interestPercent = inputData.getInterestPercent();
		log.info("InterestPercent: [{}]", interestPercent);

		final BigDecimal residualAmount = inputData.getAmount();
		log.info("ResidualAmount: [{}]", residualAmount);
		final BigDecimal residualDuration = inputData.getMonthsDuration();
		log.info("ResidualDuration: [{}]", residualDuration);

		final BigDecimal interestAmount = AmountsCalculationService.calculateInterestAmount(residualAmount, interestPercent);
		log.info("InterestAmount: [{}]", interestAmount);
		final BigDecimal capitalAmount = AmountsCalculationService.compareCapitalWithResidual(calculateDecreasingCapitalAmount(residualAmount, residualDuration), residualAmount);
		log.info("CapitalAmount: [{}]", capitalAmount);
		final BigDecimal rateAmount = capitalAmount.add(interestAmount);
		log.info("RateAmount: [{}]", rateAmount);

		return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
	}

	@Override
	public RateAmounts calculate(final InputData inputData, final Overpayment overpayment, final Rate previousRate) {
		final BigDecimal interestPercent = inputData.getInterestPercent();
		log.info("InterestPercent: [{}]", interestPercent);

		final BigDecimal residualAmount = previousRate.mortgageResidual().residualAmount();
		log.info("ResidualAmount: [{}]", residualAmount);
		final BigDecimal referenceAmount = previousRate.mortgageReference().referenceAmount();
		log.info("ReferenceAmount: [{}]", referenceAmount);
		final BigDecimal referenceDuration = previousRate.mortgageReference().referenceDuration();
		log.info("ReferenceDuration: [{}]", referenceDuration);

		final BigDecimal interestAmount = AmountsCalculationService.calculateInterestAmount(residualAmount, interestPercent);
		log.info("InterestAmount: [{}]", interestAmount);
		final BigDecimal capitalAmount = AmountsCalculationService.compareCapitalWithResidual(calculateDecreasingCapitalAmount(referenceAmount, referenceDuration), residualAmount);
		log.info("CapitalAmount: [{}]", capitalAmount);
		final BigDecimal rateAmount = capitalAmount.add(interestAmount);
		log.info("RateAmount: [{}]", rateAmount);

		return new RateAmounts(rateAmount, interestAmount, capitalAmount, overpayment);
	}

	private BigDecimal calculateDecreasingCapitalAmount(final BigDecimal residualAmount, final BigDecimal residualDuration) {
		return residualAmount.divide(residualDuration, 2, RoundingMode.HALF_UP);
	}
}
