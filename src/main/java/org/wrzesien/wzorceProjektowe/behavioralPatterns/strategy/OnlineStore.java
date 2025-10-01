package org.wrzesien.wzorceProjektowe.behavioralPatterns.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class OnlineStore {
	private final List<Parcel> parcels = new ArrayList<>();

	public void addParcel(final Parcel parcel) {
		parcels.add(parcel);
	}

	public void deliver(final Consumer<Parcel> strategy) {
		for (final Parcel parcel : parcels) {
			strategy.accept(parcel);
		}
	}
}
