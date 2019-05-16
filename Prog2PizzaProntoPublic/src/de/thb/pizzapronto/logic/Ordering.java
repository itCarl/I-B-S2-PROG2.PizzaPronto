package de.thb.pizzapronto.logic;

import java.time.LocalDateTime;
import de.thb.pizzapronto.valueobjects.*;


//XXX: considering to change to "Error first" checks
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
		this.currentOrder = new OrderVO();
		this.currentCustomer = null;
	}
	
	
	
	/*
	 * Helper / Generel methods
	 */
	public OrderVO startNewOrder(CustomerVO customer) {		
		// unnecessary because order starts with state == started
		this.currentOrder.setState("started");
		
		if(this.menu != null) {
			this.menu = new MenuVO();
		} else {
			//TODO: some error message
		}
		
		if(customer != null)
			this.currentCustomer = customer;
		
		//TODO: Generate Bestellnummer (OrderNo) customer.year+0000+nextID
		return this.currentOrder;
	}
	
	public void addDish(DishVO dish) {	
		// checks if a order is existing
		if(this.currentOrder == null) {
			//XXX: error message
			System.out.println("Error: There is no order.");
			return;
		}
		
		// checks if Order is ready	
		if(this.currentOrder.getState() == "started") {
			// add dish to shopping Basket
			this.currentOrder.addDish(dish);
		} else {
			//XXX: error message
			System.out.println("Your order is complete you can not add any dishes.");
		}
	}
	
	public void deleteDish() {
		if(this.currentOrder.getState() == "started") {
			// delete dish from shopping Basket
			this.currentOrder.deleteDish();
		} else {
			//XXX: error message
			System.out.println("Your order is complete, you can not delete any dishes.");
		}
	}
	
	public float calculateTotalPrice() {
		if(this.currentOrder == null) {
			//XXX: error message
			System.out.println("Error: There is no order.");
			return 0.0f;
		}		
		
		// checks if Order is confirmed
		if(this.currentOrder.getState() == "confirmed") {
			return this.currentOrder.calculatePriceDishes();
		} else {
			return 0.0f;
			//TODO: some error message
		}
	}
	
	public void confirmOrder() {
		if(this.currentOrder == null) {
			//XXX: error message
			System.out.println("Error: There is no order.");
			return;
		}		
		
		// checks if Order is started	
		if(this.currentOrder.getState() == "started") {
			this.currentOrder.setState("confirmed");
		} else {
			//XXX: error message
			System.out.println("Your order can not be confirmed");
		}
	}
	
	public void startService() {
		String orderState = this.currentOrder.getState();
		
		if(this.currentOrder == null) {
			//XXX: error message
			System.out.println("Error: There is no order.");
			//return;
		} else if(orderState == "started") {
			//XXX: error message
			System.out.println("Your order can not be processed.");
			//return;
		}else if(orderState == "confirmed") {
			//TODO: start kitchen service
		} else if(orderState == "ready") {
			//TODO: start delivery service
		} else if(orderState == "deliverd") {
			this.currentOrder.setTimestampDeliveredOrder(LocalDateTime.now());
			this.currentOrder.setState("finished");
			//TODO: Display all info about the order
			System.out.println("Order completed: ");
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
