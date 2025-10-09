package org.pazdziernik.SpringDataAccess.project.business;

import org.pazdziernik.SpringDataAccess.project.domain.Customer;
import org.pazdziernik.SpringDataAccess.project.domain.Opinion;
import org.pazdziernik.SpringDataAccess.project.domain.Producer;
import org.pazdziernik.SpringDataAccess.project.domain.Product;
import org.pazdziernik.SpringDataAccess.project.domain.Purchase;

public class RandomDataPreparationService {
	Customer createCustomer() {
		return Customer.builder()
				.userName()
				.email()
				.name()
				.surname()
				.dateOfBirth()
				.telephoneNumber()
				.build();
	}

	Opinion createOpinion() {
		return Opinion.builder()
				.customer()
				.product()
				.stars()
				.comment()
				.dateTime()
				.build();
	}

	Producer createProducer() {
		return Producer.builder()
				.producerName()
				.address()
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
