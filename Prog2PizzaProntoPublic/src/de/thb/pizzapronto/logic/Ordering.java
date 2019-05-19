package de.thb.pizzapronto.logic;

import java.time.LocalDateTime;
import java.time.Year;

import de.thb.pizzapronto.valueobjects.*;

/**
 * Ordering - Used to Control the Ordering Process
 * Uebung 7 - 19.05.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class Ordering implements IOrdering {
	
	private MenuVO menu;
	private int nextID = 0;
	private OrderVO currentOrder;
	private CustomerVO currentCustomer;
	private IService kitchen;
	private IService delivery;
	
	
	
	/*
	 * Constructors
	 */
	public Ordering() {
		this.menu = new MenuVO();
		//this.currentOrder = new OrderVO();
		//this.currentCustomer = null;
		this.kitchen = new Kitchen();
		this.delivery = new Delivery();
	}
	
	
	
	/*
	 * Helper / Generel methods
	 */
	public OrderVO startNewOrder(CustomerVO customer) {		
		int orderNo;
		this.nextID++;
		
		if(this.menu != null)
			this.menu = new MenuVO();
		
		if(customer != null) { //Year.now().getValue();
			this.currentCustomer = customer;
			
			//XXX: could have used StringBuffer
			// Generate Bestellnummer - OrderNo
			orderNo = Integer.parseInt(
						Integer.toString(Year.now().getValue()) + 
						"0000" +
						Integer.toString(this.nextID));
			
			this.currentOrder = new OrderVO(orderNo, "started", LocalDateTime.now(), customer);
		}
		
		return this.currentOrder;
	}
	
	public void addDish(DishVO dish) {	
		// checks if a order is existing
		if(this.currentOrder == null) {
			System.out.println("Error: There is no order.");
			return;
		}
		
		// checks if Order is ready	
		if(this.currentOrder.getState() == "started") {
			// add dish to shopping Basket
			this.currentOrder.addDish(dish);
		} else {
			System.out.println("Your order is complete you can not add any dishes.");
		}
	}
	
	public void deleteDish() {
		if(this.currentOrder.getState() == "started") {
			// delete dish from shopping Basket
			this.currentOrder.deleteDish();
		} else {
			System.out.println("Your order is complete, you can not delete any dishes.");
		}
	}
	
	public float calculateTotalPrice() {
		if(this.currentOrder == null) {
			System.out.println("Error: There is no order.");
			return 0.0f;
		}		
		
		// checks if Order is confirmed
		if(this.currentOrder.getState() == "confirmed") {
			return this.currentOrder.calculatePriceDishes();
		} else {
			return 0.0f;
		}
	}
	
	public void confirmOrder() {
		if(this.currentOrder == null) {
			System.out.println("Error: There is no order.");
			return;
		}		
		
		// checks if Order is started	
		if(this.currentOrder.getState() == "started") {
			this.currentOrder.setState("confirmed");
		} else {
			System.out.println("Your order can not be confirmed");
		}
	}
	
	public void startService() {
		String orderState = this.currentOrder.getState();
		
		if(this.currentOrder == null) {
			System.out.println("Error: There is no order.");
			return;
		} else if(orderState == "started") {
			System.out.println("Your order can not be processed.");
			return;
		}else if(orderState == "confirmed") {
			//FIXME: add Name of Koch
			System.out.format(this.kitchen.startService(this.currentOrder), "nameOfChef");
			System.out.println("");
		} else if(orderState == "ready") {
			//FIXME: add Name of Deleveriy Man
			System.out.format(this.delivery.startService(this.currentOrder), "nameOfDeliveryMan");
			System.out.println("");
		} else if(orderState == "delivered") {
			this.currentOrder.setState("finished");
			System.out.println("Order completed: " + this.currentOrder.toString());
			this.currentCustomer.setOrder(null);
		}
	}



	/**
	 * @return the currentOrder
	 */
	public OrderVO getCurrentOrder() {
		return currentOrder;
	}

	/**
	 * @param currentOrder the currentOrder to set
	 */
	public void setCurrentOrder(OrderVO currentOrder) {
		this.currentOrder = currentOrder;
	}

	/**
	 * @return the currentCustomer
	 */
	public CustomerVO getCurrentCustomer() {
		return currentCustomer;
	}

	/**
	 * @param currentCustomer the currentCustomer to set
	 */
	public void setCurrentCustomer(CustomerVO currentCustomer) {
		this.currentCustomer = currentCustomer;
	}

	/**
	 * @return the kitchen
	 */
	public IService getKitchen() {
		return kitchen;
	}

	/**
	 * @param kitchen the kitchen to set
	 */
	public void setKitchen(IService kitchen) {
		this.kitchen = kitchen;
	}

	/**
	 * @return the delivery
	 */
	public IService getDelivery() {
		return delivery;
	}

	/**
	 * @param delivery the delivery to set
	 */
	public void setDelivery(IService delivery) {
		this.delivery = delivery;
	}

	/**
	 * @return the menu
	 */
	public MenuVO getMenu() {
		return menu;
	}

	/**
	 * @return the nextID
	 */
	public int getNextID() {
		return nextID;
	}
}
