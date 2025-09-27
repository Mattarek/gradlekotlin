package org.wrzesien.$15mockowanie.$1przypomnenie.exception;

public class PaymentFailedException extends RuntimeException {
	public PaymentFailedException(final String message) {
		super(message);
	}
}
