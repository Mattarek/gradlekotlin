package org.pazdziernik.SpringDataAccess.project.business;

import org.pazdziernik.SpringDataAccess.project.domain.Customer;
import org.pazdziernik.SpringDataAccess.project.domain.Opinion;
import org.pazdziernik.SpringDataAccess.project.domain.Producer;
import org.pazdziernik.SpringDataAccess.project.domain.Product;
import org.pazdziernik.SpringDataAccess.project.domain.Purchase;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class RandomDataPreparationService {
	Customer createCustomer() {
		final String name = "";
		return Customer.builder()
				.userName(name + " user")
				.email(name + "@gmail.com")
				.name(name)
				.surname("surname")
				.dateOfBirth(LocalDate.of(1991, 10, 2))
				.telephoneNumber("+" + randomString())
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

	Producer createProducer() {
		return Producer.builder()
				.producerName(randomString())
				.address("someAddress")
				.build();
	}

	Product createProduct() {
		return Product.builder()
				.producerCode()
				.producerName()
				.producerPrice()
				.adultsOnly()
				.description()
				.producerId()
				.build();
	}

	Purchase createPurchase() {
		return Purchase.builder()
				.customerId()
				.productId()
				.productId()
				.quantity()
				.dateTime()
				.build();
	}
}
