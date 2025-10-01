package org.wrzesien.wzorceProjektowePraktyka.Command;

import org.wrzesien.wzorceProjektowePraktyka.Order;

public class CancelOrderCommand implements Command {
	private final Order order;

	public CancelOrderCommand(final Order order) {
		this.order = order;
	}

	public void execute() {
		System.out.println("Cancelling order: " + order);
	}
}
