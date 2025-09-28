package org.wrzesien.wzorceProjektowe.creationalPatterns.prototype;

public class PrototypeExample {
	public static void main(final String[] args) {
		final Enums goblin = new Enums("Goblin", 100);
		final Enums goblinClone = goblin.copy();
		final Enums goblinCloneTwo = goblin.copy();
		goblin.setHp(150);
		goblinClone.setHp(210);

		goblin.show();
		goblinClone.show();
		goblinCloneTwo.show();
	}
}
