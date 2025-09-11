package org.wrzesien.testowanie.testProjekt.services;

import lombok.extern.slf4j.Slf4j;
import org.wrzesien.testowanie.testProjekt.model.InputData;
import org.wrzesien.testowanie.testProjekt.model.Overpayment;
import org.wrzesien.testowanie.testProjekt.model.Rate;
import org.wrzesien.testowanie.testProjekt.model.Summary;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class PrintingServiceImpl implements PrintingService {

	@Override
	public void printIntroInformation(final InputData inputData) {
		final StringBuilder msg = new StringBuilder(NEW_LINE);
		msg.append(MORTGAGE_AMOUNT).append(inputData.getAmount()).append(CURRENCY);
		msg.append(NEW_LINE);
		msg.append(MORTGAGE_PERIOD).append(inputData.getMonthsDuration()).append(MONTHS);
		msg.append(NEW_LINE);
		msg.append(INTEREST).append(inputData.getInterestToDisplay()).append(PERCENT);
		msg.append(NEW_LINE);
		msg.append(OVERPAYMENT_START_MONTH).append(inputData.getOverpaymentStartMonth()).append(BLANK).append(MONTH);

		Optional.of(inputData.getOverpaymentSchema())
				.filter(schema -> schema.size() > 0)
				.ifPresent(schema -> logOverpayment(msg, inputData.getOverpaymentSchema(), inputData.getOverpaymentReduceWay()));

		logMessage(msg);
	}

	private void logOverpayment(final StringBuilder msg, final Map<Integer, BigDecimal> schema, final String reduceWay) {
		switch (reduceWay) {
			case Overpayment.REDUCE_PERIOD:
				msg.append(OVERPAYMENT_REDUCE_PERIOD);
				break;
			case Overpayment.REDUCE_RATE:
				msg.append(OVERPAYMENT_REDUCE_RATE);
				break;
			default:
				throw new MortgageException("Case not handled");
		}
		msg.append(NEW_LINE);
		msg.append(OVERPAYMENT_FREQUENCY).append(NEW_LINE).append(prettyPrintOverpaymentSchema(schema));
	}

	private String prettyPrintOverpaymentSchema(final Map<Integer, BigDecimal> schema) {
		final StringBuilder schemaMsg = new StringBuilder();
		for (final Map.Entry<Integer, BigDecimal> entry : schema.entrySet()) {
			schemaMsg.append(MONTH)
					.append(entry.getKey())
					.append(COMMA)
					.append(AMOUNT)
					.append(entry.getValue())
					.append(CURRENCY)
					.append(NEW_LINE);
		}
		return schemaMsg.toString();
	}

	@Override
	public void printSchedule(final List<Rate> rates, final InputData inputData) {
		if (!inputData.isMortgagePrintPayoffsSchedule()) {
			return;
		}

		int index = 1;
		for (final Rate rate : rates) {
			if (rate.rateNumber().remainder(BigDecimal.valueOf(inputData.getMortgageRateNumberToPrint())).equals(BigDecimal.ZERO)) {
				final String logMessage = String.format(SCHEDULE_TABLE_FORMAT,
						RATE_NUMBER, rate.rateNumber(),
						YEAR, rate.timePoint().year(),
						MONTH, rate.timePoint().month(),
						DATE, rate.timePoint().date(),
						RATE, rate.rateAmounts().rateAmount(),
						INTEREST, rate.rateAmounts().interestAmount(),
						CAPITAL, rate.rateAmounts().capitalAmount(),
						OVERPAYMENT, rate.rateAmounts().overpayment().amount(),
						LEFT_AMOUNT, rate.mortgageResidual().residualAmount(),
						LEFT_MONTHS, rate.mortgageResidual().residualDuration()
				);
				logMessage(logMessage);
				if (index % AmountsCalculationService.YEAR.intValue() == 0) {
					logSeparator(SEPARATOR);
				}
				index++;
			}
		}
		logMessage(NEW_LINE);
	}

	@Override
	public void printSummary(final Summary summary) {
		final StringBuilder msg = new StringBuilder();
		msg.append(INTEREST_SUM).append(summary.interestSum()).append(CURRENCY);
		msg.append(NEW_LINE);
		msg.append(OVERPAYMENT_PROVISION).append(summary.overpaymentProvisionSum().setScale(2, RoundingMode.HALF_UP)).append(CURRENCY);
		msg.append(NEW_LINE);
		msg.append(LOSTS_SUM).append(summary.totalLostSum().setScale(2, RoundingMode.HALF_UP)).append(CURRENCY);
		msg.append(NEW_LINE);
		msg.append(CAPITAL_SUM).append(summary.totalCapital().setScale(2, RoundingMode.HALF_UP)).append(CURRENCY);
		msg.append(NEW_LINE);

		logMessage(msg);
	}

	@SuppressWarnings("SameParameterValue")
	private void logSeparator(final StringBuilder sep) {
		logMessage(sep);
	}

	private void logMessage(final StringBuilder message) {
		logMessage(message.toString());
	}

	private void logMessage(final String message) {
		log.info(message);
	}
}
