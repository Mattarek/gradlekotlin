package org.wrzesien.$12wersjeJavy.$3java9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(final String[] args) {
		//		//----
		//		final List<String> listOne = new ArrayList<>(List.of("String1", "String2", "String3"));
		//		System.out.println(listOne);
		//		System.out.println(listOne.getClass());
		//
		//		//------
		//		final List<String> strings = new ArrayList<>(Set.of("1", "2", "3"));
		//		System.out.println(strings);
		//		System.out.println(strings.getClass());
		//
		//		//-------
		// max 10, interface nie przewiduje więcej
		final Map<Integer, String> integerStringMap = new HashMap<>(Map.of(1, "1", 2, "2", 3, "3"));

		// Nieskończona ilosc
		final Map<Integer, String> integerStringMapEntries = new HashMap<>(Map.ofEntries(
				Map.entry(1, "1"),
				Map.entry(2, "2"),
				Map.entry(3, "3"),
				Map.entry(4, "4"),
				Map.entry(5, "5"),
				Map.entry(6, "6"),
				Map.entry(7, "7"),
				Map.entry(8, "8"),
				Map.entry(9, "9"),
				Map.entry(10, "10"),
				Map.entry(11, "11"),
				Map.entry(12, "13"),
				Map.entry(13, "13"),
				Map.entry(14, "14"),
				Map.entry(15, "15")
		));
		integerStringMap.put(4, "4");

		// nowe metody optionala
		// jako, że przekazujemy nulla, a null jests beztypowy, jest po prostu nullem, to możę to być
		// String, Integer i tak dalej, dlagego też Java przyjmuje najbardziej ogólny typ Object.
		//		final String result = Optional.<String>ofNullable(null).orElse("orElse");
		//
		//		final String resultORR = Optional.<String>ofNullable(null)
		//				.or(() -> Optional.of("123"))
		//				.orElse("Def");
		//
		//		final Optional<String> resultOR = Optional.<String>ofNullable(null)
		//				.or(() -> Optional.of("123"));
		//		System.out.println(resultORR);
		//		System.out.println(resultOR);
		//
		//		final List<Integer> resultOfStream = Optional.ofNullable("123")
		//				.stream()
		//				.map(Integer::valueOf)
		//				.toList();
		//
		//		System.out.println(resultOfStream);
		//
		//		Optional.ofNullable("abc")
		//				.ifPresentOrElse(Main::onPresent, Main::onEmpty);

		//		//=======================================================================================
		//		Stream.of(1, 2, 3, 4, 5, 6, 7)
		//				.takeWhile(element -> element % 2 != 0)
		//				.forEach(System.out::println);
		//
		//		IntStream
		//				.iterate(2, element -> element <= 256, element -> element * element)
		//				.forEach(System.out::println);
		//
		//		System.out.println(Stream.ofNullable(null).count());
		//		System.out.println(Stream.ofNullable("1").count());
		//
		//		final SomeAbstractClass someAbstractClass = new SomeAbstractClass() {
		//			final List<String> someList = new ArrayList<>();
		//
		//			@Override
		//			void call(final String p1, final String p2) {
		//				System.out.println("Running: " + p1 + "," + p2);
		//			}
		//		};
		//
		//		someAbstractClass.call("1", "2");
		//
		//		final var a = 1;
		//		final var b = 2.1;
		//		final var c = '3';
		//		final var d = "zajavka";
		//		final var e = true;

		final List<String> food = new ArrayList<>();
		food.add("Banana");
		food.add("Apple");
		food.add("Orange");
		System.out.println("Original: " + food);
		final List<String> foodCopiedImmutable = List.copyOf(food);
		System.out.println(foodCopiedImmutable);
	}

	private static void onPresent(final String input) {
		System.out.println("Calling on present: " + input);
	}

	private static void onEmpty() {
		System.out.println("Calling on empty.");
	}

	void beforeJava9() {
		try (final BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final IOException ioException) {
			ioException.getMessage();
		}
	}
}
