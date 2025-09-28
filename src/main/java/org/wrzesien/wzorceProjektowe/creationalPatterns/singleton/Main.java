package org.wrzesien.wzorceProjektowe.creationalPatterns.singleton;

public class Main {
	public static void main(final String[] args) {
		final ConfigManager config = ConfigManager.getInstance();
		final ConfigManager configTwo = ConfigManager.getInstance();
		config.setLanguage("EN");

		System.out.println(configTwo.getLanguage());
	}
}
