package org.wrzesien.$12wersjeJavy.$3java9;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(final String[] args) {
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
