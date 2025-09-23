package org.wrzesien.$11designPattarns.Adapter;

public class Main {
	public static void main(final String[] args) {
		final Dimension dimension = new SonyTV();
		final DimensionAdapter dimensionAdapter = new DimensionAdapterImpl(dimension);

		System.out.println("Original: " + dimension.getDimension());
		System.out.println("Adapter: " + dimensionAdapter.getDimension());
	}
}
