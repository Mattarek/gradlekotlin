package org.wrzesien.wzorceProjektowe.behavioralPatterns.singleton;

public class ConfigManager {
	private static ConfigManager instance;
	private String language = "PL";

	private ConfigManager() {
	}

	public static ConfigManager getInstance() {
		if (instance == null) {
			instance = new ConfigManager();
		}
		return instance;
	}

	// The same reference:
	public String getLanguage() {
		return language;
	}

	public void setLanguage(final String language) {
		this.language = language;
	}
}
