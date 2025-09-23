package org.wrzesien.$11designPattarns.PrototypeInPractice;

public class BlackSheep implements Sheep {
	private String name;

	public BlackSheep(final String name) {
		this.name = name;
	}

	public BlackSheep(final BlackSheep other) {
		this(other.name);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}