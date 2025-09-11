package org.wrzesien.testowanie.testProjekt.services;

import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.MortgageReference;
import org.wrzesien.testowanie.testProjekt.model.Rate;
import org.wrzesien.testowanie.testProjekt.model.RateAmounts;

public interface ReferenceCalculationService {

	MortgageReference calculate(RateAmounts rateAmounts, InputData inputData);

	MortgageReference calculate(RateAmounts rateAmounts, final InputData inputData, Rate previousRate);
}
