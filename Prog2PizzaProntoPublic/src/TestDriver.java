import java.time.*;

public class TestDriver {

	public static void main(String[] args) {
		// cool things could happen here :]
//		
//		PizzaVO piz = new PizzaVO();
//		piz.setPrice(10.5f);
//		System.out.println(piz.getPrice());
//		
//		
//		piz.setPrice(-10.5f);
//		System.out.println(piz.getPrice());
		
		/*
			KundeVO affe = new KundeVO();
			affe.setGeburtsdatum(LocalDate.of(1967, 2, 30));
		 */
		
		
		
		System.out.println("Jetzt: " + LocalDateTime.now());
		
		System.out.println("\n -------- Order A --------");
		OrderVO OA = new OrderVO();
		System.out.println(OA.toString());
		System.out.println(OA.hashCode());
		
		
		System.out.println("\n -------- Order B --------");
		OrderVO OB = new OrderVO();
		OB.setTimestampDeliveredOrder(LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40));
		System.out.println(OB.toString());
		
		
		System.out.println("\n -------- Order C --------");
		OrderVO OC = new OrderVO();
		System.out.println(OC.toString());
		System.out.println(OC.hashCode());
		
		
		System.out.println("\n ------ Equals ------");
		System.out.println("A!=C = " + OA.equals(OC));
		System.out.println("A==A = " + OA.equals(OA));
		System.out.println("B!=A = " + OB.equals(OA));
	}

}
