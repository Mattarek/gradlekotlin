package org.wrzesien.wlasnaPraktyka.Command;

public class RemoteControl {
	private Command command;

	public void setCommand(final Command command) {
		this.command = command;
	}

	public void pressButton() {
		command.execute();
	}
}
