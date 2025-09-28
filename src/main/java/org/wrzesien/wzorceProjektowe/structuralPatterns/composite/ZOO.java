package org.wrzesien.wzorceProjektowe.structuralPatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class ZOO implements Animal {

	private final List<Animal> animals = new ArrayList<>();

	@Override
	public void eat(final Food food) {
		animals.forEach(animal -> animal.eat(food));
	}

	public void add(final Animal animal) {
		animals.add(animal);
	}

	public void remove(final String id) {
		animals.remove(id);
	}

	public void clear() {
		animals.clear();
	}
}
