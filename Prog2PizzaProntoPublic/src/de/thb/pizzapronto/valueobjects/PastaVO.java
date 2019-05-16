package de.thb.pizzapronto.valueobjects;


public class PastaVO extends DishVO {
	
	private int typeOfPasta;
	
	
	
    /*
     * Constructors
     */
	public PastaVO() {
		
	}
	
	public PastaVO(int number, String name, String[] ingredients, float price, int typeOfPasta) {
		super(number, name, ingredients, price);
		this.setTypeOfPasta(typeOfPasta);
	}

	
	
//TODO: Übung 6 -> clone Method
	/*
	 * Helper / General Methods
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + typeOfPasta;
		return result;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (obj.getClass() == this.getClass()) {
            PastaVO pasta = (PastaVO) obj;
            return this.hashCode() == pasta.hashCode();
        }

        return false;
    }
	
	@Override
	public String toString() {
		return super.toString() + " -> PastaVO [typeOfPasta=" + typeOfPasta + "]";
	}
	
	public String getNameOfDish() {
		return super.getName();
	}
	
	public int getNumberOfDish() {
		return super.getNumber();
	}

	
	
	/**
	 * @return the typeOfPasta
	 */
	public int getTypeOfPasta() {
		return typeOfPasta;
	}

	/**
	 * @param typeOfPasta the typeOfPasta to set
	 */
	public void setTypeOfPasta(int typeOfPasta) {
		this.typeOfPasta = typeOfPasta;
	}
}
