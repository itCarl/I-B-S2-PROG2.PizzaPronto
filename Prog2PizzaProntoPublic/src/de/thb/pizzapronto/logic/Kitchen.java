package de.thb.pizzapronto.logic;

import de.thb.pizzapronto.valueobjects.*;

/**
 * Kitchen - Contains the Kitchen logic
 * Uebung 7 - 23.05.2019
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
		this.employees = new EmployeeVO[1];
		this.employees[0] = new ChefVO("Chef 001", "Paul", "Paul");
	}



	/*
	 * Helper / Generel Mothods
	 */
	public String startService(OrderVO order) {
		if(order == null) {
			return "Service of ChefVO "+ this.employees[0] +": No order available.";
		} else if(order.getState() == "confirmed") {
			order.setState("ready"); 
			return "Service of ChefVO"+ this.employees[0] +": Order is ready.";
		}  else {
			return "Service of ChefVO "+ this.employees[0] +": No order for processing available.";
		}
	}	

	
	
	/**
	 * @return the employees
	 */
	public EmployeeVO[] getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(EmployeeVO[] employees) {
		this.employees = employees;
	}
}
