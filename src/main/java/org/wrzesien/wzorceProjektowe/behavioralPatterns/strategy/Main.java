package org.wrzesien.wzorceProjektowe.behavioralPatterns.strategy;

public class Main {
	public static void main(final String[] args) {
		final OnlineStore onlineStore = new OnlineStore();

		onlineStore.addParcel(new Parcel("skarpety"));
		onlineStore.addParcel(new Parcel("monitory"));
		onlineStore.addParcel(new Parcel("mleko"));
		onlineStore.addParcel(new Parcel("monitory"));

		System.out.println("##Courier");
		onlineStore.deliver(parcel -> System.out.printf("Parcel %s delivered by Courier%n", parcel.name()));

		System.out.println("##Post");
		onlineStore.deliver(parcel -> System.out.printf("Parcel %s delivered by Post%n", parcel.name()));

		System.out.println("##ParcelLocker");
		onlineStore.deliver(parcel -> System.out.printf("Parcel %s delivered by ParcelLocker%n", parcel.name()));
	}
}
