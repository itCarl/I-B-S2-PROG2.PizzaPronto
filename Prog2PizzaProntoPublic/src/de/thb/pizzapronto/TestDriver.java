package de.thb.pizzapronto;
import java.time.*;
import de.thb.pizzapronto.logic.*;


public class TestDriver {

	public static void main(String[] args) {
		Ordering o = new Ordering();
		o.startNewOrder(null);
		o.confirmOrder();
		System.out.println();
		
	}

}
