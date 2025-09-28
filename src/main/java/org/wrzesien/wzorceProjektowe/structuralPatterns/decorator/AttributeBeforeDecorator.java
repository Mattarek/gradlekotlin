package org.wrzesien.wzorceProjektowe.structuralPatterns.decorator;

import javax.management.Attribute;

public class AttributeBeforeDecorator extends AttributeDecorator {
	public AttributeBeforeDecorator(final Attribute attribute) {
		super(attribute);
	}

	public String getKey() {
		return "key";
	}
}
