package org.wrzesien.$15mockowanie.$1przypomnenie.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wrzesien.$15mockowanie.$1przypomnenie.model.FileOrderRepository;
import org.wrzesien.$15mockowanie.$1przypomnenie.model.Order;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderRepositoryFileTest {

	private File tempFile;
	private FileOrderRepository repository;

	@BeforeEach
	void setUp() throws Exception {
		tempFile = File.createTempFile("orders", ".txt");
		// usuń zawartość
		tempFile.deleteOnExit();
		repository = new FileOrderRepository(tempFile);
	}

	@Test
	void shouldSaveAndReadOrdersFromFile() {
		// given
		final Order order1 = new Order("1", 100, false);
		order1.markPaid();
		final Order order2 = new Order("2", 200, false);

		// when
		repository.save(order1);
		repository.save(order2);
		final List<Order> result = repository.findAll();

		// then
		assertEquals(2, result.size());
		assertTrue(result.stream().anyMatch(o -> o.getId().equals("1") && o.isPaid()));
		assertTrue(result.stream().anyMatch(o -> o.getId().equals("2") && !o.isPaid()));
	}
}
