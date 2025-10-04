package org.pazdziernik.MockVsStub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeatherReporterStubTest {

	@Test
	void testSunnyWeatherWithStub() {
		// given
		final WeatherService stubService = () -> "Sunny";

		final WeatherReporter weatherReporter = new WeatherReporter(stubService);

		//when
		final String report = weatherReporter.generateReport();

		//then
		Assertions.assertEquals("It's a beautiful day!", report);
		// brak verify() - stub nie rejestruje wywołań
	}

	@Test
	void testRainyWeatherWithStub() {
		final WeatherService weatherService = () -> "Rainy";
		final WeatherReporter reporter = new WeatherReporter(weatherService);

		final String report = reporter.generateReport();

		Assertions.assertEquals("Don't forget your umbrella!", report);
	}
}


