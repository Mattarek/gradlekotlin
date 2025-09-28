package org.wrzesien.wzorceProjektowe.structuralPatterns.decorator;

import javax.management.Attribute;

public abstract class AttributeDecorator extends Attribute {

	private final Attribute attribute;

	public AttributeDecorator(final Attribute attribute) {
		super(attribute.getName(), attribute.getValue());
		this.attribute = attribute;
	}
}
