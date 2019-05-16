package de.thb.pizzapronto.valueobjects;
import java.awt.Color;


public class ChefVO extends EmployeeVO {

    private Color colorApron;
	
    
    /*
     * Constructors
     */
    public ChefVO() {
    	
    }

    public ChefVO(String personellNo, String lastName, String firstName) {
        super(personellNo, lastName, firstName);
    }
    
    
	/*
	 * Helper / General Methods
	 */
    @Override
	public String toString() {
		return super.toString() + " -> Chef [colorApron=" + colorApron + "]";
	}
    
    
	/**
	 * @return the colorApron
	 */
    public Color getColorApron() {
        return colorApron;
    }
    
	/**
	 * @return the colorApron
	 */
    public void setColorApron(Color colorApron) {
        if (colorApron == null)
            this.colorApron = Color.BLACK;
        else
            this.colorApron = colorApron;
    }
}
