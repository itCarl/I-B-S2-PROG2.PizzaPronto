package de.thb.dim.pizzaPronto.valueObjects;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerNoDateOfBirthException;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerTooYoungException;

/**
 * CustomerVO - Contains the Value Object of Customer
 * Uebung 02 - 04.06.2019
 * Uebung 10 - 15.06.2019
 * Uebung 11 - 17.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class CustomerVO extends PersonVO implements Serializable {

    private static int nextID = 0; // global counter

    private final int ID;
    private Gender gender;
    private LocalDate dateOfBirth; // Age > 17
    private OrderVO order;
    
    
    
    /*
     * Constructors
     */
    /*
    public CustomerVO() throws CustomerTooYoungException, CustomerNoDateOfBirthException {
        this(null, null, null, 0, null, null);
    }
    */

    public CustomerVO(String lastName, String firstName) throws CustomerTooYoungException, CustomerNoDateOfBirthException {
    	this(lastName, firstName, null, 0, null, null);
    }

    public CustomerVO(String lastName, String firstName, Gender gender) throws CustomerTooYoungException, CustomerNoDateOfBirthException {
        this(lastName, firstName, null, 0, gender, null);
    }
    
    public CustomerVO(String lastName, String firstName, LocalDate dateOfBirth) throws CustomerTooYoungException, CustomerNoDateOfBirthException {
        this(lastName, firstName, null, 0, null, dateOfBirth);
    }

    public CustomerVO(String lastName, String firstName, Gender gender, LocalDate dateOfBirth) throws CustomerTooYoungException, CustomerNoDateOfBirthException {
    	this(lastName, firstName, null, 0, gender, dateOfBirth);
    }
    
    public CustomerVO (String lastName, String firstName, String street, int houseNumber, Gender gender, LocalDate dateOfBirth) throws CustomerTooYoungException, CustomerNoDateOfBirthException {
    	super(lastName, firstName, street, houseNumber);  
    	this.ID = nextID++;
    	this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
    }

    
    
    /*
     * Helper / General Methods
     */
    @Override
    public int hashCode() {
        final int hashMultiplier = 31;
        int hc = 1;
        
        try {
			hc = hashMultiplier * hc + this.calculateAge();
		} catch (CustomerNoDateOfBirthException e) {
			e.printStackTrace();
		}
        
        hc = hashMultiplier * hc + ((this.getDateOfBirth() == null) ? 0 : this.getDateOfBirth().hashCode());
        hc = hashMultiplier * hc + ((this.getGender() == null) ? 0 : this.getGender().hashCode());
        hc = hashMultiplier * hc + ((this.getLastName() == null) ? 0 : this.getLastName().hashCode());
        hc = hashMultiplier * hc + ((this.getFirstName() == null) ? 0 : this.getFirstName().hashCode());
        return hc;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;

        if (other.getClass() == this.getClass()) {
            CustomerVO kunde = (CustomerVO) other;
            return this.getID() == kunde.getID();
        }

        return false;
    }
	
    //TODO: dobToString -> exceptions Internal error: no date of birth
    @Override
	public String toString() {
		return super.toString() + " -> CustomerVO [ID=" + this.ID + ", gender=" + this.gender + ", dateOfBirth=" + this.dateOfBirth + ", order=" + this.order + "]";
	}

	public short calculateAge() throws CustomerNoDateOfBirthException {
    	if (this.getDateOfBirth() == null)
    		throw new CustomerNoDateOfBirthException("Internal error: No date of birth.");
    	
    	short alter = (short) Period.between(this.getDateOfBirth(), LocalDate.now()).getYears();
    	
    	return alter;
    }
	
	
	
	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
    public void setGender(Gender gender) {
    	this.gender = gender;
    }

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 * @throws NullPointerExceptionn, dob must not be null
	 * @throws CustomerTooYoungException, customer must be older than 17
	 * @throws CustomerNoDateOfBirthException 
	 */
    public void setDateOfBirth(LocalDate dateOfBirth) throws CustomerTooYoungException, CustomerNoDateOfBirthException {
        
    	Objects.requireNonNull(dateOfBirth, "DateOfBirth must not be null");

    	this.dateOfBirth = dateOfBirth;
    	
        if (this.calculateAge() < 18)
            throw new CustomerTooYoungException("Customer is not an adult.");
    }

	/**
	 * @return the order
	 */
	public OrderVO getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(OrderVO order) {
		this.order = order;
	}

	/**
	 * @return the nextID
	 */
	public static int getNextID() {
		return nextID;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
}
