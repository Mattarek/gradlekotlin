package org.wrzesien.$11designPattarns.KreacyjneWPraktyce.Prototype;

record ConcretePrototype(String name) implements Prototype {

	@Override
	public Prototype clone() {
		return new ConcretePrototype(name + " (copy)");
	}
}