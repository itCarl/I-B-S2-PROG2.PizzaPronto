package de.thb.pizzapronto.valueobjects;

/**
 * PastaVO - Contains the Value Object of Pastas
 * Uebung 6 - 16.05.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
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

	

	/*
	 * Helper / General Methods
	 */
    public PastaVO clone() {
        try {
            return (PastaVO) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    
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
		String s = "";
		
		switch (this.typeOfPasta) {
		case 4:
			s = "Spaghetti";
			break;
		case 5:
			s = "Tortellini";
			break;
		case 6:
			s = "Gnocchi";
			break;
		default:
			s = "Fehler";
		}
		
		return "Pasta " + this.name + " - " + s;
	}
	
	public int getNumberOfDish() {
		return this.number + this.typeOfPasta * 100;
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
