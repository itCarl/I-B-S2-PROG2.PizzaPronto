package de.thb.dim.pizzaPronto.buisnessObjects.exceptions;


/**
 * NoOrderException - Custom Exception
 * Uebung 10 - 15.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class NoOrderException extends Exception {
	
	// FIXME serialVersionUID: NoOrderException
	private long serialVersionUID = 1L;
	
	
	
	public NoOrderException() {
		super();
	}
	
	public NoOrderException(String msg) {
		super(msg);
	}
}
