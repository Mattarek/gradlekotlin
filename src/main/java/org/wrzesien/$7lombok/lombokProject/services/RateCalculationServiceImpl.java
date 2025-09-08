package org.wrzesien.$7lombok.lombokProject.services;

import lombok.RequiredArgsConstructor;
import org.wrzesien.$7lombok.lombokProject.model.InputData;
import org.wrzesien.$7lombok.lombokProject.model.MortgageReference;
import org.wrzesien.$7lombok.lombokProject.model.MortgageResidual;
import org.wrzesien.$7lombok.lombokProject.model.Overpayment;
import org.wrzesien.$7lombok.lombokProject.model.Rate;
import org.wrzesien.$7lombok.lombokProject.model.RateAmounts;
import org.wrzesien.$7lombok.lombokProject.model.TimePoint;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class RateCalculationServiceImpl implements RateCalculationService {
	private final TimePointCalculationService timePointCalculationService;
	private final OverpaymentCalculationService overpaymentCalculationService;
	private final AmountsCalculationService amountsCalculationService;
	private final ResidualCalculationService residualCalculationService;
	private final ReferenceCalculationService referenceCalculationService;

	@Override
	public List<Rate> calculate(final InputData inputData) {
		final List<Rate> rateList = new ArrayList<>();

		final BigDecimal rateNumber = BigDecimal.ONE;

		final Rate zeroRate = calculateZeroRate(rateNumber, inputData);

		Rate previousRate = zeroRate;
		rateList.add(zeroRate);

		for (BigDecimal i = rateNumber.add(BigDecimal.ONE); i.compareTo(inputData.getMonthsDuration()) <= 0; i = i.add(BigDecimal.ONE)) {
			final Rate nextRate = calculateNextRate(i, inputData, previousRate);
			previousRate = nextRate;
			rateList.add(nextRate);

			if (BigDecimal.ZERO.equals(nextRate.mortgageReference().referenceAmount().setScale(0, RoundingMode.HALF_UP))) {
				break;
			}
		}

		return rateList;
	}

	private Rate calculateZeroRate(final BigDecimal rateNumber, final InputData inputData) {
		final TimePoint timePoint = timePointCalculationService.calculate(rateNumber, inputData);
		final Overpayment overpayment = overpaymentCalculationService.calculate(rateNumber, inputData);
		final RateAmounts rateAmounts = amountsCalculationService.calculate(inputData, overpayment);
		final MortgageResidual mortgageResidual = residualCalculationService.calculate(rateAmounts, inputData);
		final MortgageReference mortgageReference = referenceCalculationService.calculate(rateAmounts, inputData);

		return new Rate(rateNumber, timePoint, rateAmounts, mortgageResidual, mortgageReference);
	}

	private Rate calculateNextRate(final BigDecimal rateNumber, final InputData inputData, final Rate previousRate) {
		final TimePoint timepoint = timePointCalculationService.calculate(rateNumber, previousRate);
		final Overpayment overpayment = overpaymentCalculationService.calculate(rateNumber, inputData);
		final RateAmounts rateAmounts = amountsCalculationService.calculate(inputData, overpayment, previousRate);
		final MortgageResidual mortgageResidual = residualCalculationService.calculate(rateAmounts, inputData, previousRate);
		final MortgageReference mortgageReference = referenceCalculationService.calculate(rateAmounts, inputData, previousRate);

		return new Rate(rateNumber, timepoint, rateAmounts, mortgageResidual, mortgageReference);
	}
}
