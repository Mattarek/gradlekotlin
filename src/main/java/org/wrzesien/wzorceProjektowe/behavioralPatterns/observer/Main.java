package org.wrzesien.wzorceProjektowe.behavioralPatterns.observer;

public class Main {
	public static void main(final String[] args) {
		final NewsPublisher newsPublisher = new NewsPublisher();

		final Observer reader1 = new Reader("Jan");
		final Observer reader2 = new Reader("Anna");
		final Observer reader3 = new Reader("Kasia");

		newsPublisher.subscribe(reader1);
		newsPublisher.subscribe(reader2);
		newsPublisher.subscribe(reader3);

		newsPublisher.publishNews("Nowy artykuł o Javie");
		newsPublisher.publishNews("Wzorce projektowe w praktyce");

		newsPublisher.unsubscribe(reader3);

		newsPublisher.publishNews("Ostatnie wiadomości na dziś.");
	}
}
