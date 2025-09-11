package org.wrzesien.testowanie.testProjekt.services;

import org.wrzesien.testowanie.testProjekt.model.Rate;

import java.math.BigDecimal;

@FunctionalInterface
public interface Function {

	BigDecimal calculate(Rate rate);
}
