package org.wrzesien.wzorceProjektowe.behavioralPatterns.strategy;

public class PostStrategy {

	public void deliver(final Parcel parcel) {
		System.out.printf("Parcel %s delvered by Post%n", parcel.name());
	}
}
