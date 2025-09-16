package org.wrzesien.$12wersjeJavy.$3java16;

public sealed class Animal permits Cat, Monkey, Dog {
	String firstName;
	String lastName;

	public Animal(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
