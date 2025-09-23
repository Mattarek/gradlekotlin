package org.wrzesien.$11designPattarns.KreacyjneWPraktyce.Singleton;

public class Singleton {
	private static final Singleton INSTANCE = new Singleton();
	private final String host = "localhost";

	private Singleton() {
	}

	public static Singleton getInstance() {
		return INSTANCE;
	}

	public String getHost() {
		return host;
	}
}
