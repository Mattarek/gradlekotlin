package org.wrzesien.testowanie.testProjekt.model;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record MortgageResidual(BigDecimal residualAmount, BigDecimal residualDuration) {

}
