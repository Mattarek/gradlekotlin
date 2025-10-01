package org.wrzesien.wzorceProjektowe.behavioralPatterns.strategy;

public class ParcelLockerStrategy {
	public void deliver(final Parcel parcel) {
		System.out.printf("Parcel %s delvered by ParcelLocker%n", parcel.name());
	}
}
