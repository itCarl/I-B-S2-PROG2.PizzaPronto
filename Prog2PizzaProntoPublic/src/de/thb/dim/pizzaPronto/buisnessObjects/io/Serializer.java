package de.thb.dim.pizzaPronto.buisnessObjects.io;

import java.io.*;

import de.thb.dim.pizzaPronto.valueObjects.OrderVO;

/**
 * Serializer - Serializer Klasse
 * Uebung 11 - 17.06.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public class Serializer {

	private ObjectOutputStream os;
	private ObjectOutputStream is;
	
	// FIXME: SERIALIZER
	
	/*
	 * Constructors
	 */
	public Serializer(String file) throws FileNotFoundException {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.close();
		} catch (IOException e) {
			System.out.println("Filewriter konnte nicht erstellt werden");
			e.printStackTrace();
		}
	}
	

	
	/*
	 * Helper / Generel Mothods
	 */
	public void serializeOrder(OrderVO order) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Order.ser"));
			os.writeObject(order);
			os.close();
		} catch (IOException e) {
			System.out.println("Schreibfehler: Order.ser");
			e.printStackTrace();
		}
	}
	
	public void closeOutput() {
		try {
			os.close();
		} catch (IOException e) {
			System.out.println("OutputStream konnte nicht geschlossen werden.");
			e.printStackTrace();
		}
	}
	
	public OrderVO deserializeOrder() {
		OrderVO order = null;
		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("Order.ser"));
			order = (OrderVO) is.readObject();
			is.close();
			return order;
		} catch (IOException e) {
			System.out.println("Schreibfehler: Order.ser");
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			System.out.println("Schreibfehler: bestellung.ser (ClassNotFound)");
			e.printStackTrace();
		}
		return order;		
	}
	
	public void closeInput(){
		try {
			is.close();
		} catch (IOException e) {
			System.out.println("InputStream konnte nicht geschlossen werden.");
			e.printStackTrace();
		}
	}



	/**
	 * @return the os
	 */
	public ObjectOutputStream getOs() {
		return os;
	}

	/**
	 * @param os the os to set
	 */
	public void setOs(ObjectOutputStream os) {
		this.os = os;
	}

	/**
	 * @return the is
	 */
	public ObjectOutputStream getIs() {
		return is;
	}

	/**
	 * @param is the is to set
	 */
	public void setIs(ObjectOutputStream is) {
		this.is = is;
	}
}
