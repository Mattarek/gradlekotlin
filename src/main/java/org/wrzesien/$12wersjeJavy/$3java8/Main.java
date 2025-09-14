package org.wrzesien.$12wersjeJavy.$3java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(final String[] args) {
		final List<Integer> source = IntStream.rangeClosed(1, 14).boxed().collect(Collectors.toList());
		System.out.println(source);
		source.removeIf(element -> element % 2 != 0);
		source.forEach(element -> System.out.println("Next element: " + element));

		final Map<Integer, String> someMap = new HashMap<>();
		someMap.put(1, "1");
		someMap.put(2, "2");
		someMap.put(3, "3");
		someMap.put(4, "4");
		someMap.put(5, "5");
		System.out.println(someMap);
		someMap.replaceAll((key, value) -> value + "repleaced:k" + key);
		System.out.println(someMap);

		//----
		final List<String> listOne = new ArrayList<>(List.of("String1", "String2", "String3"));
		System.out.println(listOne);
		System.out.println(listOne.getClass());

		//------
		final List<String> strings = new ArrayList<>(Set.of("1", "2", "3"));
		System.out.println(strings);
		System.out.println(strings.getClass());
	}
}
