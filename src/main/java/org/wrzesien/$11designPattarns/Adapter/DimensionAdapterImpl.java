package org.wrzesien.$11designPattarns.Adapter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DimensionAdapterImpl implements DimensionAdapter {
	private static final double INCH_TO_METER = 0.0254;
	private Dimension dimension;

	@Override
	public BigDecimal getDimension() {
		System.out.println("Dimension: " + dimension);
		return convertInchToMeter(dimension.getDimension());
	}

	private BigDecimal convertInchToMeter(final BigDecimal dimension) {
		return BigDecimal.valueOf(INCH_TO_METER).multiply(dimension);
	}
}
