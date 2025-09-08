package org.wrzesien.$7lombok.lombokProject.services;

import org.wrzesien.$7lombok.lombokProject.model.InputData;
import org.wrzesien.$7lombok.lombokProject.model.Rate;

import java.util.List;

public interface RateCalculationService {

	List<Rate> calculate(InputData inputData);
}
