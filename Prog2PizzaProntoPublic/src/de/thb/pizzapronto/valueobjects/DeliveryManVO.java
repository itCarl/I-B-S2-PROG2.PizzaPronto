package de.thb.pizzapronto.valueobjects;


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
