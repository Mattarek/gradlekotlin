package org.wrzesien.$7lombok.lombokProject.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Map;

public class InputData {

	private static final BigDecimal PERCENT = new BigDecimal("100");
	@Getter
	private LocalDate repaymentStartDate = LocalDate.of(2020, 12, 10);
	private BigDecimal wiborPercent = BigDecimal.valueOf(1.70);
	@Getter
	private BigDecimal amount = BigDecimal.valueOf(301953.46);
	@Getter
	private BigDecimal monthsDuration = BigDecimal.valueOf(180);
	@Getter
	private MortgageType rateType = MortgageType.CONSTANT;
	private BigDecimal marginPercent = BigDecimal.valueOf(1.6);
	private BigDecimal overpaymentProvisionPercent = BigDecimal.valueOf(3);
	@Getter
	private BigDecimal overpaymentProvisionMonths = BigDecimal.valueOf(36);
	@Getter
	private BigDecimal overpaymentStartMonth = BigDecimal.valueOf(1);

	@Getter
	private Map<Integer, BigDecimal> overpaymentSchema = Map.of(
			2, BigDecimal.valueOf(10000),
			3, BigDecimal.valueOf(10000),
			5, BigDecimal.valueOf(10000),
			6, BigDecimal.valueOf(10000),
			7, BigDecimal.valueOf(10000)
	);
	@Getter
	private String overpaymentReduceWay = Overpayment.REDUCE_PERIOD;

	@Getter
	private boolean mortgagePrintPayoffsSchedule = true;
	@Getter
	private Integer mortgageRateNumberToPrint = 1;

	public InputData withRepaymentStartDate(final LocalDate repaymentStartDate) {
		this.repaymentStartDate = repaymentStartDate;
		return this;
	}

	public InputData withWiborPercent(final BigDecimal wiborPercent) {
		this.wiborPercent = wiborPercent;
		return this;
	}

	public InputData withAmount(final BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	public InputData withMonthsDuration(final BigDecimal monthsDuration) {
		this.monthsDuration = monthsDuration;
		return this;
	}

	public InputData withType(final MortgageType type) {
		rateType = type;
		return this;
	}

	public InputData withMarginPercent(final BigDecimal marginPercent) {
		this.marginPercent = marginPercent;
		return this;
	}

	public InputData withOverpaymentProvisionPercent(final BigDecimal overpaymentProvisionPercent) {
		this.overpaymentProvisionPercent = overpaymentProvisionPercent;
		return this;
	}

	public InputData withOverpaymentProvisionMonths(final BigDecimal overpaymentProvisionMonths) {
		this.overpaymentProvisionMonths = overpaymentProvisionMonths;
		return this;
	}

	public InputData withOverpaymentStartMonth(final BigDecimal overpaymentStartMonth) {
		this.overpaymentStartMonth = overpaymentStartMonth;
		return this;
	}

	public InputData withOverpaymentSchema(final Map<Integer, BigDecimal> overpaymentSchema) {
		this.overpaymentSchema = overpaymentSchema;
		return this;
	}

	public InputData withOverpaymentReduceWay(final String overpaymentReduceWay) {
		this.overpaymentReduceWay = overpaymentReduceWay;
		return this;
	}

	public InputData withMortgagePrintPayoffsSchedule(final boolean mortgagePrintPayoffsSchedule) {
		this.mortgagePrintPayoffsSchedule = mortgagePrintPayoffsSchedule;
		return this;
	}

	public InputData withMortgageRateNumberToPrint(final Integer mortgageRateNumberToPrint) {
		this.mortgageRateNumberToPrint = mortgageRateNumberToPrint;
		return this;
	}

	public BigDecimal getWiborPercent() {
		return wiborPercent.divide(PERCENT, 4, RoundingMode.HALF_UP);
	}

	public BigDecimal getMarginPercent() {
		return marginPercent.divide(PERCENT, 4, RoundingMode.HALF_UP);
	}

	public BigDecimal getOverpaymentProvisionPercent() {
		return overpaymentProvisionPercent.divide(PERCENT, 4, RoundingMode.HALF_UP);
	}

	public BigDecimal getInterestPercent() {
		return getMarginPercent().add(getWiborPercent());
	}

	public BigDecimal getInterestToDisplay() {
		return wiborPercent.add(marginPercent);
	}
}
