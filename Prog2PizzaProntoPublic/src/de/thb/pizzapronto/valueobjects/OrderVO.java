package de.thb.pizzapronto.valueobjects;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

/**
 * OrderVO - Contains the Value Object of Orders
 * Uebung 4 - 16.05.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class OrderVO {
	
	private int MAX_DISHES = 10;
	private final int orderNo;
	private String state;		// started -> confirmed -> ready -> delivered -> finished
	private int index;
	LocalDateTime timestampStartedOrder;
	LocalDateTime timestampDeliveredOrder;
	private DishVO[] shoppingBasket;
	// OLD VERSION private LinkedList<DishVO> shoppingBasket;
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
		String dishType;
		StringBuffer s = new StringBuffer();
		DecimalFormat dFormat = new DecimalFormat(".00");
		
		s.append("OrderVO "+ this.orderNo +" from "+ this.timestampStartedOrderToString() +" "+ this.timestampToTime(this.timestampStartedOrder) +"\n");
		s.append("\t\t with deliverey at "+ this.timestampDeliveredOrderToString() +" "+ this.timestampToTime(this.timestampDeliveredOrder) +"\n");
		s.append("\t\t of customer: "+ this.customer.getFirstName() +" "+ this.customer.getLastName() +", ID of customer: "+ this.customer.getID() +"\n");
		
		for(DishVO d : this.shoppingBasket) {
			
			// check... otherwise null pointer exception
			if(d != null) {
				if(d instanceof PizzaVO) {
					dishType = "Pizza";
				}else if(d instanceof PastaVO) {
					dishType = "Pasta";
				}else if(d instanceof DessertVO) {
					dishType = "Dessert";
				}else {
					dishType = "undefined";
				}
				
				s.append(d.getNumber() +" - "+ dishType+" "+ d.getName() +" > "+ d.ingredientsToString() +"\n");
				s.append("\tPrice:\t\t\t" + dFormat.format(d.getPrice()) + " Euro");
				s.append("\n");
			}
		}
		
		s.append("\n Total Price: " + this.calculatePriceDishes());
		
		return s.toString();
		/*return "OrderVO [MAX_DISHES=" + this.MAX_DISHES + ", orderNo=" + this.orderNo + ", state=" + this.state + ", index=" + this.index
				+ ", timestampStartedOrder=" + this.timestampStartedOrderToString() + ", timestampDeliveredOrder="
				+ this.timestampDeliveredOrderToString() + ", shoppingBasket=" + this.shoppingBasket + "]";
		*/
	}

	public int hashCode() {
		final int hashMultiplier = 31;
		int result = 1;
		result = hashMultiplier * result + orderNo;
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
	
	/* OLD VERSION SHOPPING BASKET
	public void addDish(DishVO dish) {
		shoppingBasket.add(dish);
	}
	
	public void deleteDish(DishVO dish) {
		shoppingBasket.remove(dish);
	}
	*/
	
	//XXX: check if Dish is already in ShoppingBasket
	public void addDish(DishVO dish) {
		for(int i = 0; i <= (this.shoppingBasket.length-1); i++) {
			if(this.shoppingBasket[i] == null) {
				this.shoppingBasket[i] = dish;
				this.index++;
				return;
			}
		}
	}
	
	public void deleteDish() {
		if(this.shoppingBasket[index] != null) {
			this.shoppingBasket[index] = null;
			this.index--;
			return;
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
		return this.shoppingBasket[index];
	}
	
	public int getNumberOfDishes() {
		return (this.index+1);
	}
	
	//TODO: Itterate all Dishes
	public String shoppingBasketToString() {
		return "";
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
	 * @return the index
	 */
	public int getIndex() {
		return index;
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
	
	/* OLD VERSION SHOPPING BASKET
	public LinkedList<DishVO> getShoppingBasket() {
		return shoppingBasket;
	}

	public void setShoppingBasket(LinkedList<DishVO> shoppingBasket) {
		this.shoppingBasket = shoppingBasket;
	}
	*/
	
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
	 * @return the orderNo
	 */
	public int getOrderNo() {
		return orderNo;
	}
	
	/**
	 * @return the maximum amount of dishes
	 */
	public int getDishes() {
		return MAX_DISHES;
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
