package org.wrzesien.$7lombok.lombokProject.services;

import org.wrzesien.$7lombok.lombokProject.model.Rate;

import java.math.BigDecimal;

public interface Function {

	BigDecimal calculate(Rate rate);
}
