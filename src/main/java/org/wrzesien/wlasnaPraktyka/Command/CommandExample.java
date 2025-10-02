package org.wrzesien.wlasnaPraktyka.Command;

public class CommandExample {
	public static void main(final String[] args) {
		final Light light = new Light();

		final Command turnOn = new TurnOnLightCommand(light);
		final Command turnOff = new TurnOffLightCommand(light);

		final RemoteControl remote = new RemoteControl();

		remote.setCommand(turnOn);
		remote.pressButton();

		remote.setCommand(turnOff);
		remote.pressButton();
	}
}
