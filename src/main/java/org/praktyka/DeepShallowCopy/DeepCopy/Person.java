package org.praktyka.DeepShallowCopy.DeepCopy;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private final String name;
	private final List<String> hobbies;

	public Person(final String name, final List<String> hobbies) {
		this.name = name;
		this.hobbies = hobbies;
	}

	public Person(final Person other) {
		name = other.name;
		hobbies = new ArrayList<>(other.hobbies);
	}

	public Person copy() {
		return new Person(this);
	}

	public void addHobby(final String hobby) {
		hobbies.add(hobby);
	}

	public void show() {
		System.out.println(name + ": " + hobbies);
	}
}
