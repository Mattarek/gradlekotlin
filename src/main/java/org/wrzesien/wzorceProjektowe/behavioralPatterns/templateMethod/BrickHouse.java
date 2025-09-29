package org.wrzesien.wzorceProjektowe.behavioralPatterns.templateMethod;

public class BrickHouse extends HouseTemplate {
	@Override
	protected void buildFundation() {
		System.out.println("BrickHouse buildFundation");
	}

	@Override
	protected void buildWhalls() {
		System.out.println("BrickHouse buildWhalls");
	}

	@Override
	protected void makeRoof() {
		System.out.println("BrickHouse makeRoof");
	}

	@Override
	protected void insertWindows() {
		System.out.println("BrickHouse insertWindows");
	}
}
