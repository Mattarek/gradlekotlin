package org.pazdziernik.SpringDataAccess.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.LocalDate;

@With
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private String id;
	private String producerCode;
	private String producerName;
	private String producerPrice;
	private String adultsOnly;
	private String description;
	private String producer_id;
}