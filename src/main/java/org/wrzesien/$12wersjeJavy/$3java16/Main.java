package org.wrzesien.$12wersjeJavy.$3java16;

public class Main {
	public static void main(final String[] args) {
		//		final Person person = new Person("Marcin", "Barć", "16", "11223344455");
		//		System.out.println(person.name());
		//		System.out.println(person.surname());
		//		System.out.println(person.age());
		//
		//		final Woman woman = new Woman("a", "a");
		//		final Woman woman1 = woman.withFirstName("b").withLastName("b");
		//		System.out.println(woman1);

		// Pattern matching instanceof
		// final Cat cat = new Cat("qwe", "qaz");
		// method(cat);

		// Dzieki niemu mamy:
		method(new Cat("qwe", "qaz"));
		method(new Dog("qwe", "qaz"));
	}

	static void method(final Animal animal) {
		// Pattern matching instanceof
		// dzięki niemu ne musimy robic:
		if (animal instanceof final Cat cat) {
			cat.mrr();
		}

		// Przed 17
		//		if (animal instanceof final Cat cat) {
		//			System.out.println("Here is Cat");
		//		} else if (animal instanceof final Dog dog) {
		//			System.out.println("Here is Dog");
		//		} else if (animal instanceof final Monkey monkey) {
		//			System.out.println("Here is Monkey");
		//		} else {
		//			System.out.println("No idea!");
		//		}

		// Od 17:
		switch (animal) {
			case final Cat cat -> System.out.println("Here is CAT");
			case final Dog dog -> System.out.println("Here is DOG");
			case final Monkey monkey -> System.out.println("Here is Monkey");
			case null, default -> System.out.println("No idea!");
		}
	}
}
