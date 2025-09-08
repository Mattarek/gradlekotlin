package org.wrzesien.$7lombok.lombokProject.services;

import org.wrzesien.$7lombok.lombokProject.model.InputData;
import org.wrzesien.$7lombok.lombokProject.model.MortgageReference;
import org.wrzesien.$7lombok.lombokProject.model.Rate;
import org.wrzesien.$7lombok.lombokProject.model.RateAmounts;

public interface ReferenceCalculationService {

	MortgageReference calculate(RateAmounts rateAmounts, InputData inputData);

	MortgageReference calculate(RateAmounts rateAmounts, final InputData inputData, Rate previousRate);
}
