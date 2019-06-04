package de.thb.dim.pizzaPronto.valueObjects;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * DishVO - Contains the Value Object of Dishes
 * Uebung 06 - 16.05.2019
 * Uebung 09 - 04.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public abstract class DishVO implements Cloneable, Comparable {

	protected int number;
	protected String name;
	protected ArrayList<String> ingredients;
	protected float price;
	
	
	
    /*
     * Constructors
     */
    public DishVO() {
    	this(0, null, null, 0);
    }
    
    public DishVO(int number, String name, float price) {
    	this(number, name, null, price);
    }
    
    public DishVO(int number, String name, ArrayList<String> ingredients, float price) {
    	this.setNumber(number);
    	this.setName(name);
    	this.setIngredients(ingredients);
    	this.setPrice(price);
    }
    
    
    
    /*
     * Abstract Methods
     */
    public abstract String getNameOfDish();
    public abstract int getNumberOfDish();
    

    
	/*
	 * Helper / General Methods
	 */
//    public DishVO clone() {
//        try {
//            return (DishVO) super.clone();
//        } catch (CloneNotSupportedException e) {
//            return null;
//        }
//    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + Arrays.hashCode(ingredients);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + Float.floatToIntBits(price);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj.getClass() == this.getClass()) {
        	DishVO dish = (DishVO) obj;
            return this.hashCode() == dish.hashCode();
        }

        return false;
	}
	

	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
	@Override
	public String toString() {
		return "DishVO [number=" + this.number + ", name=" + name + ", ingredients=" + this.ingredientsToString()
				+ ", price=" + price + "]";
	}
	
	public String ingredientsToString() {
		// could have used stringBuffer
		String s = "";
		
		// alternative -> for(String i : this.ingredients) {}
		
		if(this.ingredients != null)
			for(int i = 0; i < this.ingredients.size(); i++) {
				s += this.ingredients.get(i);
				
				//XXX: just for Beauty porpuses
				if((i+1) < this.ingredients.size())
					s += ", ";
			}
		
		return s;
		// return Arrays.toString(ingredients);
	}
	
	
	
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the ingredients
	 */
	public ArrayList<String> getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(ArrayList<String> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
}
