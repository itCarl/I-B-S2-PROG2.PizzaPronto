package de.thb.dim.pizzaPronto.controller;

import java.time.*;
import java.util.Random;
import de.thb.dim.pizzaPronto.buisnessObjects.*;
import de.thb.dim.pizzaPronto.valueObjects.*;

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
		//Ordering order = new Ordering();
		//DishVO RandomDish00 = menu.getDish(random.nextInt(MenuVO.getNumberOfDishes()));	// Generate a Random Dish
		//DishVO RandomDish01 = menu.getDish(random.nextInt(MenuVO.getNumberOfDishes()));	// Generate a Random Dish
		
		// other tests
		System.out.println(Gender.M);
		
	}
	
}
