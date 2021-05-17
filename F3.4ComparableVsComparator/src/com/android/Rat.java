package com.android;
/**
 * Rat class implements Comparable which means it has a CompareTo method and can be inserted into a 
 * TreeSet
 * Rat implements the Comparable interface and provides a type of {@code <Rat>}, which means that
 * the compareTo method will also take a Rat
 * {@code public int compareTo(Rat r)}
 * if a mehtod is implementing the comparable interface you should also override the hashCode and equals() method
 * (as if you don't your code will use the equals() method and hashCode() method of the Object class to determine
 * if two objects are the same)
 * this is used in Examples.ex2() method
 * and in Examples.ex3()
 * @author Owner
 *{@link com.android.Examples#ex2()}
 *{@link com.android.Examples#ex3()}
 */
public class Rat implements Comparable<Rat>{

/**
 * name of the Rat
 */
	String name;
	/**age of Rat
	 * we are using wrappers, instead of primitives, so we can use the compareTo() methods of the 
	 * Integer and Double class. You could also use primitives here, but when using compareTo we would
	 * have to use them in conjunction with wrappers.
	 */
	Integer age;
	/**weight of Rat, again it's a wrapper and not a primitive double*/
	Double weight;
	/**
	 * Overridden hashCode that is produced on the age, name and weight of the Rat
	 * @return produces a number based on the age, name and weight of Rat
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}
	/**
	 * Overridden equals method that is says if a two Rats have the same name, age and weight they will be said
	 * to be the same
	 * @return true is same Rat or if have same name, age and weight, false in all other circumstances
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Rat))
			return false;
		Rat other = (Rat) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	/*
	 * arrange Rats by name, then age, then weight
	 */
	/**
	 * this method will be called by one rat and sent another Rat,
	 *  which will then compare first by 
	 * name
	 * if they have the same name will then compare them by
	 * age
	 * if they have the same age will then compare them by 
	 * weight
	 * The method returns an number, and the following is an explanation of what the numbers means
	 * We have two Rats, r1 and r2, r1 is calling the compareTo method on r2
	 * {@code r1.compareTo(r2)}
	 * and we will use for instance the metric of age
	 * if r1 is older than r2 or put another way {@code r1.age > r2.age}
	 * then method returns 1
	 * if r1 is younger than r2 or put another way {@code r1.age<r2.age}
	 * then method returns -1
	 * if r1 is the same age as r2 or put another way {@code r1.age==r2.age}
	 * then method returns 0
	 * with a TreeSet, if a r1.compareTo(r2) returns 0, r2, will NOT be inserted
	 * if r1.compareTo(r2) returns 1, r1 and r2 will be inserted and r1 will be placed in the set BEFORE r2
	 * if r1.compareTo(r2) returns -1, r1 and rs will be inserted and r1 will be place in the set AFTER r2
	 * @param r is the rat the rat calling the method is comparing itself with
	 * @return if two rats the same return 0, 
	 * if first rat greater than second rat, return 1
	 * if first rat less than second rat, return -1
	 */
	@Override
	public int compareTo(Rat r) {
		/*
		 * if we use ints instead of Integer we have to do somethign like the following, where we 
		 * assign the int to a Integer, so we can then call the compareTo() method of the 
		 * Integer class
		 */
		int num=5;
		Integer number=num;
		//if same Rat or have same name,age and weight, will return 0
		//clones, which are different rat but all same values, will not be inserted
		/*
		 * this is calling the equals() method of the Rat class. returns true if same Rat or if 
		 * two Rats have the same name,age and weight
		 */
		if(this.equals(r))
			return 0;
		/*
		 * if two rats have different names then we can use compareTo of the String class to see
		 * the order of strings and use this to order by the name of the Rat
		 */
		if(!(name.equals(r.name)))//if different names
			return name.compareTo(r.name);//order by names
		/*
		 * if two rats have a different age, then we can use the compareTo of the Integer class to see
		 * the order of Integers and use this to order by the age of the Rat
		 */
		if(!(age.equals(r.age)))
			return age.compareTo(r.age);
		/*
		 * if both Rats are different (which we know as this.equals(r) has returned false if we get to
		 * this point) and if the names and ages are different (which again we know if we have got to this
		 * point) then we do not need to check if weight is different, as if it gets to this point 
		 * WEIGHT CAN ONLY BE THE ONLY POINT OF DIFFERENCE BETWEEN THE TWO RATS
		 */
		return weight.compareTo(r.weight);
		
	//	return 0;
	}
	/**
	 * Overridden toString method that prints out name, age and weight of Rat
	 * @return a string that contains name, age and weight of Rat
	 */
	@Override
	public String toString() {
		return "name is "+name+" age is "+age+" weight is "+weight;
	}
	/**
	 * Constructor that takes a String name, Integer age and a Double weight 
	 * @param name is the name of the Rat
	 * @param age is the age of the Rat and this is a Wrapper Integer
	 * @param weight is the weight of the Rat and this is a Wrapper Double
	 */
	public Rat(String name,Integer age,Double weight) {
		super();
		this.name=name;
		this.age=age;
		this.weight=weight;
	}

	
	
}
