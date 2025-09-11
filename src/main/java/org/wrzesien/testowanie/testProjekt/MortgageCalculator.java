package org.wrzesien.testowanie.testProjekt;

import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.MortgageType;
import org.wrzesien.testowanie.testProjekt.model.Overpayment;
import org.wrzesien.testowanie.testProjekt.services.AmountsCalculationServiceImpl;
import org.wrzesien.testowanie.testProjekt.services.ConstantAmountsCalculationServiceImpl;
import org.wrzesien.testowanie.testProjekt.services.DecreasingAmountsCalculationServiceImpl;
import org.wrzesien.testowanie.testProjekt.services.MortgageCalculationService;
import org.wrzesien.testowanie.testProjekt.services.MortgageCalculationServiceImpl;
import org.wrzesien.testowanie.testProjekt.services.OverpaymentCalculationServiceImpl;
import org.wrzesien.testowanie.testProjekt.services.PrintingService;
import org.wrzesien.testowanie.testProjekt.services.PrintingServiceImpl;
import org.wrzesien.testowanie.testProjekt.services.RateCalculationService;
import org.wrzesien.testowanie.testProjekt.services.RateCalculationServiceImpl;
import org.wrzesien.testowanie.testProjekt.services.ReferenceCalculationServiceImpl;
import org.wrzesien.testowanie.testProjekt.services.ResidualCalculationServiceImpl;
import org.wrzesien.testowanie.testProjekt.services.SummaryServiceFactory;
import org.wrzesien.testowanie.testProjekt.services.TimePointCalculationServiceImpl;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class MortgageCalculator {

	public static void main(final String[] args) {

		// To jest rodzaj mapy, który w tym przypadku trzyma klucze posortowane rosnąco.
		// Wiem, że nie tłumaczyłem go wcześniej. Spokojnie, jeszcze będzie ;)
		final Map<Integer, BigDecimal> overpaymentSchema = new TreeMap<>();
		overpaymentSchema.put(5, BigDecimal.valueOf(12000));
		overpaymentSchema.put(19, BigDecimal.valueOf(10000));
		overpaymentSchema.put(28, BigDecimal.valueOf(11000));
		overpaymentSchema.put(64, BigDecimal.valueOf(16000));
		overpaymentSchema.put(78, BigDecimal.valueOf(18000));

		// Ważne jest to aby zwrócić uwagę, na to, które dane wejściowe są nadpisywane przez withery
		final InputData defaultInputData = InputData.defaultInputData()
				.withAmount(new BigDecimal("296192.11"))
				.withMonthsDuration(BigDecimal.valueOf(360))
				.withOverpaymentReduceWay(Overpayment.REDUCE_RATE)
				.withRateType(MortgageType.CONSTANT)
				.withOverpaymentSchema(overpaymentSchema);

		final PrintingService printingService = new PrintingServiceImpl();
		final RateCalculationService rateCalculationService = new RateCalculationServiceImpl(
				new TimePointCalculationServiceImpl(),
				new OverpaymentCalculationServiceImpl(),
				new AmountsCalculationServiceImpl(
						new ConstantAmountsCalculationServiceImpl(),
						new DecreasingAmountsCalculationServiceImpl()
				),
				new ResidualCalculationServiceImpl(),
				new ReferenceCalculationServiceImpl()
		);

		final MortgageCalculationService mortgageCalculationService = new MortgageCalculationServiceImpl(
				rateCalculationService,
				printingService,
				SummaryServiceFactory.create()
		);

		mortgageCalculationService.calculate(defaultInputData);
	}
}
