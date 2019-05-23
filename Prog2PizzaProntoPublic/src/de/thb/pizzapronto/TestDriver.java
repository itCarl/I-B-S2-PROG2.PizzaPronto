package de.thb.pizzapronto;

import java.time.*;
import java.util.Random;
import de.thb.pizzapronto.logic.*;
import de.thb.pizzapronto.valueobjects.*;

/**
 * TestDriver - Used to test other classes
 * 19.05.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
//TODO: Considdering to change to "Error First" - check Method
public class TestDriver {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Random random = new Random();
		
		
		// KUNDE 1
		CustomerVO ich = new CustomerVO("Mueller", "Affe", "Affenstraﬂe", 88, "men", null);
		
		// KUNDE 2
		CustomerVO ZweitesIch = new CustomerVO();
		
		// KOCH 1
		ChefVO koch = new ChefVO();
		
		// SPEISEKARTE
		MenuVO menu = new MenuVO();
		//System.out.println(menu.toString());		// Display all Pizzas that are on the Menu
		
		
		/*
		 *  BESTELLUNGEN
		 */
		Ordering order = new Ordering();
		DishVO RandomDish00 = menu.getDish(random.nextInt(menu.getNumberOfDishes()));	// Generate a Random Dish
		DishVO RandomDish01 = menu.getDish(random.nextInt(menu.getNumberOfDishes()));	// Generate a Random Dish
		
		// #1
		order.startNewOrder(ich);
		order.addDish(menu.getDish(11));		// Add Dish with id 11 to the Shopping Basket
		order.addDish(menu.getDish(3));			// Add Dish with id  3 to the Shopping Basket
		order.addDish(menu.getDish(15));		// Add Dish with id 15 to the Shopping Basket
		order.addDish(menu.getDish(5));			// Add Dish with id  5 to the Shopping Basket
		order.addDish(menu.getDish(0));			// Add Dish with id  0 to the Shopping Basket
		order.addDish(menu.getDish(0));			// Add Dish with id  0 to the Shopping Basket
		order.confirmOrder();
		
		order.startService();
		
		System.out.println("\n<=================================================================> \n");
		
		// #2
		order.startNewOrder(ZweitesIch);
		order.addDish(RandomDish00);			// Add a Random Dish
		order.addDish(RandomDish01);			// Add a Random Dish
		order.addDish(RandomDish00);			// Add a Random Dish
		
//		order.confirmOrder();
//		
//		order.startService();
		
		System.out.println("\n<=================================================================> \n");
		
		
		// Other tests
		String test;

		order.getCurrentOrder().setState("confirmed");
		Delivery d = new Delivery();
		test = d.startService(order.getCurrentOrder());
		
		Class<OrderVO> myOrderClass;
		myOrderClass = OrderVO.class;
		System.out.println(myOrderClass.getDeclaredField("shoppingBasket").getType().toString().equals("class de.thb.pizzapronto.valueobjects.DishVO"));
		
	}
	
}
