package de.thb.pizzapronto.valueobjects;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class CustomerVO extends PersonVO{

    private static int nextID = 0; // global counter

    private final int ID;
    private String gender;		   // Men or Women 
    private LocalDate dateOfBirth; // Age > 17
    private OrderVO order;
    
    
    
    /*
     * Constructors
     */
    public CustomerVO() {
        this.ID = nextID++;
    }

    public CustomerVO(String lastName, String firstName) {
        this(); // call default constructor to add 1 to neachsteID
        this.setLastName(lastName);
        this.setFirstName(firstName);
    }

    public CustomerVO(String lastName, String firstName, String gender) {
        this(lastName, firstName);
        this.setGender(gender);
    }
    
    public CustomerVO(String lastName, String firstName, LocalDate dateOfBirth) {
        this(lastName, firstName);
        this.setDateOfBirth(dateOfBirth);
    }

    public CustomerVO(String lastName, String firstName, String gender, LocalDate dateOfBirth) {
        this(lastName, firstName, gender);
        this.setDateOfBirth(dateOfBirth);
    }
    
    public CustomerVO (String lastName, String firstName, String street, int houseNumber, String gender, LocalDate dateOfBirth) {
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
        hc = hashMultiplier * hc + this.calculateAge();
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

	@Override
	public String toString() {
		return "CustomerVO [ID=" + this.ID + ", gender=" + this.gender + ", dateOfBirth=" + this.dateOfBirth + ", order=" + this.order
				+ "]";
	}
	
    public short calculateAge() {
    	if (this.getDateOfBirth() == null)
    		return -1;
    	
    	short alter = (short) Period.between(this.getDateOfBirth(), LocalDate.now()).getYears();
    	
    	if (alter < 18) {
    		return -1;
    	} else {
    		return alter;    	
    	}
    }
	
	
	
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
    public void setGender(String gender) {
        this.gender = (gender == "männlich" || gender == "weiblich") ? gender : null;
    }

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;

        if (calculateAge() < 17)
            this.dateOfBirth = null;
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
