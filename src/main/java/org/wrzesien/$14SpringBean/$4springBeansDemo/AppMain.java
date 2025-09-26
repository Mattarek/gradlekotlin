package org.wrzesien.$14SpringBean.$4springBeansDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.config.AppConfig;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Customer;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Order;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.model.Product;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.service.CustomerService;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.service.OrderService;
import org.wrzesien.$14SpringBean.$5springBeansDemoTwo.service.ProductService;

public class AppMain {
	public static void main(final String[] args) {
		final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		final CustomerService customerService = context.getBean(CustomerService.class);
		final ProductService productService = context.getBean(ProductService.class);
		final OrderService orderService = context.getBean(OrderService.class);

		final Customer customer = new Customer(1L, "Marcin", "marcin9177@op.pl");
		final Product product = new Product(101L, "Laptop", 4999.90);
		final Order order = new Order(1001L, customer, product, 1);

		customerService.addCustomer(customer);
		productService.addProduct(product);
		orderService.placeOrder(order);
	}
}
