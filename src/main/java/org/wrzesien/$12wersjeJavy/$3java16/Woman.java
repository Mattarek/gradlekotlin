package org.wrzesien.$12wersjeJavy.$3java16;

public record Woman(String firstName, String lastName) {
	public Woman withFirstName(final String firstName) {
		return new Woman(firstName, lastName);
	}

	public Woman withLastName(final String lastName) {
		return new Woman(firstName, lastName);
	}
}
