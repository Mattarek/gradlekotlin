package org.pazdziernik.SpringDataAccess.project.business;

import org.pazdziernik.SpringDataAccess.project.domain.Opinion;

public interface OpinionRepository {
	Opinion create(Opinion opinion);
}
