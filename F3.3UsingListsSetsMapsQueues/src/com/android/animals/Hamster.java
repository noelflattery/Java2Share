package com.android.animals;
/**
 * This is a sub class of Animal and this class overrides hashCode and equals() method
 * @author Owner
 *
 */
public class Hamster extends Animal{
	/**age of Hamster*/
	private int age;
	/**name of Hamster*/
	private String name;
	/**weight of Hamster*/
	private double weight;
	/**id to identify a Hamster*/
	private int id;
	/**will keep a count of the amount of Hamsters created*/
	private static int counter=0;
	/**
	 * constructor that takes a int age, String name and a double weight
	 * @param age is the age of a Hamster
	 * @param name is the name of a Hamster
	 * @param weight is the weight of a Hamster
	 */
	public Hamster(int age,String name,double weight){
		this.age=age;
		this.name=name;
		this.weight=weight;
		counter++;
		id=counter;
	}
	/**
	 * Overridden hashCode method that will generate a hash/number based on the age, id,name and weight variables. this
	 * will be used in conjunction with the equals() method to determine if two Hamsters can be said to be the same
	 * @return returns a number calculated from all the variables of a Hamster
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	/**
	 * Overridden equals method that will determine if two Hamsters are the same, this will be used in conjuctions
	 * with the hashCode() to determine if two Hamsters can be said to be the same.
	 * @return returns true if both Hamsters are the same object or if they have all the same variable values, false if not
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Hamster))
			return false;
		Hamster other = (Hamster) obj;
		/*
		 * as the hashCode is produced from ALL the variables of the Hamster, we can use this syntax to
		 * check if the two hamsters have the same age,id,name and weight.
		 */
		if(hashCode()!=other.hashCode())
			return false;
		return true;
		/*
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;*/
	}
	

}
