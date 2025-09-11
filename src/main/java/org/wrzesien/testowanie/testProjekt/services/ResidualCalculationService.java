package org.wrzesien.testowanie.testProjekt.services;

import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.MortgageResidual;
import org.wrzesien.testowanie.testProjekt.model.Rate;
import org.wrzesien.testowanie.testProjekt.model.RateAmounts;

public interface ResidualCalculationService {

	MortgageResidual calculate(RateAmounts rateAmounts, InputData inputData);

	MortgageResidual calculate(RateAmounts rateAmounts, final InputData inputData, Rate previousRate);
}
