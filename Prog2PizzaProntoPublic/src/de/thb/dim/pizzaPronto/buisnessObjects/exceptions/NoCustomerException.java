package de.thb.dim.pizzaPronto.buisnessObjects.exceptions;


/**
 * NoCustomerException - Custom Exception
 * Uebung 10 - 15.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class NoCustomerException extends Exception {
	
	// FIXME serialVersionUID: NoCustomerException
	private long serialVersionUID = 1;
	
	
	
	public NoCustomerException() {
		super();
	}
	
	public NoCustomerException(String msg) {
		super(msg);
	}
}
