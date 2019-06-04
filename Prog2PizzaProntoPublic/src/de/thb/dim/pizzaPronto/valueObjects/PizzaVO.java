package de.thb.dim.pizzaPronto.valueObjects;

import java.util.ArrayList;

/**
 * PizzaVO - Contains the Value Object of Pizzas
 * Uebung 02 - 16.05.2019
 * Uebung 09 - 04.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class PizzaVO extends DishVO implements Cloneable {
	
    private int size;

    
    
    /*
     * Constructors
     */    
    public PizzaVO() {
    }

    public PizzaVO(int number, String name, ArrayList<String> ingredients, float price) {
    	super(number, name, ingredients, price);
    }
    
    public PizzaVO(int number, String name, ArrayList<String> ingredients, float price, int size) {
    	super(number, name, ingredients, price);
    	this.setSize(size);
    }
    
    

    /*
     * General Methods
     */
    public PizzaVO clone() {
        try {
            return (PizzaVO) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PizzaVO other = (PizzaVO) obj;
		if (size != other.size)
			return false;
		return true;
	}

    @Override
	public String toString() {
		return "PizzaVO [name="+ this.getNameOfDish() +",size="+ this.size +"]";
	}
    
	public String getNameOfDish() {
		String s = "";
		
		switch (this.size) {
		case 1:
			s = "Normal";
			break;
		case 2:
			s = "Grande";
			break;
		default:
			s = "Fehler";
		}
		
		return "Pizza " + this.name + " - " + s;
	}
	
	public int getNumberOfDish() {
		return this.number * 10 + this.size;
	}
	
	

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	/*
	private String getIngredientsString() {
        String ingredientsString = "";

        if (this.getIngredients().length == 1) {
            ingredientsString = this.getIngredients()[0];
        } else {
            for (int i = 0; i < this.getIngredients().length - 1; i++) {
                ingredientsString += this.getIngredients()[i] + ", ";
            }

            ingredientsString = ingredientsString.substring(0, ingredientsString.length() - 2);

            ingredientsString += " und " + this.getIngredients()[this.getIngredients().length - 1];
        }

        return ingredientsString;
    }
    */
	
}
