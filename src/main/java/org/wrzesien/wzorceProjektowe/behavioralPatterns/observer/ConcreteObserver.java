package org.wrzesien.wzorceProjektowe.behavioralPatterns.observer;

class Reader implements Observer {
	private final String name;

	public Reader(final String name) {
		this.name = name;
	}

	@Override
	public void update(final String news) {
		System.out.println(name + " otrzymał wiadomość: " + news);
	}
}