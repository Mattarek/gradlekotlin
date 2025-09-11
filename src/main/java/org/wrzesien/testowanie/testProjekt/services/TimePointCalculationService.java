package org.wrzesien.testowanie.testProjekt.services;

import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.Rate;
import org.wrzesien.testowanie.testProjekt.model.TimePoint;

import java.math.BigDecimal;

public interface TimePointCalculationService {

	TimePoint calculate(final BigDecimal rateNumber, final InputData inputData);

	TimePoint calculate(BigDecimal rateNumber, Rate previousRate);
}
