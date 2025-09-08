package org.wrzesien.$7lombok.lombokProject;

import org.wrzesien.$7lombok.lombokProject.model.InputData;
import org.wrzesien.$7lombok.lombokProject.model.MortgageType;
import org.wrzesien.$7lombok.lombokProject.model.Overpayment;
import org.wrzesien.$7lombok.lombokProject.services.AmountsCalculationServiceImpl;
import org.wrzesien.$7lombok.lombokProject.services.ConstantAmountsCalculationServiceImpl;
import org.wrzesien.$7lombok.lombokProject.services.DecreasingAmountsCalculationServiceImpl;
import org.wrzesien.$7lombok.lombokProject.services.MortgageCalculationService;
import org.wrzesien.$7lombok.lombokProject.services.MortgageCalculationServiceImpl;
import org.wrzesien.$7lombok.lombokProject.services.OverpaymentCalculationServiceImpl;
import org.wrzesien.$7lombok.lombokProject.services.PrintingService;
import org.wrzesien.$7lombok.lombokProject.services.PrintingServiceImpl;
import org.wrzesien.$7lombok.lombokProject.services.RateCalculationService;
import org.wrzesien.$7lombok.lombokProject.services.RateCalculationServiceImpl;
import org.wrzesien.$7lombok.lombokProject.services.ReferenceCalculationServiceImpl;
import org.wrzesien.$7lombok.lombokProject.services.ResidualCalculationServiceImpl;
import org.wrzesien.$7lombok.lombokProject.services.SummaryServiceFactory;
import org.wrzesien.$7lombok.lombokProject.services.TimePointCalculationServiceImpl;

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
		final InputData defaultInputData = new InputData()
				.withAmount(new BigDecimal("296192.11"))
				.withMonthsDuration(BigDecimal.valueOf(360))
				.withOverpaymentReduceWay(Overpayment.REDUCE_PERIOD)
				.withType(MortgageType.DECREASING)
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
