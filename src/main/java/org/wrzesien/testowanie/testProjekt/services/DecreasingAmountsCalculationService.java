package org.wrzesien.testowanie.testProjekt.services;

import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.Overpayment;
import org.wrzesien.testowanie.testProjekt.model.Rate;
import org.wrzesien.testowanie.testProjekt.model.RateAmounts;

public interface DecreasingAmountsCalculationService {

	RateAmounts calculate(InputData inputData, Overpayment overpayment);

	RateAmounts calculate(InputData inputData, Overpayment overpayment, Rate previousRate);
}
