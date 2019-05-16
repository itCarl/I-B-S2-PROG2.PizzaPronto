package de.thb.pizzapronto.logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import de.thb.pizzapronto.valueobjects.*;

/**
 * Delivery - Contains the Delivery logic
 * Uebung 7 - 16.05.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class Delivery implements IService{

	private EmployeeVO[] employees;
	//XXX: temporary number
	private int TEMP = 3; 
	
	
	
	/*
	 * Constructors
	 */
	public Delivery() {
		this.employees = new EmployeeVO[this.TEMP];
		this.employees[0] = new DeliveryManVO("Nummer01", "arbeiter", "Mit");
		this.employees[1] = new DeliveryManVO("Nummer02", "kanone", "Apfel");
		this.employees[2] = new DeliveryManVO("Nummer03", "tasche", "Kirsch");
	}
	
	
	
	/*
	 * Helper / Generel Methods
	 */
	public String startService(OrderVO order) {
//		StringBuffer s = new StringBuffer();
		String s, deliveredDate, deliveredTime;
		
		// Select randomly a Delivery Dude
		this.selectEmployee();
		
		if(order == null) {
			return "Service of DeliveryManVO %s: No order available.";
		} else if(order.getCustomer() == null) {
			return "Service of DeliveryManVO %s: No customer available.";
		} else if(order.getState() == "ready") {
			order.setState("delivered");
			order.setTimestampDeliveredOrder(LocalDateTime.now());
			
			deliveredDate = order.getTimestampDeliveredOrder().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			deliveredTime = order.getTimestampDeliveredOrder().format(DateTimeFormatter.ofPattern("HH:mm"));
			
			s = "Drive to customer "+ order.getCustomer().getFirstName() +" "+ order.getCustomer().getLastName() +", ";
			s += "in "+ order.getCustomer().getStreet() +" "+ order.getCustomer().getHouseNumber();
			s += "\n";
		    s += "Service of DeliveryManVO %s: Order is delivered on "+ deliveredDate +" at "+ deliveredTime +" o'clock";
			return s;
		} else {
			return "Service of DeliveryManVO %s: No order for processing available.";
		}
	}
	
	private EmployeeVO selectEmployee() {
		Random random = new Random();
		int ranNum = random.nextInt(this.employees.length);
		
		return employees[ranNum];
	}
}
