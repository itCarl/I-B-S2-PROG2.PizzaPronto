import java.awt.Color;


public class ChefVO {

    private String lastName;
    private String firstName;
    private Color colorApron;
	
    
    /*
     * Constructors
     */
    public ChefVO() {
    	
    }

    public ChefVO(String lastName, String firstName, Color colorApron) {
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setColorApron(colorApron);
    }
    
    
    /*
     * General Methods
     */
    public int hashCode() {
        final int hashMultiplier = 31;
        int result = 1;
        result = hashMultiplier * result + ((this.getcolorApron() == null) ? 0 : this.getcolorApron().hashCode());
        result = hashMultiplier * result + ((this.getLastName() == null) ? 0 : this.getLastName().hashCode());
        result = hashMultiplier * result + ((this.getFirstName() == null) ? 0 : this.getFirstName().hashCode());
        return result;
    }

    public boolean equals(Object other) {
        if (other == null)
            return false;

        if (other.getClass() == this.getClass()) {
        	ChefVO koch = (ChefVO) other;
            return this.hashCode() == koch.hashCode();
        }

        return false;
    }

    public String toString() {
        return "Koch " + this.getFirstName() + " " + this.getLastName() + " hat eine " + this.getcolorApron() + " Schürze";
    }
    
    
    /*
     * Getter & Setter
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Color getcolorApron() {
        return colorApron;
    }
    
    public void setColorApron(Color colorApron) {
        if (colorApron == null)
            this.colorApron = Color.BLACK;
        else
            this.colorApron = colorApron;
    }
}
