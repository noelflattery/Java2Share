package com.android;
/**
 * Cat class that overrides the equals() method which will be used in conjunction with the Intermediate operation 
 * distinct
 * for video tutorial of this code go to 
 * <a href="https://www.youtube.com/watch?v=UNu8I-eu40Y&list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-&index=60">video Tutorial</a>
 * @see com.android.Examples#ex2()
 * @author NoelF
 */
public class Cat {
	/**age of Cat*/
	int age;
	/**weight of Cat an int*/
	int weight;
	/**constructor that takes an int age and a int weight*/
	public Cat(int age, int weight) {
		super();
		this.age = age;
		this.weight = weight;
	}
	
	@Override
	/**
	 * overriden toString method that prints out the age and weight of the Cat
	 * @return returns a string with age and weight
	 */
	public String toString() {
		return "Cat [age=" + age + ", weight=" + weight + "]";
	}
	
	@Override
	/**
	 * Overridden hashCode method that produces a hash using the age and weight of a cat
	 * @return returns an int calculated from the age and weight of the cat
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + weight;
		return result;
	}
	@Override
	/**
	 * returns true if the cat has the same age and weight, false in all all circumstances
	 * @param obj the object the cat calling the method will be comparing itself with
	 * @return true if same age and weight, false in all other circumstances
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cat))
			return false;
		Cat other = (Cat) obj;
		if (age != other.age)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	

}
