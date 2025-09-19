package org.wrzesien.$11designPattarns.PrzykladowyProjekt;

import org.wrzesien.$11designPattarns.PrzykladowyProjekt.controller.OrderController;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.di.Container;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Customer;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Order;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Product;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.repository.InMemoryProductRepository;

import java.util.List;

/**
 * Main entrypoint for demonstration purposes.
 * Keeps UI concerns separate (SRP) and is intentionally simple (KISS).
 */
public class Main {
	public static void main(final String[] args) {
		final Container container = new Container();
		final InMemoryProductRepository products = container.inMemoryProductRepositor();
		final OrderController controller = container.orderController();

		final Customer marcin = new Customer("u1", "marcin@example.com");
		final List<Product> items = List.of(products.findById("p2").orElseThrow(), products.findById("p3").orElseThrow());

		final Order order = controller.handleCreateOrder(null, marcin, items);

		System.out.println("Order created: " + order.id() + " total: " + order.totalPriceCents() + " cents");
	}
}
