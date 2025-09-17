package org.wrzesien.$11designPattarns.PrzykladowyProjekt.util;

import lombok.NonNull;

public class ValidationUtils {
	public static String requireNonEmpty(@NonNull final String value, @NonNull final String name) {
		if (value == null) {
			throw new IllegalArgumentException(name + " cannot be null");
		}
		final String t = value.trim();

		if (t.isEmpty()) {
			throw new IllegalArgumentException(name + " cannot be empty");
		}
		return t;
	}
}
