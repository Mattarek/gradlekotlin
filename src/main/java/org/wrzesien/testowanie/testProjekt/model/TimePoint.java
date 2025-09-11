package org.wrzesien.testowanie.testProjekt.model;

import lombok.Builder;
import lombok.With;

import java.math.BigDecimal;
import java.time.LocalDate;

@With
@Builder
public record TimePoint(BigDecimal year, BigDecimal month, LocalDate date) {

}
