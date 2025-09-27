package org.praktyka.DeepShallowCopy.DeepCopy;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(final String[] args) {
		final List<String> hobbies = new ArrayList<>();
		hobbies.add("Pływanie");
		hobbies.add("Czytanie");

		final Person jan = new Person("Jan", hobbies, 18);
		final Person anna = jan.copy();

		anna.addHobby("Bieganie");
		anna.addHobby("Skakanie");

		jan.show();
		anna.show();
	}
}
