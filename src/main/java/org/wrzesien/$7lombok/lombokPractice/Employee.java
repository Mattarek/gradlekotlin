package org.wrzesien.lombok.lombokPractice;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record Employee(String name, String surname, String email, BigDecimal salary, LocalDate dateOfBirth,
					   String address) {
}
