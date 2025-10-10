package org.pazdziernik.SpringDataAccess.project.business;

import org.pazdziernik.SpringDataAccess.project.domain.Customer;
import org.pazdziernik.SpringDataAccess.project.domain.Opinion;
import org.pazdziernik.SpringDataAccess.project.domain.Producer;
import org.pazdziernik.SpringDataAccess.project.domain.Product;
import org.pazdziernik.SpringDataAccess.project.domain.Purchase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomDataPreparationService {
	Customer createCustomer() {
		final String name = randomString(65, 90, 1) + randomString(97, 122, 10) + randomString(48, 57, 2);
		return Customer.builder()
				.userName(name + " user")
				.email(name + "@gmail.com")
				.name(name)
				.surname("surname")
				.dateOfBirth(LocalDate.of(1991, 10, 2))
				.telephoneNumber("+" + randomString(48, 57, 11))
				.build();
	}

	Opinion createOpinion(final Customer customer, final Product product) {
		return Opinion.builder()
				.customer(customer)
				.product(product)
				.stars((byte) 4)
				.comment("My comment")
				.dateTime(OffsetDateTime.of(2020, 1, 1, 12, 9, 10, 1, ZoneOffset.ofHours(4)))
				.build();
	}

	Product createProduct(final Producer producer) {
		return Product.builder()
				.producerCode(randomString(65, 90, 1) + randomString(97, 122, 4) + randomString(48, 57, 2))
				.producerName("productName")
				.producerPrice(BigDecimal.valueOf(162.16))
				.adultsOnly(false)
				.description("someDescription")
				.producer(producer)
				.build();
	}

	Producer createProducer() {
		return Producer.builder()
				.producerName(randomString(65, 90, 1) + randomString(97, 122, 10))
				.address("someAddress")
				.build();
	}

	Purchase createPurchase(final Customer customer, final Product product) {
		return Purchase.builder()
				.customer(customer)
				.product(product)
				.quantity(randomInt(1, 5))
				.dateTime(OffsetDateTime.of(2020, 1, 1, 12, 9, 10, 1, ZoneOffset.ofHours(4)))
				.build();
	}

	private String randomString(final int min, final int max, final int length) {
		return IntStream.range(0, length)
				.boxed()
				.reduce("", (prev, next) -> prev + (char) randomInt(min, max), String::concat);
	}

	private int randomInt(final int min, final int max) {
		return new Random().nextInt(max - min) + min;
	}
}
