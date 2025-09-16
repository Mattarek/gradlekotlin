package org.wrzesien.$12wersjeJavy.$3java14;

public class Main {
	public static void main(final String[] args) {
		oldSwitch("B");
	}

	private static void oldSwitch(final String input) {
		final int result = switch (input) {
			case "A", "B", "C":
				yield 1;
			case "D", "E", "F":
				yield 2;
			default:
				yield 0;
		};
		System.out.println("New switch: " + result);

		final String lineSeparator = "Hello" + System.lineSeparator() + "na zajavce!";
		System.out.println(lineSeparator);
	}
}

