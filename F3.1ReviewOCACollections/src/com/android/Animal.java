package com.android;
/**simple class to create Animals
 * Animal class does NOT have it's own equals method, so it will use the equals() method from the Object class
 * so Animals will said to be equal only if two references point to the same Animal*/
public class Animal {
	/**name of Animal*/
	String name;
	/**constructor for Animal class that takes a String*/
	Animal(String name){
		this.name=name;
	}
/**toString method for Animal class that prints out the name of the Animal*/
	@Override
	public String toString() {
		return "name is "+name;
	}
}
