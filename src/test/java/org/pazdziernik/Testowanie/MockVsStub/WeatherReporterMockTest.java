package org.pazdziernik.Testowanie.MockVsStub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)   // <<< to inicjuje pola oznaczone @Mock przed każdym testem
class WeatherReporterMockTest {

	@Mock
	private WeatherService mockWeatherService; // mock tworzony przez Mockito

	@Test
	void testSunnyWeatherWithMock() {
		// given
		Mockito.when(mockWeatherService.getWeather()).thenReturn("Sunny"); // stubujemy zachowanie mocka
		final WeatherReporter reporter = new WeatherReporter(mockWeatherService); // wstrzykujemy mocka

		// when
		final String report = reporter.generateReport(); // wywołujemy metodę klasy testowanej

		// then
		Assertions.assertEquals("It's a beautiful day!", report); // sprawdzamy wynik
		Mockito.verify(mockWeatherService).getWeather();       // weryfikujemy, że metoda mocka została wywołana
	}

	@Test
	void testRainyWeatherWithMock() {
		Mockito.when(mockWeatherService.getWeather()).thenReturn("Rainy");
		final WeatherReporter reporter = new WeatherReporter(mockWeatherService);

		final String report = reporter.generateReport();

		Assertions.assertEquals("Don't forget your umbrella!", report);
		Mockito.verify(mockWeatherService).getWeather();
	}
}