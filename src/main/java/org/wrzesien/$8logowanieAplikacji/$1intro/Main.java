package org.wrzesien.$8logowanieAplikacji.$1intro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(final String[] args) {
		logger.trace("This is a TRACE message");
		logger.debug("This is a DEBUG message");
		logger.info("This is an INFO message");
		logger.warn("This is a WARN message");
		logger.error("This is an ERROR message");

		simulateWork();
	}

	private static void simulateWork() {
		logger.info("Starting some work...");

		try {
			Thread.sleep(1000);
			logger.debug("Work in progress...");
			Thread.sleep(1000);
			logger.info("Work finished successfully!");
		} catch (final InterruptedException e) {
			logger.error("Work was interrupted", e);
		}
	}

	@Override
	public String toString() {
		return "Main{}";
	}
}