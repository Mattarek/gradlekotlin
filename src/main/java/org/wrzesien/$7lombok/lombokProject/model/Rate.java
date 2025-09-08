package org.wrzesien.$7lombok.lombokProject.model;

import java.math.BigDecimal;

public record Rate(BigDecimal rateNumber, TimePoint timePoint, RateAmounts rateAmounts,
				   MortgageResidual mortgageResidual, MortgageReference mortgageReference) {

}
