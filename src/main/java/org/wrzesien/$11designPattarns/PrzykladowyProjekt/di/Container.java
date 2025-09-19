package org.wrzesien.$11designPattarns.PrzykladowyProjekt.di;

import org.wrzesien.$11designPattarns.PrzykladowyProjekt.controller.OrderController;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.model.Product;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.repository.InMemoryOrderRepository;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.repository.InMemoryProductRepository;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.service.OrderService;
import org.wrzesien.$11designPattarns.PrzykladowyProjekt.service.OrderServiceImpl;

import java.util.List;

public record Container(InMemoryProductRepository inMemoryProductRepositor,
						InMemoryOrderRepository inMemoryOrderRepository, OrderService orderService,
						OrderController orderController) {
	public Container() {
		this(
				new InMemoryProductRepository(List.of(
						new Product("p1", "Espresso", 300),
						new Product("p2", "Latte", 450),
						new Product("p3", "Cappuccino", 420)
				)),
				new InMemoryOrderRepository(),
				null,
				null
		);
	}

	public Container {
		final OrderService service = new OrderServiceImpl(inMemoryOrderRepository);
		final OrderController controller = new OrderController(service);

		orderService = service;
		orderController = controller;
	}
}
