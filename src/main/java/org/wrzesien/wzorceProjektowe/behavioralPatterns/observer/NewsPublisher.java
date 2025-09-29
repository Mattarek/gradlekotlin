package org.wrzesien.wzorceProjektowe.behavioralPatterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewsPublisher implements Subject {
	private final List<Observer> observers = new ArrayList<>();

	@Override
	public void subscribe(final Observer observer) {
		if (Objects.isNull(observer)) {
			throw new NullPointerException("Observer is null!");
		}

		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	@Override
	public void unsubscribe(final Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(final String news) {
		for (final Observer observer : observers) {
			observer.update(news);
		}
	}

	// metoda publikacji wiadomości
	public void publishNews(final String news) {
		System.out.println("\n📰 Publikacja: " + news);
		notifyObservers(news);
	}
}