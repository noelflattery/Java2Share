package com.android.animals;
/**
 * class that is a subclass of animal and implements the Behaviour Interface
 * @author Owner
 */
public class Dog extends Animal implements Behaviour{
	/**age variable of the Dog class, which hides the age variable of the super class Animal*/
	public int age;
	/**name variable of the Dog class, which hides the name variable of the super class Animal*/
	public String name;
	//static int count=0;
	//int id;
	/**constructor that takes a String name and a int age and also by default calls the super constructor of the 
	 * animal class that takes no arguements, which will count the amount of Animals created
	 * @param name of Dog
	 * @param age of Dog
	 */
	public Dog(String name,int age){
		super();
		this.name=name;
		this.age=age;
	//	count++;
	//	id=count;
	}
	/**Overridden hashCode method of the Object class. this will be used in conjunction with the equals() method to
	 * determine if two dogs are the same. 
	 * @return result The hashcode number is produced from the String name variable and the 
	 * int age variable. so if they have the same name and age, they will produce the same hash code number*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
/**overriden equals method of the object class, if two Dogs have same name and age, then they will said to be
 * the same and will return true from this method
 * @param obj is the other Object we are comparing our Dog too
 * @return this will return if both Dogs have the same name and age
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
/**
 * constructor that has no arguements
 */
	public Dog() {
		
	}
/**
 * toString method of the  Dog class, which hides the toString method of the Animal class
 * @return String will print out the name and age of the Dog	
 */
	public String toString() {
		return "name is "+name+" age is "+age;
	}
/**sad method of hte Dog class*/
	@Override
	public void sad() {
		System.out.println("dog sad");
		
	}
	

}
