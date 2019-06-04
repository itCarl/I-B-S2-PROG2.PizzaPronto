package de.thb.dim.pizzaPronto.valueObjects;

import java.awt.Color;

/**
 * ChefVO - Contains the Value Object of Chefs
 * Uebung 2 - 16.05.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class ChefVO extends EmployeeVO {

    private Color colorApron;
	
    
    
    /*
     * Constructors
     */
    public ChefVO() {
    	this(null, null, null);
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
