package de.thb.pizzapronto;

import java.time.*;
import de.thb.pizzapronto.logic.*;
import de.thb.pizzapronto.valueobjects.*;

/**
 * TestDriver - Used to test other classes
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
//TODO: Considdering to change to "Error First" - check Method
public class TestDriver {

	public static void main(String[] args) {
		
		// KUNDE 1
		CustomerVO ich = new CustomerVO("Mueller", "Affe", "Affenstraﬂe", 88, "men", null);
		
		// KUNDE 2
		CustomerVO ZweitesIch = new CustomerVO();
		
		// SPEISEKARTE
		MenuVO menu = new MenuVO();
		//System.out.println(menu.toString());		// Display all Pizzas that are on the Menu
		
		// BESTELLUNG
		Ordering order01 = new Ordering();
		order01.startNewOrder(ich);
		order01.addDish(menu.getDish(11));			// Add Dish with id 11 to the Shopping Basket
		order01.addDish(menu.getDish(3));			// Add Dish with id  3 to the Shopping Basket
		order01.addDish(menu.getDish(15));			// Add Dish with id 15 to the Shopping Basket
		order01.addDish(menu.getDish(5));			// Add Dish with id  5 to the Shopping Basket
		order01.addDish(menu.getDish(0));			// Add Dish with id  0 to the Shopping Basket
		order01.addDish(menu.getDish(1));			// Add Dish with id  1 to the Shopping Basket
		order01.confirmOrder();
		
		order01.startService();
		order01.startService();
		order01.startService();		
	}

}
