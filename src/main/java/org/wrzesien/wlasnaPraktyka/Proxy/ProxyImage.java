package org.wrzesien.wlasnaPraktyka.Proxy;

public class ProxyImage implements Image {
	private final String filename;
	private RealImage realImage;

	public ProxyImage(final String filename) {
		this.filename = filename;
	}

	@Override
	public void display() {
		if (realImage == null) {
			realImage = new RealImage(filename);
		}
		realImage.display();
	}
}
