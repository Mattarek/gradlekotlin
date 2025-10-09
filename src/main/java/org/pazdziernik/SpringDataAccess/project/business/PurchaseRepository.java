package org.pazdziernik.SpringDataAccess.project.business;

import org.pazdziernik.SpringDataAccess.project.domain.Purchase;

public interface PurchaseRepository {
	Purchase create(Purchase purchase);
}
