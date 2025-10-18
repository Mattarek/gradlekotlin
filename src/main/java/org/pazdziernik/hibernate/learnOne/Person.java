package org.pazdziernik.hibernate.learnOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private Integer personId;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Integer age;

	public void setPersonId(final Integer personId) {
		this.personId = personId;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setAge(final Integer age) {
		this.age = age;
	}
}
