package org.wrzesien.$7lombok.lombokProject.services;

import org.wrzesien.$7lombok.lombokProject.model.InputData;
import org.wrzesien.$7lombok.lombokProject.model.MortgageResidual;
import org.wrzesien.$7lombok.lombokProject.model.Rate;
import org.wrzesien.$7lombok.lombokProject.model.RateAmounts;

public interface ResidualCalculationService {

	MortgageResidual calculate(RateAmounts rateAmounts, InputData inputData);

	MortgageResidual calculate(RateAmounts rateAmounts, final InputData inputData, Rate previousRate);
}
