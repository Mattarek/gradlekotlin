package org.wrzesien.wzorceProjektowe.behavioralPatterns.observer;

public class Main {
	public static void main(final String[] args) {
		final NewsPublisher newsPublisher = new NewsPublisher();

		final Observer reader1 = new Reader("Jan");
		final Observer reader2 = new Reader("Anna");
		final Observer reader3 = new Reader("Kasia");

		final Observer obserwerOne = news -> System.out.printf("Message %s%n", news);
		final Observer obserwerTwo = news -> System.out.printf("Message %s%n", news);
		final Observer obserwerThree = news -> System.out.printf("Message %s%n", news);

		newsPublisher.subscribe(reader1);
		newsPublisher.subscribe(reader2);
		newsPublisher.subscribe(reader3);
		
		//		newsPublisher.subscribe(obserwerOne);
		//		newsPublisher.subscribe(obserwerTwo);
		//		newsPublisher.subscribe(obserwerThree);

		newsPublisher.publishNews("Nowy artykuł o Javie");
		newsPublisher.publishNews("Wzorce projektowe w praktyce");

		newsPublisher.unsubscribe(reader3);

		newsPublisher.publishNews("Ostatnie wiadomości na dziś.");
	}
}
