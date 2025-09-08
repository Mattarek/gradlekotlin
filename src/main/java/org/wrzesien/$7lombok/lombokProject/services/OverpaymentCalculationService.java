package org.wrzesien.$7lombok.lombokProject.services;

import org.wrzesien.$7lombok.lombokProject.model.InputData;
import org.wrzesien.$7lombok.lombokProject.model.Overpayment;

import java.math.BigDecimal;

public interface OverpaymentCalculationService {

	Overpayment calculate(final BigDecimal rateNumber, final InputData inputData);
}
