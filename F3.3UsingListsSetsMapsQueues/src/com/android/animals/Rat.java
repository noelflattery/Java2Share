package com.android.animals;
/**
 * Rat class that implements
 * @author Owner
 *
 */
public class Rat extends Animal implements Comparable<Rat>{
	/**
	 * constructor that takes in an int age and a string name
	 * @param age is the age of the Rat
	 * @param name is the name of the Rat
	 */
	public Rat(int age,String name){
		super(age,name);
	}
	/**
	 * this is a simple overridden equals() method that will be used, in conjunction with a hashCode(), 
	 * to see if two rats are the same two rats. These Rats will said to be the same if they are the same object 
	 * OR if two rats have the same age
	 *if this returns true and the hashcode is the same for both Rats, then both rats will NOT BE added
	 */
	@Override
	public boolean equals(Object obj) {
		Rat other=(Rat)obj;
		return age==other.age;
		
	}
	/**
	 * This is a overridden() method that will be used, in conjunction with equals() method, to see if two
	 * rats are deemed to be the same two rats.
	 * if two Rats have the same age, they will have the same HashCode number, so two Rats of the same 
	 * age will NOT be added to the set
	 */
	@Override
	public int hashCode() {
		int number=41;
		return age*number;
	}
	/**
	 * if we implement the comparable interface (see section 3.4), this is the method that needs to be overridden.
	 * this will be delved into in greater detail in section 3.4
	 */
	@Override
	public int compareTo(Rat arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
		
		

}
