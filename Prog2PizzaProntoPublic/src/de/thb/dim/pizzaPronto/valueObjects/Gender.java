package de.thb.dim.pizzaPronto.valueObjects;


/**
 * Gender - Represents all posible genders
 * Uebung 09 - 04.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public enum Gender {
	
    M(1),
    F(2),
    I(3),
    U(4);
	
	private int number;
	
	/*
	 * Helper / General Methods
	 */
	private Gender (int number) {
		this.number = number;
	}
	
	public int toNumber() {
		
		if(this.number == 0 || this.number == 1) {
			return 1;
		}
		
		return this.number;
	}
	
	public String toString() {
		//return "ordinal" + this.F.ordinal();
		
		switch(this.number) {
		case 1:
			return "male";
		case 2:
			return "female";
		case 3:
			return "intersex";
		case 4:
			return "unkown";
		default:
			return null;
		}
	}
}
