import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class OrderVO {

	private static int nextOrderNo = 0;
	private final int orderNo;
	LocalDateTime timestampStartedOrder;
	LocalDateTime timestampDeliveredOrder;
	
	
    /*
     * Constructors
     */
    public OrderVO() {
        orderNo = nextOrderNo;
        nextOrderNo++;
        
        timestampStartedOrder = LocalDateTime.now();
    }
    
    public OrderVO(LocalDateTime timestampDeliveredOrder) {
    	this();
    	this.setTimestampDeliveredOrder(timestampDeliveredOrder);
    }
        
    
    /*
     * General Methods
     */
	public String toString() {
		
		return "OrderNo: " + this.orderNo + "\n" + "StartDate: " + timestampStartedOrderToString() + "\n" + "Delivered Date: " + timestampDeliveredOrderToString();
		
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
    
    
    
    /*
     * Getter & Setter
     */
    public int getOrderNo() {
    	return orderNo;
    }
    
    public static int getNextOrderNo() {
    	return nextOrderNo;
    }
    
    public LocalDateTime getTimestampStartedOrder() {
		return timestampStartedOrder;
	}

	public void setTimestampStartedOrder(LocalDateTime timestampStartedOrder) {
		this.timestampStartedOrder = timestampStartedOrder;
	}

	public LocalDateTime getTimestampDeliveredOrder() {
		return timestampDeliveredOrder;
	}

	public void setTimestampDeliveredOrder(LocalDateTime timestampDeliveredOrder) {
		this.timestampDeliveredOrder = timestampDeliveredOrder;
	}
}
