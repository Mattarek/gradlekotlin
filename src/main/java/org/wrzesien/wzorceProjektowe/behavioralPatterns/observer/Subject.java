package org.wrzesien.wzorceProjektowe.behavioralPatterns.observer;

public interface Subject {
	void subscribe(Observer observer);

	void unsubscribe(Observer observer);

	void notifyObservers(String news);
}