package org.wrzesien.$14SpringBean.$5springBeansDemoTwo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.config.AppConfig;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.controller.CustomerController;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.controller.OrderController;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.controller.ProductController;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Customer;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Product;

public class Main {
	public static void main(final String[] args) {
		final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		final CustomerController customerController = context.getBean(CustomerController.class);
		final ProductController productController = context.getBean(ProductController.class);
		final OrderController orderController = context.getBean(OrderController.class);

		final Customer customer = new Customer(1L, "Marcin", "marcin9177@op.pl");
		final Product product = new Product(101L, "Laptop", 4999.90);

		customerController.addCustomer(customer.id(), customer.name(), customer.email());
		productController.addProduct(product.id(), product.name(), product.price());

		orderController.createAndPlaceOrder(customer, product, 1, 1001L);
	}
}
