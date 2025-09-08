package org.wrzesien.$7lombok.lombokProject.services;

import org.wrzesien.$7lombok.lombokProject.model.InputData;
import org.wrzesien.$7lombok.lombokProject.model.Rate;
import org.wrzesien.$7lombok.lombokProject.model.TimePoint;

import java.math.BigDecimal;

public interface TimePointCalculationService {

	TimePoint calculate(final BigDecimal rateNumber, final InputData inputData);

	TimePoint calculate(BigDecimal rateNumber, Rate previousRate);
}
