package de.thb.dim.pizzaPronto.buisnessObjects;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;

import de.thb.dim.pizzaPronto.valueObjects.*;
import de.thb.dim.pizzaPronto.controller.*;

/**
 * Ordering - Used to Control the Ordering Process
 * Uebung 07 - 23.05.2019
 * Uebung 09 - 04.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class Ordering implements IOrdering {
	
	private static MenuVO menu;
	private static int nextId = 0;
	private OrderVO currentOrder;
	private CustomerVO currentCustomer;
	private IService kitchen;
	private IService delivery;
	
	
	
	/*
	 * Constructors
	 */
	public Ordering() {
		Ordering.menu = new MenuVO();
		this.kitchen = new Kitchen();
		this.delivery = new Delivery();
	}
	
	
	
	/*
	 * Helper / Generel methods
	 */
	public OrderVO startNewOrder(CustomerVO customer) {		
		
		if(Ordering.menu != null)
			Ordering.menu = new MenuVO();
		
		if(customer == null)
			return null;
		
		// Generate Bestellnummer - OrderNo
		if (LocalDateTime.now().getYear() > (Ordering.nextId / 100000)) {
			Ordering.nextId = LocalDateTime.now().getYear() * 100000;
		}
		Ordering.nextId++;
		
		this.currentCustomer = customer;
			
		this.currentOrder = new OrderVO(Ordering.nextId, StateOfOrderVO.STARTED, LocalDateTime.now(), customer);
		this.currentCustomer.setOrder(this.currentOrder);
			
		return this.currentOrder;		
	}
	
	public void addDish(DishVO dish) {	
		// checks if a order is existing
		if(this.currentOrder == null) {
			System.out.println("Error: There is no order.");
			return;
		}
		
		if(this.currentOrder.getState() != StateOfOrderVO.STARTED) {
			System.out.println("Your order is complete, you can not add any dishes.");
			return;
		}
		
		// add dish to shopping Basket
		this.currentOrder.addDish(dish);
	}
	
	public void deleteDish(DishVO dish) {
		
		if(this.currentOrder == null) {
			System.out.println("Error: There is no order.");
			return;
		}
		
		if(this.currentOrder.getState() == StateOfOrderVO.STARTED) {
			// delete dish from shopping Basket
			this.currentOrder.deleteDish(dish);
		} else {
			System.out.println("Your order is complete, you can not delete any dishes.");
		}
	}
	
	public float calculateTotalPrice() {
		if(this.currentOrder == null) {
			System.out.println("Error: There is no order.");
			return 0.0f;
		}		
		
		return this.currentOrder.calculatePriceDishes();
	}
	
	public void confirmOrder() {
		if(this.currentOrder == null) {
			System.out.println("Error: There is no order.");
			return;
		}		
		
		// checks if Order is started	
		if(this.currentOrder.getState() == StateOfOrderVO.STARTED) {
			this.currentOrder.setState(StateOfOrderVO.FINISHED);
		} else {
			System.out.println("Your order can not be confirmed");
		}
	}
	
	public void startService() {
		
		if(this.currentOrder == null) {
			System.out.println("Error: There is no order.");
			return;
		}
		
		StateOfOrderVO orderState = this.currentOrder.getState();
			
		if(orderState == StateOfOrderVO.STARTED) {
			System.out.println("Your order can not be processed.");
			return;
			
		}else if(orderState == StateOfOrderVO.CONFIRMED) {
			System.out.println(this.kitchen.startService(this.currentOrder));
			this.startService();
			
		} else if(orderState == StateOfOrderVO.READY) {
			System.out.println(this.delivery.startService(this.currentOrder));
			this.startService();
			
		} else if(orderState == StateOfOrderVO.DELIVERED) {
			this.currentOrder.setState(StateOfOrderVO.FINISHED);
			System.out.println("Order completed: " + this.currentOrder.toString());
			this.currentCustomer.setOrder(null);
		}
	}
	
	public List<DishVO> sortShoppingBasket() {
		//TODO sortShoppingBasket()
		return null;
	}
	
	public List<DishVO> sortShoppingBasketByNumber() {
		//TODO sortShoppingBasketByNumber()
		return null;
	}
	
	public List<DishVO> sortShoppingBasketByPrice() {
		//TODO sortShoppingBasketByPrice()
		return null;
	}



	/**
	 * @return the menu
	 */
	public static MenuVO getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public static void setMenu(MenuVO menu) {
		Ordering.menu = menu;
	}

	/**
	 * @return the nextId
	 */
	public static int getNextId() {
		return nextId;
	}

	/**
	 * @param nextId the nextId to set
	 */
	public static void setNextId(int nextId) {
		Ordering.nextId = nextId;
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

}
