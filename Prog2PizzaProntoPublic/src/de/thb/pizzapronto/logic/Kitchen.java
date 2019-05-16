package de.thb.pizzapronto.logic;

import de.thb.pizzapronto.valueobjects.*;

/**
 * Kitchen - Contains the Kitchen logic
 * Uebung 7 - 16.05.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class Kitchen implements IService {
	
	private EmployeeVO[] employees;
	
	
	
	/*
	 * Constructors
	 */
	public Kitchen() {
		
	}
	
	/*
	 * Helper / Generel Mothods
	 */
	public String startService(OrderVO order) {
		if(order == null) {
			return "Service of ChefVO %s: No order available.";
		} else if(order.getState() == "confirmed") {
			order.setState("ready"); 
			return "Service of ChefVO %s: Order is ready.";
		}  else {
			return "Service of ChefVO %s: No order for processing available.";
		}
	}
}
