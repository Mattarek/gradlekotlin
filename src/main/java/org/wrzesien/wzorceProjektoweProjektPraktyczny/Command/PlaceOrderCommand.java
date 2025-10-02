package org.wrzesien.wzorceProjektoweProjektPraktyczny.Command;

import org.wrzesien.wzorceProjektoweProjektPraktyczny.Order;

public class PlaceOrderCommand implements Command {
	private final Order order;

	public PlaceOrderCommand(final Order order) {
		this.order = order;
	}

	public void execute() {
		System.out.println("Placing order: " + order);
	}
}
