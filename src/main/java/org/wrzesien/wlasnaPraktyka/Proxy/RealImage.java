package org.wrzesien.wlasnaPraktyka.Proxy;

public class RealImage implements Image {
	private final String filename;

	public RealImage(final String filename) {
		this.filename = filename;
		loadFromDisk();
	}

	private void loadFromDisk() {
		System.out.println("Loading " + filename);
	}

	@Override
	public void display() {
		System.out.println("Displaying " + filename);
	}
}
