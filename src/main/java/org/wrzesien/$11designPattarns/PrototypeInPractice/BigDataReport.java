package org.wrzesien.$11designPattarns.PrototypeInPractice;

import java.util.ArrayList;
import java.util.List;

public class BigDataReport implements IPrototype {
	private final List<String> data;

	// Konstruktor "kosztowny" – symulujemy długi proces
	public BigDataReport() {
		System.out.println("Tworzenie nowego raportu... to trwa!");
		data = new ArrayList<>();
		// Symulacja kosztownej operacji np. wczytania 100000 elementów
		for (int i = 0; i < 100_000; i++) {
			data.add("Record " + i);
		}
	}

	// Prywatny konstruktor do klonowania
	private BigDataReport(final List<String> data) {
		this.data = data;
	}

	@Override
	public IPrototype copy() {
		return new BigDataReport(new ArrayList<>(data));
	}

	public int size() {
		return data.size();
	}
}
