package com.android;
/**
 * Duck class that will be used in conjuction with various comparator that can be used to sort a list of 
 * Ducks. this class does not implement comparable, which is why we have to use a comparator when using
 * Collections.sort()
 * @author NoelF
 * @see com.android.Examples#ex4()
 * 
 */
public class Duck {
	/**name of duck, private and has a getter*/
	private String name;
	/**weight of duck, private and has a getter*/
	private int weight;
	/**height of a duck ,private and has a getter*/
	private int height;
	/**counter to check how many ducks are created and give value to id*/
	private static int counter=0;
	/**id of duck and is unique to each duck*/
	private int id;
	/**
	 * getter for name of duck
	 * @return name
	 */
	public String getName() {
		return name;
		
	}
	/**
	 * setter for name of duck
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getter for weight of duck
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * setter for weight of Duck
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * getter for height of duck
	 * @return height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * setter for height of Duck
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * getter for counter variable
	 * @return counter
	 */
	public static int getCounter() {
		return counter;
	}
	/**
	 * setter for counter variables
	 * @param counter
	 */
	public static void setCounter(int counter) {
		Duck.counter = counter;
	}
	/**
	 * getter for id of duck
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * setter for Id of duck
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * constructor that takes a String name, int weight and int height and also increments the Counter and 
	 * assigns the value of counter to id
	 * @param name is the name of the Duck
	 * @param weight is the weight of the Duck
	 * @param height is the height of the Duck
	 */
	public Duck(String name, int weight, int height) {
		super();
		this.name = name;
		this.weight = weight;
		this.height = height;
		id=++counter;
	}
	/**
	 * hashcode generated from a ducks height, id, name and weight
	 * @return generated number from all variables of Duck
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + weight;
		return result;
	}
	/**
	 * if two ducks have the same height, id, name and weight, then they will said to be equal
	 * @return true if same duck or have same height,id,name and weight, false if anything else.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Duck))
			return false;
		Duck other = (Duck) obj;
		if (height != other.height)
			return false;
		if (id != other.id)
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
	 * overridden toString method that prints out name, weight, height and id
	 * @return a string that contains name, weight, height and id
	 */
	@Override
	public String toString() {
		return "Duck [name=" + name + ", weight=" + weight + ", height=" + height + ", id=" + id + "]";
	}
	
	
	
	
	

}
