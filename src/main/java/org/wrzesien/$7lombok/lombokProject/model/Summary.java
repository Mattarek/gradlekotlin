package org.wrzesien.$7lombok.lombokProject.model;

import java.math.BigDecimal;

public record Summary(BigDecimal interestSum, BigDecimal overpaymentProvisionSum, BigDecimal totalLostSum,
					  BigDecimal totalCapital) {

}
