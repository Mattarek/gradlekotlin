package org.wrzesien.wzorceProjektowe.behavioralPatterns.templateMethod;

public class WoodenHouse extends HouseTemplate {
	@Override
	protected void buildFundation() {
		System.out.println("WoodenHouse buildFundation");
	}

	@Override
	protected void buildWhalls() {
		System.out.println("WoodenHouse buildWhalls");
	}

	@Override
	protected void makeRoof() {
		System.out.println("WoodenHouse makeRoof");
	}

	@Override
	protected void insertWindows() {
		System.out.println("WoodenHouse insertWindows");
	}
}
