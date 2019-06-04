package de.thb.dim.pizzaPronto.buisnessObjects;

import de.thb.dim.pizzaPronto.valueObjects.OrderVO;


/**
 * IService - Interface for Services
 * Uebung 7 - 04.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public interface IService {
	
	
	/*
	 * Helper / Generel Methods aka. abstract Methods
	 */
	public String startService(OrderVO order);

}
