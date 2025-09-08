package org.wrzesien.$7lombok.lombokProject.model;

import java.math.BigDecimal;

public record RateAmounts(BigDecimal rateAmount, BigDecimal interestAmount, BigDecimal capitalAmount,
						  Overpayment overpayment) {

}
