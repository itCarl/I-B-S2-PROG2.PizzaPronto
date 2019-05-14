

public class DessertVO extends DishVO {
	
	
    /*
     * Constructors
     */
	public DessertVO() {
		
	}
	
	public DessertVO(int number, String name, float price) {
		super(number, name, price);
	}
	
	
//TODO: Übung 6 -> clone Method	
	/*
	 * Helper / Generel Methods
	 */

	public String getNameOfDish() {
		return super.getName();
	}
	
	public int getNumberOfDish() {
		return super.getNumber();
	}
	
	
}
