package org.wrzesien.wzorceProjektowe.structuralPatterns.bridge;

public class Green implements Color {
	@Override
	public String apply() {
		return "Color is green";
	}

	@Override
	public String toString() {
		return "Green{}";
	}
}
