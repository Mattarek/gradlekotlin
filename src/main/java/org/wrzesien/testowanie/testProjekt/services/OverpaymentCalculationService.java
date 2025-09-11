package org.wrzesien.testowanie.testProjekt.services;

import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.Overpayment;

import java.math.BigDecimal;

public interface OverpaymentCalculationService {

	Overpayment calculate(final BigDecimal rateNumber, final InputData inputData);
}
