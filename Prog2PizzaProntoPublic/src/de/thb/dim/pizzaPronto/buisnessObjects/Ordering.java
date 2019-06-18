package de.thb.dim.pizzaPronto.buisnessObjects;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import de.thb.dim.pizzaPronto.valueObjects.*;
import de.thb.dim.pizzaPronto.buisnessObjects.exceptions.*;
import de.thb.dim.pizzaPronto.controller.*;

/**
 * Ordering - Used to Control the Ordering Process
 * Uebung 07 - 23.05.2019
 * Uebung 10 - 15.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class Ordering implements IOrdering, Comparator<DishVO> {
	
	private static MenuVO menu;
	private static int nextId = 0;
	private OrderVO currentOrder;
	private CustomerVO currentCustomer;
	private IService kitchen;
	private IService delivery;
	
	
	
	/*
	 * Constructors
	 */
	public Ordering() throws IOException {
		Ordering.menu = new MenuVO();
		this.kitchen = new Kitchen();
		this.delivery = new Delivery();
	}
	
	
	
	/*
	 * Helper / Generel methods
	 */
	public OrderVO startNewOrder(CustomerVO customer){		
		if(Ordering.menu != null) {
			try {
				Ordering.menu = new MenuVO();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Objects.requireNonNull(customer, "Customer must not be null");
		
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
	
	/**
	 * 
	 */
	public int compare(DishVO d1, DishVO d2) {
		int d1n = d1.getNumberOfDish();
		int d2n = d2.getNumberOfDish();
		
		return d1n > d2n ? 1 : d1n == d2n ? 0 : -1;
	}
	
	/**
	 * Add a Dish to the Shopping Basket
	 *
	 * @param DishVO dish
	 * @return void
	 */
	public void addDish(DishVO dish) throws NoOrderException {	
		if(this.currentOrder == null)
			throw new NoOrderException("There is no order.");
		
		if(this.currentOrder.getState() != StateOfOrderVO.STARTED)
			throw new IllegalStateException("Your order is complete, you can not add any dishes.");
		
		
		// add dish to shopping Basket
		this.currentOrder.addDish(dish);
	}
	
	/**
	 * Delete a Dish from the Shopping Basket
	 * 
	 * @param DishVO dish
	 * @return void
	 */
	public void deleteDish(DishVO dish) throws NoOrderException, IllegalStateException {
		if(this.currentOrder == null)
			throw new NoOrderException("There is no order.");
		
		if(this.currentOrder.getState() != StateOfOrderVO.STARTED)
			throw new IllegalStateException("Your order is complete, you can not delete any dishes.");
			
		
		// delete dish from shopping Basket
		this.currentOrder.deleteDish(dish);
	}
	
	/**
	 * Add up all Dish Prices
	 * 
	 * @return float
	 */
	public float calculateTotalPrice() throws NoOrderException {
		if(this.currentOrder == null)
			throw new NoOrderException("There is no order.");	
		
		return this.currentOrder.calculatePriceDishes();
	}
	
	/**
	 * Confirm the order
	 * 
	 * @return void
	 * @throws NoOrderException
	 * @throws NoCustomerException 
	 */
	public void confirmOrder() throws NoOrderException, NoCustomerException {
		if(this.currentOrder == null)
			throw new NoOrderException("There is no order.");
		
		if(this.currentOrder.getState() != StateOfOrderVO.STARTED) {
			throw new IllegalStateException("Your order can not be confirmed.");
		} else {
			this.currentOrder.setState(StateOfOrderVO.CONFIRMED);
			try {
				this.startService();
			} catch(Exception e) {
				System.err.println("Internal error by processing an order." + e.getMessage()); 
			}
		}
		this.currentOrder.setState(StateOfOrderVO.FINISHED);
	}
	
	/**
	 * Start The Order Process
	 * 
	 * @return void
	 * @throws NoCustomerException
	 * @throws NoOrderException
	 */
	public void startService() throws NoCustomerException, NoOrderException {
		StateOfOrderVO orderState;
		
		if(this.currentOrder == null)
			throw new NoOrderException("There is no order.");
			
		 orderState = this.currentOrder.getState();
		
		 
		if(this.currentOrder.getState() == StateOfOrderVO.STARTED) {
			throw new IllegalStateException("Your order can not be processed.");
			
			
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
	
	/**
	 * Sort ShoppingBasket by natural sorting
	 * 
	 * @return sorted shoppingBasket
	 * @throws NoOrderException 
	 */
	public List<DishVO> sortShoppingBasket() throws NoOrderException {
		if(this.currentOrder == null)
			throw new NoOrderException("There is no order.");
		
		Collections.sort(this.currentOrder.getShoppingBasket());
		
		return this.currentOrder.getShoppingBasket();
	}
	
	/**
	 * Sort ShoppingBasket by NumberOfDish
	 * 
	 * @return sorted shoppingBasket
	 * @throws NoOrderException 
	 */
	public List<DishVO> sortShoppingBasketByNumber() throws NoOrderException {
		if(this.currentOrder == null)
			throw new NoOrderException("There is no order.");
		
		Collections.sort(this.currentOrder.getShoppingBasket(), (a, b) -> Integer.compare(a.getNumberOfDish(), b.getNumberOfDish()));
		
		return this.currentOrder.getShoppingBasket();
	}
	
	/**
	 * Sort ShoppingBasket by Price
	 * 
	 * @return sorted shoppingBasket
	 * @throws NoOrderException 
	 */
	public List<DishVO> sortShoppingBasketByPrice() throws NoOrderException {
		if(this.currentOrder == null)
			throw new NoOrderException("There is no order.");
		
		Collections.sort(this.currentOrder.getShoppingBasket(), (a, b) -> Integer.compare(a.getNumberOfDish(), b.getNumberOfDish()));
		
		return this.currentOrder.getShoppingBasket();
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
