package org.wrzesien.$11designPattarns.KreacyjneWPraktyce.FactoryMethod;

public class ConcreteCreator extends Creator {
	public Product createProduct() {
		return new ConcreteProduct();
	}
}
