package de.thb.dim.pizzaPronto.valueObjects;

/**
 * DessertVO - Contains the Value Object of Desserts
 * Uebung 6 - 16.05.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class DessertVO extends DishVO implements Cloneable {
	
	
    /*
     * Constructors
     */
	public DessertVO() {
		
	}
	
	public DessertVO(int number, String name, float price) {
		super(number, name, price);
	}
	

	
	/*
	 * Helper / Generel Methods
	 */
    public DessertVO clone() {
        try {
            return (DessertVO) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
	public String getNameOfDish() {
		return super.getName();
	}
	
	public int getNumberOfDish() {
		return super.getNumber();
	}
}
