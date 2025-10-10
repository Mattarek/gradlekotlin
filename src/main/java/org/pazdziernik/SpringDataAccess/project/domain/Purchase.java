package org.pazdziernik.SpringDataAccess.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.OffsetDateTime;

@With
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
	private String id;
	private Customer customer;
	private Product product;
	private int quantity;
	private OffsetDateTime dateTime;
}