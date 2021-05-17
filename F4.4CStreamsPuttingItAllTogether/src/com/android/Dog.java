package com.android;
/**
 * this class will be used in conjunction with  {@link com.android.Examples#ex3()} as this class wil be used
 * with sorted() (which takes no arguments) and will be the data type of a TreeSet, this class will HAVE TO 
 * implement Comparable. Only classes that implement Comparable can be in a TreeSet or use the overloaded sorted()
 * method that takes no arguments.
 * @author NoelF
 * @see com.android.Examples#ex3()
 */
public class Dog implements Comparable<Dog>{
	/**age of Dog*/
	int age;
	/**name of Dog*/
	String name;
	/**constructor that takes a String name and a int age*/
	Dog(String name,int age){
		this.name=name;
		this.age=age;
	}
	/**compares first by name and then by age
	 * @param d2 the Dog we are comparing with
	 * @return two dogs d1 and d2, and method call is d1.compareTo(d2). if d1 greater than d2 return 1, if d1 same as d2 return
	 * 0, if d1 less than d2 return -1.
	 */
	@Override
	public int compareTo(Dog d2) {
		int result=name.compareTo(d2.name);
		if(result!=0)
			return result;
		result=age-d2.age;
		return result;
	}
	/**
	 * Overridden method that prints out age and name of Dog
	 * @return a string that contains the age and name of the Dog
	 */
	@Override
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + "]";
	}
	/**
	 * Overrideen hashCode method that calculates a Hash from the age and name of the dog
	 * @return a int produced from the age and name of the Dog
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/**
	 * it two Dogs have the same age and name, they will be said to be the same. All other cases they will said to be
	 * NOT the same
	 * @param obj the other object we are comparing our Dog with
	 * @return returns true if two dogs have the same name and age, false in all other circumstances.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Dog))
			return false;
		Dog other = (Dog) obj;
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
