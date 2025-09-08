package org.wrzesien.$7lombok.lombokProject.services;

import org.wrzesien.$7lombok.lombokProject.model.Rate;
import org.wrzesien.$7lombok.lombokProject.model.RateAmounts;
import org.wrzesien.$7lombok.lombokProject.model.Summary;

import java.math.BigDecimal;
import java.util.List;

public class SummaryServiceFactory {

	public static SummaryService create() {
		return rates -> {
			final BigDecimal interestSum = calculate(rates, rate -> rate.rateAmounts().interestAmount());
			final BigDecimal overpaymentProvisionSum = calculate(rates,
					rate -> rate.rateAmounts().overpayment().provisionAmount());
			final BigDecimal totalLostSum = interestSum.add(overpaymentProvisionSum);
			final BigDecimal totalCapital = calculate(rates, rate -> totalCapital(rate.rateAmounts()));
			return new Summary(interestSum, overpaymentProvisionSum, totalLostSum, totalCapital);
		};
	}

	private static BigDecimal totalCapital(final RateAmounts rateAmounts) {
		return rateAmounts.capitalAmount().add(rateAmounts.overpayment().amount());
	}

	private static BigDecimal calculate(final List<Rate> rates, final Function function) {
		BigDecimal sum = BigDecimal.ZERO;

		for (final Rate rate : rates) {
			sum = sum.add(function.calculate(rate));
		}
		return sum;
	}
}
