package org.wrzesien.lombok.lombokPractice;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.With;

@EqualsAndHashCode
@ToString
@With
public class Cat {
	@Getter
	String name0;

	@EqualsAndHashCode.Exclude // wykluczamy name1
	String name1;

	public Cat(final String name1, final String name0) {
		this.name1 = name1;
		this.name0 = name0;
	}

	public void consume(@NonNull final String whatToCustome) {
		System.out.println("Nothing");
	}
}
