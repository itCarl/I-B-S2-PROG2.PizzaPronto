package de.thb.pizzapronto.logic;

import de.thb.pizzapronto.valueobjects.*;

/**
 * IOrdering - Interface for Orders
 * Uebung 7 - 16.05.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
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
