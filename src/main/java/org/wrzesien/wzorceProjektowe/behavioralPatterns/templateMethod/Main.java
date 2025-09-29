package org.wrzesien.wzorceProjektowe.behavioralPatterns.templateMethod;

public class Main {
	public static void main(final String[] args) {
		System.out.println("#Brick");
		final HouseTemplate houseTemplateTwo = new BrickHouse();
		houseTemplateTwo.build();

		final HouseTemplate houseTemplateOne = new WoodenHouse();
		houseTemplateOne.build();
	}
}
