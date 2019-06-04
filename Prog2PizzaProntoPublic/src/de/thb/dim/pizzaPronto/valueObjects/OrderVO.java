package de.thb.dim.pizzaPronto.valueObjects;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * OrderVO - Contains the Value Object of Orders
 * Uebung 04 - 19.05.2019
 * Uebung 09 - 04.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class OrderVO {
	
	private final int orderNo;
	
	private StateOfOrderVO state;		// started -> confirmed -> ready -> delivered -> finished
	LocalDateTime timestampStartedOrder;
	LocalDateTime timestampDeliveredOrder;
	private LinkedList<DishVO> shoppingBasket;
	private CustomerVO customer;
	
	
	
    /*
     * Constructors
     */
    public OrderVO() {
        this(0, null, null, null);
    }
    
    public OrderVO(int orderNo, StateOfOrderVO state, LocalDateTime timestampStartedOrder, CustomerVO customer) {
    	this.orderNo = orderNo;
    	this.state = state;
    	this.setTimestampStartedOrder(timestampStartedOrder);
    	this.customer = customer;
    	this.shoppingBasket = new LinkedList<DishVO>();
    }

    

	/*
     * Helper / General Methods
     */    
	@Override
	public String toString() {
		//FIXME OrderVO toString(): Use java.lang.StringBuilder to improve performance	
		StringBuffer s = new StringBuffer();
		
		s.append("OrderVO "+ this.orderNo +" from "+ this.timestampStartedOrderToString() +" "+ this.timestampToTime(this.timestampStartedOrder) +"\n");
		s.append("\t\t with deliverey at "+ this.timestampDeliveredOrderToString() +" "+ this.timestampToTime(this.timestampDeliveredOrder) +"\n");
		s.append("\t\t of customer: "+ this.customer.getFirstName() +" "+ this.customer.getLastName() +", ID of customer: "+ this.customer.getID() +"\n");
		
		// Display everything that is in the shoppingBasket
		s.append(this.shoppingBasketToString());
		
		//FIXME: round to 2 digits after decimal
		s.append("\n Total Price: " + this.calculatePriceDishes());
		
		return s.toString();
	}

	public int hashCode() {
		final int hashMultiplier = 31;
		int result = 1;
		result = (int) (hashMultiplier * result + orderNo);
		result = hashMultiplier * result + ((timestampDeliveredOrder == null) ? 0 : timestampDeliveredOrder.hashCode());
		result = hashMultiplier * result + ((timestampStartedOrder == null) ? 0 : timestampStartedOrder.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (this.getClass() != obj.getClass())
			return false;
		
		OrderVO other = (OrderVO) obj;
		if (orderNo != other.orderNo)
			return false;
		
		return true;
	}

	// Started Timestamp to Date
	private String timestampStartedOrderToString(){
		return (timestampStartedOrder != null) ? timestampStartedOrder.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
	}
	
	// Delivered Timestamp to Date
	private String timestampDeliveredOrderToString(){	
		return (timestampDeliveredOrder != null) ? timestampDeliveredOrder.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
	}
	
	// Timestamp to Hours:minutes
	private String timestampToTime(LocalDateTime ldt) {
		return (ldt != null) ? ldt.format(DateTimeFormatter.ofPattern("HH:mm")) : null; 
	}
	
	public void addDish(DishVO dish) {
		this.shoppingBasket.add(dish);
	}
	
	//TODO: delte last if no dish is given
	public void deleteDish(DishVO dish) {
		this.shoppingBasket.remove(dish);
	}	
	
	public float calculatePriceDishes() {
		float total = 0;
		
		for(DishVO dish : this.shoppingBasket) {
			if(dish != null)
				total += dish.getPrice();
		}
		
		return total;
	}
	
	public DishVO getDish(int index) {
		return this.shoppingBasket.get(index);
	}
	
	public int getNumberOfDishes() {
		return this.shoppingBasket.size();
	}
	
	public String shoppingBasketToString() {
		String dishType = "undefined";
		StringBuffer s = new StringBuffer();
		DecimalFormat dFormat = new DecimalFormat(".00");
		
		for(DishVO d : this.shoppingBasket) {
			
			// check... otherwise null pointer exception
			if(d != null) {
				if(d instanceof PizzaVO) {
					dishType = "Pizza";
				}else if(d instanceof PastaVO) {
					dishType = "Pasta";
				}else if(d instanceof DessertVO) {
					dishType = "Dessert";
				}
				
				s.append(d.getNumber() +" - "+ dishType+" "+ d.getName() +" > "+ d.ingredientsToString() +"\n");
				s.append("\tPrice:\t\t\t" + dFormat.format(d.getPrice()) + " Euro");
				s.append("\n");
			}
		}
		
		return s.toString();
	}

	
	
	/**
	 * @return the state
	 */
	public StateOfOrderVO getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(StateOfOrderVO state) {
		this.state = state;
	}

	/**
	 * @return the timestampStartedOrder
	 */
	public LocalDateTime getTimestampStartedOrder() {
		return timestampStartedOrder;
	}

	/**
	 * @param timestampStartedOrder the timestampStartedOrder to set
	 */
	public void setTimestampStartedOrder(LocalDateTime timestampStartedOrder) {
		this.timestampStartedOrder = timestampStartedOrder;
	}

	/**
	 * @return the timestampDeliveredOrder
	 */
	public LocalDateTime getTimestampDeliveredOrder() {
		return timestampDeliveredOrder;
	}

	/**
	 * @param timestampDeliveredOrder the timestampDeliveredOrder to set
	 */
	public void setTimestampDeliveredOrder(LocalDateTime timestampDeliveredOrder) {
		this.timestampDeliveredOrder = timestampDeliveredOrder;
	}

	/**
	 * @return the shoppingBasket
	 */
	public LinkedList<DishVO> getShoppingBasket() {
		return shoppingBasket;
	}

	/**
	 * @param shoppingBasket the shoppingBasket to set
	 */
	public void setShoppingBasket(LinkedList<DishVO> shoppingBasket) {
		this.shoppingBasket = shoppingBasket;
	}

	/**
	 * @return the customer
	 */
	public CustomerVO getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}
}
