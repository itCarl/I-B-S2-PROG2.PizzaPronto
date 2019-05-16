package de.thb.pizzapronto.valueobjects;


public class PizzaVO extends DishVO implements Cloneable {
	
    private int size;

    
    
    /*
     * Constructors
     */    
    public PizzaVO() {
    }

    public PizzaVO(int number, String name, String[] ingredients, float price) {
    	super(number, name, ingredients, price);
    }
    
    public PizzaVO(int number, String name, String[] ingredients, float price, int size) {
    	super(number, name, ingredients, price);
    	this.setSize(size);
    }
    
    
    
//TODO: Übung 6 -> clone Method
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
		return "PizzaVO [size=" + size + "]";
	}
    
	public String getNameOfDish() {
		return super.getName();
	}
	
	public int getNumberOfDish() {
		return super.getNumber();
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
