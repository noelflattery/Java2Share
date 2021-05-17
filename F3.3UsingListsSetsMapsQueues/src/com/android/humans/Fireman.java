package com.android.humans;
/**
 * Fireman class that will be used with with method ex12
 * {@link com.android.Examples#ex12()}
 * @author NoelF
 */
public class Fireman {
	/**
	 * Name of Fireman
	 */
	private String name;
	/**Id to uniquely identify Fireman*/
	private int id;
	/**counter to keep check of how many Fireman are created and also used to assign unique ID to Fireman*/
	private static int counter=0;
	/**
	 * Constructor that takes a String name, increments our counter and assigns that value to id
	 * @param name is the name of the Fireman
	 */
	public Fireman(String name) {
		this.name=name;
		counter++;
		id=counter;
	}
	/**Constructor that takes no arguements and increments our counter and also used to assign unique ID to Firemand*/
	public Fireman() {
		counter++;
		id=counter;
	}
	/**
	 * Overriden toString method that prints out name and id of Fireman
	 * @return returns a String with name and id of Fireman
	 */
	@Override
	public String toString() {
		return "fireman name is "+name+" id is "+id;
	}

}
