package org.wrzesien.$12wersjeJavy.$3java16;

public record Person(
		String name,
		String surname,
		String age,
		String pesel) {
	public static final String COMMON = "COMMON";
	private static final Integer COUNTER;
	//🔹 Zasady final w Javie
	//	final oznacza, że zmienna może mieć wartość tylko raz.
	//	Nie trzeba przypisywać wartości od razu – ważne, żeby była przypisana przed użyciem.
	//	Kompilator Java pozwala na przypisanie final w:
	//	miejscu deklaracji, np. final int x = 5;
	//	lub w bloku inicjalizacyjnym (static initializer dla zmiennych statycznych, albo zwykły initializer dla pól instancji).
	//

	static {
		COUNTER = 100;
	}

	boolean isMature() {
		return Integer.parseInt(age) > 18;
	}

	@Override
	public String name() {
		return "Zwracam name po swojemu, bo nie podobami się ten z rekordu: " + name;
	}
}
