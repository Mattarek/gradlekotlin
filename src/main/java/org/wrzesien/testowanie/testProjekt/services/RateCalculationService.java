package org.wrzesien.testowanie.testProjekt.services;

import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.Rate;

import java.util.List;

public interface RateCalculationService {

	List<Rate> calculate(InputData inputData);
}
