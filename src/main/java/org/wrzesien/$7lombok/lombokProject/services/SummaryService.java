package org.wrzesien.$7lombok.lombokProject.services;

import org.wrzesien.$7lombok.lombokProject.model.Rate;
import org.wrzesien.$7lombok.lombokProject.model.Summary;

import java.util.List;

public interface SummaryService {

	Summary calculateSummary(List<Rate> rates);
}
