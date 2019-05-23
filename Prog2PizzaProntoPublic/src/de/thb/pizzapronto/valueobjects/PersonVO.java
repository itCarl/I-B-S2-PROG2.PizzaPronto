package de.thb.pizzapronto.valueobjects;

/**
 * PersonVO - Contains the Value Object of Persons
 * Uebung 5 - 23.05.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public abstract class PersonVO {
	
	protected String lastName;
	protected String firstName;
	protected String street;
	protected int houseNumber;
	
	
	
	/*
	 * Constructors
	 */
	public PersonVO() {
		
	}
	
	public PersonVO(String lastName, String firstName) {
		this.setLastName(lastName);
		this.setFirstName(firstName);
	}
	
	public PersonVO(String lastName, String firstName, String street, int houseNumber) {
		this(lastName, firstName);
		this.setStreet(street);
		this.setHouseNumber(houseNumber);
	}
	
	
	
	/*
	 * Helper / General Methods
	 */
	@Override
	public String toString() {
		return "Person [lastName=" + this.lastName + ", firstName=" + this.firstName + ", street=" + this.street + ", houseNumber="
				+ this.houseNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = prime * result + this.houseNumber;
		result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj.getClass() == this.getClass()) {
        	PersonVO person = (PersonVO) obj;
            return this.hashCode() == person.hashCode();
        }

        return false;
	}

	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the houseNumber
	 */
	public int getHouseNumber() {
		return houseNumber;
	}

	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	
}
