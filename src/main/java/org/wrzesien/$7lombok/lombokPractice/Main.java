package org.wrzesien.$7lombok.lombokPractice;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
	public static void main(final String[] args) {
		System.out.println("=== Start ===");
		final Dog dog = new Dog("dog", "doggy", "12");
		System.out.println(dog.withName("Marek"));

		final Employee employee = new Employee("Mar", "Bar", "m@m.pl", BigDecimal.ZERO, LocalDate.of(2024, 12, 12),
				"Strumykowa 37a");
		System.out.println(Employee.builder().name("Adam").surname("Broda").build());
	}
}