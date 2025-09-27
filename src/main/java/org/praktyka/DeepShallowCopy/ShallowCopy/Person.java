package org.praktyka.DeepShallowCopy.ShallowCopy;

import java.util.List;

public class Person {
	String name;
	List<String> hobbies;

	public Person(final String name, final List<String> hobbies) {
		this.name = name;
		this.hobbies = hobbies;
	}

	public Person shallowCopy() {
		return new Person(name, hobbies);
	}

	public void addHobby(final String hobby) {
		hobbies.add(hobby);
	}

	public void show() {
		System.out.println(name + ": " + hobbies);
	}
}
