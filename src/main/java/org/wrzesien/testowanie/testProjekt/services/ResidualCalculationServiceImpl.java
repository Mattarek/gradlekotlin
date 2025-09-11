package org.wrzesien.testowanie.testProjekt.services;

import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.MortgageResidual;
import org.wrzesien.testowanie.testProjekt.model.Rate;
import org.wrzesien.testowanie.testProjekt.model.RateAmounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ResidualCalculationServiceImpl implements ResidualCalculationService {

	@Override
	public MortgageResidual calculate(final RateAmounts rateAmounts, final InputData inputData) {
		if (BigDecimal.ZERO.equals(inputData.getAmount())) {
			return new MortgageResidual(BigDecimal.ZERO, BigDecimal.ZERO);
		}
		final BigDecimal residualAmount = calculateResidualAmount(inputData.getAmount(), rateAmounts);
		final BigDecimal residualDuration = calculateResidualDuration(inputData, residualAmount, inputData.getMonthsDuration(), rateAmounts);
		return new MortgageResidual(residualAmount, residualDuration);
	}

	@Override
	public MortgageResidual calculate(final RateAmounts rateAmounts, final InputData inputData, final Rate previousRate) {
		final BigDecimal previousResidualAmount = previousRate.mortgageResidual().residualAmount();
		final BigDecimal previousResidualDuration = previousRate.mortgageResidual().residualDuration();

		if (BigDecimal.ZERO.equals(previousResidualAmount)) {
			return new MortgageResidual(BigDecimal.ZERO, BigDecimal.ZERO);
		}
		final BigDecimal residualAmount = calculateResidualAmount(previousResidualAmount, rateAmounts);
		final BigDecimal residualDuration = calculateResidualDuration(inputData, residualAmount, previousResidualDuration, rateAmounts);
		return new MortgageResidual(residualAmount, residualDuration);
	}

	private BigDecimal calculateResidualDuration(
			final InputData inputData,
			final BigDecimal residualAmount,
			final BigDecimal previousResidualDuration,
			final RateAmounts rateAmounts
	) {
		// jak wystąpi nadpłata to zaczynają się schody,
		// trzeba przeliczyć kredyt w zależności od tego czy podczas nadpłaty zmniejszamy czas trwania czy wysokość raty
		if (rateAmounts.overpayment().amount().compareTo(BigDecimal.ZERO) > 0) {
			switch (inputData.getRateType()) {
				case CONSTANT:
					return calculateConstantResidualDuration(inputData, residualAmount, rateAmounts);
				case DECREASING:
					return calculateDecreasingResidualDuration(residualAmount, rateAmounts);
				default:
					throw new MortgageException("Case not handled");
			}
		}
		// w każdym normalnym przypadku z miesiąca na miesiąc ilość pozostałych miesięcy jest zmniejszna o 1
		return previousResidualDuration.subtract(BigDecimal.ONE);
	}

	private BigDecimal calculateDecreasingResidualDuration(final BigDecimal residualAmount, final RateAmounts rateAmounts) {
		return residualAmount.divide(rateAmounts.capitalAmount(), 0, RoundingMode.CEILING);
	}

	@SuppressWarnings("UnnecessaryLocalVariable")
	// tutaj mamy zaszytą logikę z tego co wspomniałem w trakcie nagrań,
	// czyli jak oszacować ilość miesięcy jaka nam pozostała do spłaty przy nadpłacie, ratach stałych i zmniejszeniu czasu trwania.
	// Wyjaśnienie stosowanych wzorów zostało dostarczone w pliku z rozwiązaniem
	private BigDecimal calculateConstantResidualDuration(final InputData inputData, final BigDecimal residualAmount, final RateAmounts rateAmounts) {
		// log_y(x) = log(x) / log (y)
		final BigDecimal q = AmountsCalculationService.calculateQ(inputData.getInterestPercent());

		// licznik z naszego logarytmu z licznika wzoru końcowego
		final BigDecimal xNumerator = rateAmounts.rateAmount();
		// mianownik z naszego logarytmu z licznika wzoru końcowego. b/m to równie dobrze q-1
		final BigDecimal xDenominator = rateAmounts.rateAmount().subtract(residualAmount.multiply(q.subtract(BigDecimal.ONE)));

		final BigDecimal x = xNumerator.divide(xDenominator, 10, RoundingMode.HALF_UP);
		final BigDecimal y = q;

		// logarytm z licznika
		final BigDecimal logX = BigDecimal.valueOf(Math.log(x.doubleValue()));
		// logarytm z mianownika
		final BigDecimal logY = BigDecimal.valueOf(Math.log(y.doubleValue()));

		return logX.divide(logY, 0, RoundingMode.CEILING);
	}

	private BigDecimal calculateResidualAmount(final BigDecimal residualAmount, final RateAmounts rateAmounts) {
		return residualAmount
				.subtract(rateAmounts.capitalAmount())
				.subtract(rateAmounts.overpayment().amount())
				.max(BigDecimal.ZERO);
	}
}
