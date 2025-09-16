package org.wrzesien.$12wersjeJavy.$3java16;

public class Outer {
	public static void main(final String[] args) {
		final Outer outer = new Outer();
		final Outer.Inner inner = outer.new Inner();
		inner.call();
	}

	class Inner {
		public static int a = 2;

		public void call() {
			System.out.println(a);
		}
	}
}
