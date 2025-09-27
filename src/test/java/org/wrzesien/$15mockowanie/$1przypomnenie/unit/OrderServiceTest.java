package org.wrzesien.$15mockowanie.$1przypomnenie.unit;

import org.junit.jupiter.api.Test;
import org.wrzesien.$15mockowanie.$1przypomnenie.exception.PaymentFailedException;
import org.wrzesien.$15mockowanie.$1przypomnenie.model.Order;
import org.wrzesien.$15mockowanie.$1przypomnenie.repository.OrderRepository;
import org.wrzesien.$15mockowanie.$1przypomnenie.service.OrderService;
import org.wrzesien.$15mockowanie.$1przypomnenie.service.PaymentGateway;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class OrderServiceTest {

	@Test
	void shouldSaveOrderWhenPaymentSuccessful() {
		// given
		final OrderRepository repository = new OrderRepository(); // in-memory
		final PaymentGateway paymentGateway = mock(PaymentGateway.class);
		final OrderService service = new OrderService(repository, paymentGateway);
		final Order order = new Order("1", 100, false);

		when(paymentGateway.charge(100)).thenReturn(true);

		// when
		service.placeOrder(order);

		// then
		assertTrue(order.isPaid());
		assertTrue(repository.findById("1").isPresent());
		verify(paymentGateway).charge(100);
	}

	@Test
	void shouldThrowExceptionWhenPaymentFails() {
		// given
		final OrderRepository repository = new OrderRepository();
		final PaymentGateway paymentGateway = mock(PaymentGateway.class);
		final OrderService service = new OrderService(repository, paymentGateway);
		final Order order = new Order("2", 200, false);

		when(paymentGateway.charge(200)).thenReturn(false);

		// when & then
		assertThrows(PaymentFailedException.class, () -> service.placeOrder(order));
		verify(paymentGateway).charge(200);
	}
}
