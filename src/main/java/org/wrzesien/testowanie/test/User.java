package org.wrzesien.testowanie.test;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@With
@Builder
@Value
public class User implements Comparable<User> {
	String name;
	String surname;
	String email;

	@Override
	public int compareTo(final User o) {
		return email.compareTo(o.email);
	}
}
