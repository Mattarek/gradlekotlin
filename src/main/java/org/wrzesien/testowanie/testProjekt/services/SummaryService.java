package org.wrzesien.testowanie.testProjekt.services;

import org.wrzesien.testowanie.testProjekt.model.Rate;
import org.wrzesien.testowanie.testProjekt.model.Summary;

import java.util.List;

public interface SummaryService {

	Summary calculateSummary(List<Rate> rates);
}
