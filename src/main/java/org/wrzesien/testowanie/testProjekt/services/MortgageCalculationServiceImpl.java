package org.wrzesien.testowanie.testProjekt.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.Rate;
import org.wrzesien.testowanie.testProjekt.model.Summary;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class MortgageCalculationServiceImpl implements MortgageCalculationService {

	private final RateCalculationService rateCalculationService;

	private final PrintingService printingService;

	private final SummaryService summaryService;

	@Override
	public void calculate(final InputData inputData) {
		printingService.printIntroInformation(inputData);

		final List<Rate> rates = rateCalculationService.calculate(inputData);
		rates.forEach(element -> log.debug("Rate: [{}]", element));
		final Summary summary = summaryService.calculateSummary(rates);

		printingService.printSummary(summary);
		printingService.printSchedule(rates, inputData);
	}
}
