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
     * General Methods
     */
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

    public boolean equals(Object other) {
        if (other == null)
            return false;

        if (other.getClass() == this.getClass()) {
            CustomerVO kunde = (CustomerVO) other;
            return this.getId() == kunde.getId();
        }

        return false;
    }

    public String toString() {
        return "Kunde " + this.getFirstName() + " " + this.getLastName() + " ist " + this.getGender() + " und " + this.calculateAge() + " Jahre alt geboren am " + this.getDateOfBirthStr();
    }
    
    
    /*
     * Getter
     */
    public int getId() {
        return this.ID;
    }
    
	public static int getNextId() {
		return nextID;
	}
    
    public String getGender() {
        return gender;
    }
    
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    private String getDateOfBirthStr() {
        return this.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MMM.yyyy"));
    }
    
    
    /*
     * Setter
     */
    public void setGender(String gender) {
        this.gender = (gender == "männlich" || gender == "weiblich") ? gender : null;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;

        if (calculateAge() < 17)
            this.dateOfBirth = null;
    }
}
