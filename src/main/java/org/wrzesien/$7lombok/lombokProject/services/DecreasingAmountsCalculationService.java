package org.wrzesien.$7lombok.lombokProject.services;

import org.wrzesien.$7lombok.lombokProject.model.InputData;
import org.wrzesien.$7lombok.lombokProject.model.Overpayment;
import org.wrzesien.$7lombok.lombokProject.model.Rate;
import org.wrzesien.$7lombok.lombokProject.model.RateAmounts;

public interface DecreasingAmountsCalculationService {

	RateAmounts calculate(InputData inputData, Overpayment overpayment);

	RateAmounts calculate(InputData inputData, Overpayment overpayment, Rate previousRate);
}
