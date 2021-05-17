package com.android;
/**
 * this class does NOT implement Comparable, so if we wish to create a TreeSet of type Cat, we have to create a seperator compartor
 * for this class
 * @author NoelF
 * @see com.android.Examples#ex3()
 */
public class Cat {
	/**age of Cat*/
	Integer age;
	/**Name of Cat*/
	String name;
	@Override
	/**
	 * overridden toString method that prints out age and name of Cat
	 */
	public String toString() {
		return "Cat [age=" + age + ", name=" + name + "]";
	}
	/**
	 * constructor that takes a int age and a String name
	 * @param age is the age of the Cat
	 * @param name is the name of the Cat
	 */
	public Cat(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	@Override
	/**
	 * overridden hashCode method that returns a hash based on the age and name of the Cat
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/**
	 * Overridden equals method that returns true if both cats have the same age and name, and returns false in all other 
	 * circumstances
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
