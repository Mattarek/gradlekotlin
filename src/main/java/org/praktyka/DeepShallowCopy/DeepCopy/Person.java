package org.praktyka.DeepShallowCopy.DeepCopy;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private final String name;
	private final List<String> hobbies;
	private final int age;

	public Person(final String name, final List<String> hobbies, final int age) {
		this.name = name;
		this.hobbies = hobbies;
		this.age = age;
	}

	public Person(final Person other) {
		name = other.name;
		age = other.age;
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
