package org.pazdziernik.SpringDataAccess.project.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pazdziernik.SpringDataAccess.project.domain.Customer;
import org.pazdziernik.SpringDataAccess.project.domain.Opinion;
import org.pazdziernik.SpringDataAccess.project.domain.Producer;
import org.pazdziernik.SpringDataAccess.project.domain.Product;
import org.pazdziernik.SpringDataAccess.project.domain.Purchase;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RandomDataService {
	private final RandomDataPreparationService randomDataPreparationService;
	private final CustomerRepository customerRepository;
	private final OpinionRepository opinionRepository;
	private final ProducerRepository producerRepository;
	private final ProductRepository productRepository;
	private final PurchaseRepository purchaseRepository;

	public void create() {
		final Customer customer = customerRepository.create(randomDataPreparationService.createCustomer());
		final Producer producer = producerRepository.create(randomDataPreparationService.createProducer());
		final Product product = productRepository.create(randomDataPreparationService.createProduct(producer));
		final Opinion opinion = opinionRepository.create(randomDataPreparationService.createOpinion(customer, product));
		final Purchase purchase = purchaseRepository.create(randomDataPreparationService.createPurchase(customer, product));

		//		final Customer customer = customerRepository.create(randomDataPreparationService.createCustomer());
		//		final Producer producer = producerRepository.create(randomDataPreparationService.createProducer());
		//		final Product product = productRepository.create(randomDataPreparationService.createProduct(producer));
		//		final Opinion opinion = opinionRepository.create(randomDataPreparationService.createOpinion(customer, product));
		//		final Purchase purchase = purchaseRepository.create(randomDataPreparationService.createPurchase(customer, product));

		log.debug("Random customer created: [{}]", customer);
		log.debug("Random opinion created: [{}]", opinion);
		log.debug("Random producer created: [{}]", producer);
		log.debug("Random product created: [{}]", product);
		log.debug("Random purchase created: [{}]", purchase);
	}
}
