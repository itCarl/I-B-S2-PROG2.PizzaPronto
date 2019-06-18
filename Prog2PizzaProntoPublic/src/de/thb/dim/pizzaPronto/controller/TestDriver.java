package de.thb.dim.pizzaPronto.controller;

import java.io.*;
import java.time.*;
import java.util.Random;
import de.thb.dim.pizzaPronto.buisnessObjects.*;
import de.thb.dim.pizzaPronto.buisnessObjects.exceptions.*;
import de.thb.dim.pizzaPronto.buisnessObjects.io.*;
import de.thb.dim.pizzaPronto.valueObjects.*;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.*;

/**
 * TestDriver - Used to test other classes
 * 18.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
//TODO: Considdering to change to "Error First" - check Method
public class TestDriver {

	public static void main(String[] args) throws CustomerTooYoungException, CustomerNoDateOfBirthException, NoOrderException, IOException {
		Random random0 = new Random();
		Random random1 = new Random();
		Serializer seri = new Serializer("Order.ser");
		
		// KUNDE 1
		LocalDate t1 = LocalDate.of(2000, 12, 31);
		CustomerVO ich = new CustomerVO("Mueller", "Affe", "Affenstraﬂe", 88, Gender.M, t1);
		
		
		// KUNDE 2
		LocalDate t2 = LocalDate.of(1998, 12, 31);
		CustomerVO ZweitesIch = new CustomerVO("Mueller", "Bffe", "Affenstraﬂe", 44, Gender.F, t2);
		
		// KOCH 1
		ChefVO koch = new ChefVO();
		
		// SPEISEKARTE
		// MenuVO menu = new MenuVO();
		//System.out.println(menu.toString());		// Display all Pizzas that are on the Menu
		
		
		/*
		 *  BESTELLUNGEN
		 */
		Ordering order = new Ordering();
		DishVO RandomDish00 = order.getMenu().getDish(random0.nextInt(order.getMenu().getNumberOfDishes()));	// Generate a Random Dish
		DishVO RandomDish01 = order.getMenu().getDish(random1.nextInt(order.getMenu().getNumberOfDishes()));	// Generate a Random Dish
		
		
		// other tests
		//System.out.println(Gender.U);

		// IMPORT MENU
		MenuImporter im = new MenuImporter();
		
		
		order.startNewOrder(ich);
		order.addDish(order.getMenu().getDish(3));
		//order.addDish(order.getMenu().getDish(10));
		//order.addDish(order.getMenu().getDish(16));
		System.out.println(order.getCurrentOrder().shoppingBasketToString());
		
		// Spacer
		System.out.println("<=======================================>\n");
		
		// Sorting
		order.sortShoppingBasketByPrice();
				
		
		// Serializer Test		
		seri.serializeOrder(order.getCurrentOrder());
		
		OrderVO or = seri.deserializeOrder();
		
		System.out.println(or.shoppingBasketToString());
		
	}
	
}
