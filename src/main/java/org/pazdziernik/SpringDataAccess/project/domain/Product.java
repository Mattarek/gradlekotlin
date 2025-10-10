package org.pazdziernik.SpringDataAccess.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.math.BigDecimal;
import java.time.LocalDate;

@With
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private Long id;
	private String producerCode;
	private String producerName;
	private BigDecimal producerPrice;
	private boolean adultsOnly;
	private String description;
	private Producer producer;
}