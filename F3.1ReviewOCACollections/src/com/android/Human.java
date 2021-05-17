package com.android;
/**class to create Human Objects
 * This class overrides the equals() method, so it has it's own equals class. 
 * if two objects have the same name then the equals method returns true
 * Here i have also implemented the Comparable Interface, but we will not use this until we have covered 
 * functional programming in chapter 4
 * the method that is implemented from the comparable interface is 
 * public int compareTo(Object o)
 * @author Owner
 *
 */
public class Human implements Comparable<Human>{
	/**name of Human*/
	String name;
/**constructor of Human class that takes a String name*/
	public Human(String name) {
		super();
		this.name = name;
	}
/**hashCode for Human class */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
/**equals method for Human class, if two humans have the same name we say they are equal*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Human))
			return false;
		Human other = (Human) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
/**toString method for the Human class that prints the name of the Human*/
	@Override
	public String toString() {
		return "Human [name=" + name + "]";
	}
/**this is implementing the compareTo() method of the Comparable interface
 * it is using the the compareTo method of the String class and this can be used to sort lists of Humans*/
	@Override
	public int compareTo(Human o) {
		// TODO Auto-generated method stub
		return o.name.compareToIgnoreCase(name);
	}
	

}
