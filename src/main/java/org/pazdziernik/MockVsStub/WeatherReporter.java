package org.pazdziernik.MockVsStub;

public class WeatherReporter {
	private final WeatherService weatherService;

	public WeatherReporter(final WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	public String generateReport() {
		final String weather = weatherService.getWeather();

		if ("Sunny".equals(weather)) {
			return "It's a beautiful day!";
		}

		if ("Rainy".equals(weather)) {
			return "Don't forget your umbrella!";
		}
		return "Weather is uncertain.";
	}
}
