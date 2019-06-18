package de.thb.dim.pizzaPronto.valueObjects.exceptions;

/**
 * CustomerTooYoungException - Custom Exception
 * Uebung 10 - 15.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class CustomerTooYoungException extends Exception {
	
	// FIXME serialVersionUID: CustomerTooYoungException
	private long serialVersionUID = 1;
	
	
	
	public CustomerTooYoungException() {
		super();
	}
	
	public CustomerTooYoungException(String msg) {
		super(msg);
	}
}
