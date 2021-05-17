package com.android;
/**
 * Squirrel  class implements Comparable which means it has a CompareTo method and can be inserted into a 
 * TreeSet
 * Squirrel  implements the Comparable interface and provides a type of {@code <Squirrel>}, which means that
 * the compareTo method will also take a Rat
 * {@code public int compareTo(Squirrel s)}
 * if a mehtod is implementing the comparable interface you should also override the hashCode and equals() method
 * (as if you don't your code will use the equals() method and hashCode() method of the Object class to determine
 * if two objects are the same)
 * this is used in Examples.ex3() method
 * @author Owner
 *{@link com.android.Examples#ex3()}
 */
public class Squirrel implements Comparable<Squirrel>{
	/**name of Squirrel*/
	private String name;
	/**weight of Squirrel*/
	private int weight;
	/**height of Squirrel*/
	private int height;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Squirrel))
			return false;
		Squirrel other = (Squirrel) obj;
		if (height != other.height)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
/**
	 * Constructor that takes a String name, int age and a double weight
	 * also increments the counter and uses this value to give id a value
	 * @param name is the name of the Squirrel
	 * @param weight is the weight of the Squirrel
	 * @param height is the height of the Squirrel
	 */
	public Squirrel(String name,int weight,int height) {
		this.name=name;
		this.weight=weight;
		this.height=height;
	}
/**
 * getter for name
 * @return name
 */
	public String getName() {
		return name;
	}
/**
 * getter for weight
 * @return weight
 */
	public int getWeight() {
		return weight;
	}
/**getter for height*/
	public int getHeight() {
		return height;
	}
/**
 * a simpler compareTo method that only uses names of the Squirrel
 * @return two squirrels s1 and s2, s1 is calling method, s2 is sent to the method
 * if 0 is returned s1 and s2 have the same name
 * if 1 is returned s1 comes before s2 alphabetically
 * if -1 is returned s1 comes after s2 alphabetically
 */
	@Override
	public int compareTo(Squirrel s) {
		/*
		 * we are only organising lists of squirrels by they're name, so name is a string so 
		 * we are using the compareTo() method of the STring class. we could, if we wanted too, also 
		 * include the two int variables of weight and height.
		 */
		return name.compareTo(s.name);
	}
/**
 * overridden toString method that prints out name, weight and height of Squirrell
 * @return a string that contains name, weight and height of Squirrel	
 */
	@Override
	public String toString() {
		return "Squirrel name is "+name+" Squirrel weight is "+weight+" Squirrel height is "+height;
	}

	

}
