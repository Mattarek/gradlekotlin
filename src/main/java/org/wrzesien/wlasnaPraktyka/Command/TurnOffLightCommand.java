package org.wrzesien.wlasnaPraktyka.Command;

public class TurnOffLightCommand implements Command {
	private final Light light;

	public TurnOffLightCommand(final Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOff();
	}
}
