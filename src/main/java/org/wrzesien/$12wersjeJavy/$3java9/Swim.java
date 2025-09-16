package org.wrzesien.$12wersjeJavy.$3java9;

public interface Swim {

	default void someMethod() {
		areYouReady();
	}

	private boolean areYouReady() {
		return true;
	}
}
