package org.pazdziernik.SpringDataAccess.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@With
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producer {
	private String id;
	private String producerName;
	private String address;
}