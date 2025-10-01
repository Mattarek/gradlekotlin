package org.wrzesien.wzorceProjektowe.behavioralPatterns.strategy;

public class CourierStrategy {
	public void deliver(final Parcel parcel) {
		System.out.printf("Parcel $s delivered by Courier%n", parcel.name());
	}
}
