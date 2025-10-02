package org.wrzesien.wlasnaPraktyka.Singleton;

public class SingletonThreatSafe {
	private static SingletonThreatSafe singletonThreatSafe;

	private SingletonThreatSafe() {
	}

	public static synchronized SingletonThreatSafe getInstance() {
		if (singletonThreatSafe == null) {
			return new SingletonThreatSafe();
		}

		return singletonThreatSafe;
	}
}
