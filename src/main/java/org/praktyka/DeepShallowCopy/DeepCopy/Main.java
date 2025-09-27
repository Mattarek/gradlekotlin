package org.praktyka.DeepShallowCopy.DeepCopy;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(final String[] args) {
		final List<String> hobbies = new ArrayList<>();
		hobbies.add("Pływanie");
		hobbies.add("Czytanie");

		final Person jan = new Person("Jan", hobbies);
		final Person anna = jan.copy();

		anna.addHobby("Bieganie");

		jan.show();
		anna.show();
	}
}
