package de.thb.dim.pizzaPronto.valueObjects.exceptions;

/**
 * CustomerNoDateOfBirthException - Custom Exception
 * Uebung 10 - 15.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class CustomerNoDateOfBirthException extends Exception {
	
	// FIXME serialVersionUID: CustomerNoDateOfBirthException
	private long serialVersionUID = 1;
	
	
	
	public CustomerNoDateOfBirthException() {
		super();
	}
	
	public CustomerNoDateOfBirthException(String msg) {
		super(msg);
	}
}
