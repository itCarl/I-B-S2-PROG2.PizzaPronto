package de.thb.pizzapronto.valueobjects;

/**
 * DeliveryManVO - Contains the Value Object of Delivery Mans
 * Uebung 5 - 16.05.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class DeliveryManVO extends EmployeeVO {
	
	private String driverLicense;
	
	
	
	/*
     * Constructors
     */
    public DeliveryManVO() {
    	this(null, null, null);
    }

    public DeliveryManVO(String personellNo, String lastName, String firstName) {
        super(personellNo, lastName, firstName);
    }
    
    
    
	/*
	 * Helper / General Methods
	 */
	@Override
	public String toString() {
		return super.toString() + " -> DeliveryMan [driverLicense=" + driverLicense + "]";
	}
}
