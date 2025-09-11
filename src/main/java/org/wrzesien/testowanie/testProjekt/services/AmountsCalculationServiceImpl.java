package org.wrzesien.testowanie.testProjekt.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.Overpayment;
import org.wrzesien.testowanie.testProjekt.model.Rate;
import org.wrzesien.testowanie.testProjekt.model.RateAmounts;

@Slf4j
@RequiredArgsConstructor
public class AmountsCalculationServiceImpl implements AmountsCalculationService {

	private final ConstantAmountsCalculationService constantAmountsCalculationService;

	private final DecreasingAmountsCalculationService decreasingAmountsCalculationService;

	@Override
	public RateAmounts calculate(final InputData inputData, final Overpayment overpayment) {
		switch (inputData.getRateType()) {
			case CONSTANT:
				return constantAmountsCalculationService.calculate(inputData, overpayment);
			case DECREASING:
				return decreasingAmountsCalculationService.calculate(inputData, overpayment);
			default:
				log.error("Case not handled: [{}]", inputData.getRateType());
				throw new MortgageException("Case not handled");
		}
	}

	@Override
	public RateAmounts calculate(final InputData inputData, final Overpayment overpayment, final Rate previousRate) {
		switch (inputData.getRateType()) {
			case CONSTANT:
				return constantAmountsCalculationService.calculate(inputData, overpayment, previousRate);
			case DECREASING:
				return decreasingAmountsCalculationService.calculate(inputData, overpayment, previousRate);
			default:
				log.error("Case not handled: [{}]", inputData.getRateType());
				throw new MortgageException("Case not handled");
		}
	}
}
