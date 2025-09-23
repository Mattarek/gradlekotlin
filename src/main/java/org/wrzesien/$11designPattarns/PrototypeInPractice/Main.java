package org.wrzesien.$11designPattarns.PrototypeInPractice;

public class Main {
	public static void main(final String[] args) {
		long start, end;

		// --- Tworzenie nowego obiektu ---
		start = System.currentTimeMillis();
		final BigDataReport report1 = new BigDataReport();
		end = System.currentTimeMillis();
		System.out.println("Nowy raport stworzony w: " + (end - start) + " ms");

		// --- Klonowanie obiektu ---
		start = System.currentTimeMillis();
		final BigDataReport report2 = (BigDataReport) report1.copy();
		end = System.currentTimeMillis();
		System.out.println("Raport sklonowany w: " + (end - start) + " ms");

		System.out.println("Rozmiar raportu: " + report2.size());
	}
}
