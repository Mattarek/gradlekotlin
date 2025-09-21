package org.wrzesien.$14Spring.Intro.code;

import org.springframework.stereotype.Service;

@Service
public class InjectedBean {
	public InjectedBean() {
		System.out.println("Calling InjectedBean");
	}

	public void someMethod() {
		System.out.println("SomeMethod().");
	}
}
