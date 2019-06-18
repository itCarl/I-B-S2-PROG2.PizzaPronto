package de.thb.dim.pizzaPronto.controller;

import java.util.List;

import de.thb.dim.pizzaPronto.buisnessObjects.exceptions.*;
import de.thb.dim.pizzaPronto.valueObjects.*;

/**
 * IOrdering - Interface for Orders
 * Uebung 07 - 16.05.2019
 * Uebung 09 - 05.06.2019
 * Uebung 10 - 15.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public interface IOrdering {
	
	
	/*
	 * Helper / Generel Methods aka. abstract Methods
	 */
	public OrderVO startNewOrder(CustomerVO customer);
	public void addDish(DishVO dish) throws NoOrderException;
	public void deleteDish(DishVO dish) throws NoOrderException;
	public float calculateTotalPrice() throws NoOrderException;
	public void confirmOrder() throws NoOrderException, NoCustomerException;	
	public List<DishVO> sortShoppingBasket() throws NoOrderException;
	public List<DishVO> sortShoppingBasketByNumber() throws NoOrderException;
	public List<DishVO> sortShoppingBasketByPrice() throws NoOrderException;
}
