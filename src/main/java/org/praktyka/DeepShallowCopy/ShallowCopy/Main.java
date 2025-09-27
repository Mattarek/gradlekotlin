package org.praktyka.DeepShallowCopy.ShallowCopy;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(final String[] args) {
		final List<String> hobbies = new ArrayList<>();
		hobbies.add("Pływanie");
		hobbies.add("Czytanie");

		final Person jan = new Person("Jan", hobbies);
		final Person anna = jan.shallowCopy();

		anna.addHobby("Bieganie");

		jan.show();
		anna.show();
	}
}
