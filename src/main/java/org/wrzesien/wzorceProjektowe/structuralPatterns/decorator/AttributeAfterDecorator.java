package org.wrzesien.wzorceProjektowe.structuralPatterns.decorator;

import javax.management.Attribute;

public class AttributeAfterDecorator extends AttributeDecorator {
	public AttributeAfterDecorator(final Attribute attribute) {
		super(attribute);
	}

	public String getKey() {
		return "key";
	}
}
