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
	private String customerId;
	private String productId;
	private String quantity;
	private OffsetDateTime dateTime;
}