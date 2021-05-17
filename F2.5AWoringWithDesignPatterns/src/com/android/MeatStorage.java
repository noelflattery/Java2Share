package com.android;

public class MeatStorage {
	/**
	 * create our MeatStorage singleton reference and using a static
	 * initialisiation block to give it a value
	 * this is final, so it HAS to be given a value
	 * this will only run ONCE and 
	 * as this is static, this will be run ONCE and will be the very first thing that will be run when
	 * we first access the class in anyway.
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/LTNSQJKwCjM">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
	 */
	private static final MeatStorage instance;
	/**amount of kilos of meat at the start of the day, this would be the amount of meat from the
	 * previous day, plus any deliveries of meat that were made. for our purposes we hard code in a value
	 * of 200 kilos
	 */
	private int quantity=200;
	/**
	 * keeps a count of how many singletons are created, this will be initialised in the
	 * static initializer
	 */
	private static int counter=0;
	/**
	 * static initializer that will be the only second thing to run when we first access the class and is run
	 * only ONCE
	 * We use this structure to create a new meatStorage object and as its static, it only runs ONCE so
	 * no other MeatStorage can be created using this Structure
	 * 	 */
	static {
		counter++;
		/*
		 * if you want to do something before you give this a value, i.e
		 * get values from a database or do some calculation based on some
		 * other value
		 */
		System.out.println("creating our MeatStorage singleton in a "
				+ " static initialiser");
		//this initialises our private static final MeatStorage variable
		instance=new MeatStorage();
	}
	/**
	 * constructor that creates a MeathStorage object that should only run ONCE, if it correctly 
	 * a singleton
	 */
	private MeatStorage() {
		System.out.println("MeatStorage object created");
	}
	/**method is the same method to add meat to the fridge as the HayStorage addHay method*/
	public synchronized void addMeat(int amount) {
		System.out.println(amount+" meat added with id of "+counter);
		quantity+=amount;
	}
	/**method is the same method to take meat from the fridge as the HayStorage removeHay method*/
	public synchronized boolean removeMeat(int amount) {
		if(quantity<amount) {
			System.out.println("there is not enough meat in the store for "
					+ "the amount requested");
			return false;
		}
		quantity-=amount;
		System.out.println(amount+" meat removed with id of "+counter);
		return true;
	}
	/**toString method that prints out the amount of meat in the fridge*/
	public String toString() {
		return "id is "+counter+"and quantity"+quantity;
	}
	/**allows us to get the instance of the MeatStore class singleton*/
	public static MeatStorage getInstance() {
		return instance;
	}

}
