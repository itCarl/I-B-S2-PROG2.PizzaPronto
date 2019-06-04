package de.thb.dim.pizzaPronto.controller;

import de.thb.dim.pizzaPronto.valueObjects.*;

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
	public void deleteDish(DishVO dish);
	public float calculateTotalPrice();
	public void confirmOrder();	
}
