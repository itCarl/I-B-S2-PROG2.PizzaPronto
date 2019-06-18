package de.thb.dim.pizzaPronto.buisnessObjects.io;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

import de.thb.dim.pizzaPronto.valueObjects.*;

/**
 * MenuImporter - Used to Import a Menu from a text file
 * Uebung 11 - 18.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class MenuImporter {
	
	// FIXME MenuImporter: So unglaublich broke man glaubt es garnicht
	
	public MenuImporter(){
		
	}
	
	public LinkedList<DishVO> readMenu(String file) throws IOException {
		
		String[] w;
		String ln = null;
		DishVO currentDish = null;
		ArrayList<String> ingredients = null;
		LinkedList<DishVO> menu = new LinkedList<DishVO>();
		BufferedReader f = new BufferedReader(new FileReader(new File(file)));
		
		
		// Read each line from the Menu File
		while( (ln = f.readLine()) != null) {
			w = ln.split(":");
			
			if(w[0].equals("dish.type")) {
				ingredients = new ArrayList<String>();
				
				if(w[1].equals("Pizza")) {
					currentDish = new PizzaVO();
					
				} else if(w[1].equals("Pasta")) {
					currentDish = new PastaVO();
					
				} else if(w[1].equals("Dessert")) {
					currentDish = new DessertVO();
					
				} else {
					// XXX MenuImporter Wrong Dish Type: special add
					throw new IOException("Wrong Dish type detected");
				}
				
				menu.add(currentDish);
			} else if(w[0].equals("dish.nr")) {
				currentDish.setNumber(Integer.valueOf(w[1]));
				
			} else if(w[0].equals("dish.name")) {
				currentDish.setName(w[1]);
				
			} else if(w[0].equals("dish.size") && currentDish instanceof PizzaVO) {
				((PizzaVO)currentDish).setSize(Integer.valueOf(w[1]));
				
			} else if(w[0].equals("dish.typeOfPasta") && currentDish instanceof PastaVO) {
				((PastaVO)currentDish).setTypeOfPasta(Integer.valueOf(w[1]));
				
			} else if(w[0].equals("dish.price")) {
				currentDish.setPrice(Float.valueOf(w[1]));
				
			} else if(w[0].equals("dish.ingredient")) {
				ingredients.add(w[1]);
				currentDish.setIngredients(ingredients);
			} else {
				//System.err.println("MenuImporter: Something went wrong." + w[0] +"");
			}
		}		
		
		
		// Return the Whole menu
		return menu;
	}
}
