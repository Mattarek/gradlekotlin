package org.wrzesien.$14SpringBean.$3SpringBeansProblem.code;

import java.time.LocalTime;

public class SingletonBean {
	private final PrototypeBean prototypeBean;

	public SingletonBean(final PrototypeBean prototypeBean) {
		this.prototypeBean = prototypeBean;
		System.out.println("Calling SingletonBean();");
	}

	public PrototypeBean callPrototype() {
		System.out.println("Calling prototype: " + LocalTime.now());
		return prototypeBean;
	}
}
