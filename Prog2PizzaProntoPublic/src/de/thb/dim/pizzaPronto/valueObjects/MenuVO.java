package de.thb.dim.pizzaPronto.valueObjects;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * MenuVO - Contains the Value Object of Menus
 * Uebung 06 - 21.05.2019
 * Uebung 09 - 04.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class MenuVO {
	
	//private static final int NUMBER_OF_DISHES = 18;
	private ArrayList<DishVO> dishes;
	
	
	
	/*
	 * Constructos
	 */
	public MenuVO() {
		this.initMenu();
	}
	
	
	/*
	 * Helper / Generel Methods
	 */
	private void initMenu() {
		this.dishes = new ArrayList<DishVO>();
		
        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("Schinken");
        ingredients.add("Spinat");
        ingredients.add("Champignons");
        ingredients.add("Ei");
        dishes.add(new PizzaVO(30, "Popeye", ingredients, 7.00f, 1));
        dishes.add(new PizzaVO(30, "Popeye", ingredients, 8.90f, 2));
        
        ingredients = new ArrayList<String>();
        ingredients.add("Schinken");
        ingredients.add("Ananas");
        ingredients.add("Curry");
        dishes.add(new PizzaVO(31, "Hawaii", ingredients, 5.80f, 1));
        dishes.add(new PizzaVO(31, "Hawaii", ingredients, 7.40f, 2));
        
        ingredients = new ArrayList<String>();
        ingredients.add("Schinken");
        ingredients.add("Salami");
        ingredients.add("Zwiebeln");
        ingredients.add("Ei");
        dishes.add(new PizzaVO(32, "Prima", ingredients, 7.00f, 1));
        dishes.add(new PizzaVO(32, "Prima", ingredients, 8.90f, 2));
        
        ingredients = new ArrayList<String>();
        ingredients.add("Tomatensauce");
        dishes.add(new PastaVO(11, "Napoli", ingredients, 5.60f, 4));
        dishes.add(new PastaVO(11, "Napoli", ingredients, 5.60f, 5));
        dishes.add(new PastaVO(11, "Napoli", ingredients, 5.60f, 6));
        
        ingredients = new ArrayList<String>();
        ingredients.add("Hackfleischsauce");
        dishes.add(new PastaVO(12, "Bolognese", ingredients, 6.40f, 4));
        dishes.add(new PastaVO(12, "Bolognese", ingredients, 6.40f, 5));
        dishes.add(new PastaVO(12, "Bolognese", ingredients, 6.40f, 6));
        
        ingredients = new ArrayList<String>();
        ingredients.add("Schinken");
        ingredients.add("Sahne");
        dishes.add(new PastaVO(13, "alla Panna", ingredients, 6.40f, 4));
        dishes.add(new PastaVO(13, "alla Panna", ingredients, 6.40f, 5));
        dishes.add(new PastaVO(13, "alla Panna", ingredients, 6.40f, 6));
        dishes.add(new DessertVO(21, "Hausgemachter Obstsalat", 2.30f));
        dishes.add(new DessertVO(22, "Hausgemachte Pannacotta", 2.60f));
        dishes.add(new DessertVO(23, "Hausgemachtes Tiramisu", 2.80f));
        
//		this.dishes = new DishVO[NUMBER_OF_DISHES];
//		
//		dishes[0] = new PizzaVO(30, "Popeye", new String[] { "Schinken","Spinat", "Champignon", "Ei" }, 7.00f, 1);
//		dishes[1] = new PizzaVO(30, "Popeye", new String[] { "Schinken","Spinat", "Champignon", "Ei" }, 8.90f, 2);
//		dishes[2] = new PizzaVO(31, "Hawaii", new String[] { "Schinken","Ananas", "Curry" }, 5.80f, 1);
//		dishes[3] = new PizzaVO(31 ,"Hawaii", new String[] { "Schinken","Ananas", "Curry" }, 7.40f, 2);
//		dishes[4] = new PizzaVO(32, "Prima", new String[] { "Schinken","Salami", "Zwiebeln", "Ei" }, 7.00f, 1);
//		dishes[5] = new PizzaVO(32, "Prima", new String[] { "Schinken","Salami", "Zwiebeln", "Ei" }, 8.90f, 2);
//		dishes[6] = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" },5.60f, 4);
//		dishes[7] = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" },5.60f, 5);
//		dishes[8] = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" },5.60f, 6);
//		dishes[9] = new PastaVO(12, "Bolognese",new String[] { "Hackfleischsauce" }, 6.40f, 4);
//		dishes[10] = new PastaVO(12, "Bolognese",new String[] { "Hackfleischsauce" }, 6.40f, 5);
//		dishes[11] = new PastaVO(12, "Bolognese",new String[] { "Hackfleischsauce" }, 6.40f, 6);
//		dishes[12] = new PastaVO(13, "alla Panna", new String[] { "Schinken","Sahne" }, 6.40f, 4);
//		dishes[13] = new PastaVO(13, "alla Panna", new String[] { "Schinken","Sahne" }, 6.40f, 5);
//		dishes[14] = new PastaVO(13, "alla Panna", new String[] { "Schinken","Sahne" }, 6.40f, 6);
//		dishes[15] = new DessertVO(21, "Hausgemachter Obstsalat", 2.30f);
//		dishes[16] = new DessertVO(22, "Hausgemachte Pannacotta", 2.60f);
//		dishes[17] = new DessertVO(23, "Hausgemachtes Tiramisu", 2.80f);
	}
	
	@Override
	public String toString() {
		//FIXME MenuVO toString(): Use java.lang.StringBuilder to improve performance	
		int i;
		StringBuffer sb = new StringBuffer();
		DecimalFormat dFormat = new DecimalFormat(".00"); //Format the price ...
		
		sb.append("MENU PIZZA PRONTO\n\n");
		// Pizzas
		sb.append("Prima special pizzas: \n 1 normal (Diameter approx. 26 cm) and \n 2 grande (Diameter approx. 32 cm)\n");
		i = 0;
		do {
			if (this.dishes.get(i) != null) {
				sb.append(this.dishes.get(i).getNumber() + "\t");
				sb.append(this.dishes.get(i).getName() + "\t");
				sb.append(this.dishes.get(i).ingredientsToString());
				sb.append("\n\tPrice:\t\t\t" + dFormat.format(this.dishes.get(i).getPrice()) + " Euro");
				if(this.dishes.get(i).getNumber() == this.dishes.get(i+1).getNumber()){
					sb.append("\n\tPrice:\t\t\t" + dFormat.format(this.dishes.get(i+1).getPrice()) + " Euro");
					sb.append("\n");
					i+=2;
			} else
				i++;
			}
		} while (i < this.dishes.size()); // && this.dishes.get[i] instanceof PizzaVO 
		
		return sb.toString();
	}

	
	/**
	 * @return the dish w/ id ...
	 */
	public DishVO getDish(int index) {
		return this.dishes.get(index);
	}

	/**
	 * @return the number of dishes
	 */
	public int getNumberOfDishes() {
		return this.dishes.size();
	}
}
