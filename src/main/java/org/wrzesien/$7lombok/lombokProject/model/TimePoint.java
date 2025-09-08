package org.wrzesien.$7lombok.lombokProject.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TimePoint(BigDecimal year, BigDecimal month, LocalDate date) {

}
