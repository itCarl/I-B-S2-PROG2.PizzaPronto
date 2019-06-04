package de.thb.dim.pizzaPronto.valueObjects;

/**
 * DeliveryManVO - Contains the Value Object of Delivery Mans
 * Uebung 5 - 16.05.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class DeliveryManVO extends EmployeeVO {
	
	private String driverLicence;
	
	
	
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
		return super.toString() + " -> DeliveryMan [driverLicense=" + driverLicence + "]";
	}
	
	

	/**
	 * @return the driverLicense
	 */
	public String getDriverLicence() {
		return driverLicence;
	}

	/**
	 * @param driverLicense the driverLicense to set
	 */
	public void setDriverLicence(String driverLicence) {
		this.driverLicence = driverLicence;
	}
}
