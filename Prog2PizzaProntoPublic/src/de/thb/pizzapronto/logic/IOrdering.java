package de.thb.pizzapronto.logic;

import de.thb.pizzapronto.valueobjects.*;




public interface IOrdering {
	
	
	/*
	 * Helper / Generel Methods aka. abstract Methods
	 */
	public OrderVO startNewOrder(CustomerVO customer);
	public void addDish(DishVO dish);
	public void deleteDish();
	public float calculateTotalPrice();
	public void confirmOrder();	
}
