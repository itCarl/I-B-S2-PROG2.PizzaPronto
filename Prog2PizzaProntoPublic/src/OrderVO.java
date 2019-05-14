import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

//TODO: toString -> use String Buffer... append();
public class OrderVO {
	
	private int MAX_DISHES = 10;
	private static int nextOrderNo = 0;
	private final int orderNo;
	private String state = "started";
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
        this(null, null);        
        //timestampStartedOrder = LocalDateTime.now();
    }
    
    public OrderVO(LocalDateTime timestampStartedOrder, CustomerVO customer) {
    	orderNo = nextOrderNo++;
    	this.setTimestampStartedOrder(timestampStartedOrder);
    	this.customer = customer;
    	this.shoppingBasket = new DishVO[MAX_DISHES];
    }
        
    
    /*
     * Helper / General Methods
     */    
	@Override
	public String toString() {
		return "OrderVO [MAX_DISHES=" + this.MAX_DISHES + ", orderNo=" + this.orderNo + ", state=" + this.state + ", index=" + this.index
				+ ", timestampStartedOrder=" + this.timestampStartedOrder + ", this.timestampDeliveredOrder="
				+ this.timestampDeliveredOrder + ", shoppingBasket=" + this.shoppingBasket + "]";
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

	private String timestampStartedOrderToString(){
		return (timestampStartedOrder != null) ? timestampStartedOrder.format(DateTimeFormatter.ofPattern("dd MM yyyy")) : null;
	}
	
	private String timestampDeliveredOrderToString(){	
		return (timestampDeliveredOrder != null) ? timestampDeliveredOrder.format(DateTimeFormatter.ofPattern("dd MM yyyy")) : null;
	}
	
	/* OLD VERSION SHOPPING BASKET
	public void addDish(DishVO dish) {
		shoppingBasket.add(dish);
	}
	
	public void deleteDish(DishVO dish) {
		shoppingBasket.remove(dish);
	}
	*/
	
	//TODO: check if Dish is already in ShoppingBasket
	public void addDish(DishVO dish) {
		for(int i = 0; i <= (this.shoppingBasket.length-1); i++) {
			if(this.shoppingBasket[i] == null) {
				this.shoppingBasket[i] = dish;
				this.index++;
				return;
			}
		}
	}
	
	public void deleteDish(int index) {
		if(this.shoppingBasket[index] != null) {
			this.shoppingBasket[index] = null;
			this.index--;
			return;
		}
	}	
	
	public float calculatePriceDishes() {
		float total = 0;
		
		for(DishVO dish : this.shoppingBasket) {
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
}
