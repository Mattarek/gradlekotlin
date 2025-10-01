package org.wrzesien.wzorceProjektowe.behavioralPatterns.chainOfResponsibility;

public abstract class Approver {
	protected Approver next;

	public void setNext(final Approver next) {
		this.next = next;
	}

	public abstract void approve(int amount);
}
