package org.wrzesien.$15mockowanie.$1przypomnenie.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOrderRepository {
	private final File file;

	public FileOrderRepository(final File file) {
		this.file = file;
	}

	public void save(final Order order) {
		try (final FileWriter fw = new FileWriter(file, true)) {
			fw.write(order.getId() + ";" + order.getAmount() + ";" + order.isPaid() + "\n");
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Order> findAll() {
		final List<Order> orders = new ArrayList<>();
		try (final BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				final String[] parts = line.split(";");
				final Order order = new Order(parts[0], Double.parseDouble(parts[1]), false);
				if (Boolean.parseBoolean(parts[2])) {
					order.markPaid();
				}
				orders.add(order);
			}
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
		return orders;
	}
}
