package de.thb.pizzapronto.valueobjects;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * OrderVO - Contains the Value Object of Orders
 * Uebung 4 - 19.05.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class OrderVO {
	
	private static final int MAX_DISHES = 10;
	private final int orderNo;
	private String state;		// started -> confirmed -> ready -> delivered -> finished
	private int index = 0;
	LocalDateTime timestampStartedOrder;
	LocalDateTime timestampDeliveredOrder;
	private DishVO[] shoppingBasket;
	private CustomerVO customer;
	
    /*
     * Constructors
     */
    public OrderVO() {
        this(0, null, null, null);
    }
    
    public OrderVO(int orderNo, String state, LocalDateTime timestampStartedOrder, CustomerVO customer) {
    	this.orderNo = orderNo;
    	this.state = state;
    	this.setTimestampStartedOrder(timestampStartedOrder);
    	this.customer = customer;
    	this.shoppingBasket = new DishVO[MAX_DISHES];
    }

    

	/*
     * Helper / General Methods
     */    
	@Override
	public String toString() {
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
		if(this.index < OrderVO.MAX_DISHES) {
			this.shoppingBasket[this.index] = dish;
			this.index++;
		}
	}
	
	public void deleteDish() {
		if(this.index > 0) {
			this.index--;
			this.shoppingBasket[index] = null;
		}
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
		
		return (this.index > index) ? this.shoppingBasket[index] : null;
	}
	
	public int getNumberOfDishes() {
		return this.index;
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
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
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
	public DishVO[] getShoppingBasket() {
		return shoppingBasket;
	}

	/**
	 * @param shoppingBasket the shoppingBasket to set
	 */
	public void setShoppingBasket(DishVO[] shoppingBasket) {
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

	/**
	 * @return the maxDishes
	 */
	public static int getMAX_DISHES() {
		return MAX_DISHES;
	}

	/**
	 * @return the orderNo
	 */
	public int getOrderNo() {
		return orderNo;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}
}
