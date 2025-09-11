package org.wrzesien.testowanie.testProjekt.model;

import lombok.Builder;
import lombok.With;

import java.math.BigDecimal;

@With
@Builder
public record RateAmounts(BigDecimal rateAmount, BigDecimal interestAmount, BigDecimal capitalAmount,
						  Overpayment overpayment) {

}
