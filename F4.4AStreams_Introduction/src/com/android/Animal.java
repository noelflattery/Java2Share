package com.android;
/**
 * Animal classes that will be used to create Streams of Animals
 * @author NoelF
 *
 */
public class Animal {
	/**
	 * this is the age of a Animal	
	 */
	int age;
	/**
	 * this is the name of a Animal
	 */
	String name;
	/**
	 * Constructor that takes no arguments
	 */
	Animal(){
		
	}
	/**
	 * Constructor that takes a int age and String name
	 * @param age is the age of the Animal
	 * @param name is the name of the Animal
	 */
	Animal(int age,String name){
		this.age=age;
		this.name=name;
		System.out.println("Constructor called");
	}
	/**
	 * Overridden method that prints out the age and name of an Animal
	 * @return returns a String that will contain all fields of the Animal
	 */
	@Override
	public String toString() {
		return "Animal [age=" + age + ", name=" + name + "]";
	}
	

}
/**
 * Rat class for usuage with streams, specifically using Max() and Min() methods of the Stream {@link com.android.Examples#ex5()}
 * and has use them to create HashSet, which will then be used to create streams. 
 * This implements the comparable method with a {@code <Rat>} type and the comparable method has a method signature like
 * {@code public int compareTo(Rat r1)}
 * @see com.android.Examples#ex5()
 * @author NoelF
 */
class Rat implements Comparable<Rat>{
	/**
	 * the weight of a Rat
	 */
	Double weight;
	/**the age of a Rat*/
	int age;
	/**the name of a Rat*/
	String name;
	/**No arguement Constructor*/
	Rat(){
		
	}
	/**
	 * constructor that takes a int age, String name and double weight
	 * @param age is the age of a Rat
	 * @param name is the name of a Rat
	 * @param weight is the weight of a Rat
	 */
	public Rat(int age,String name,double weight) {
		super();
		this.age=age;
		this.name=name;
		this.weight=weight;
	}
    /**
     * Overridden hashcode method that creates a number from the age, name and weight of a Rat, used in HashSet, TreeSet and
     * Maps to determine if two objects match
     * @return returns a number hash created from the age, name and weight of the Rat
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	/**
	 * Overridden equals method that will return true if two Rats have the same age, name and weight, will return false
	 * if any of these do not match in our two Rats. Used in all Sets, and Maps to determine if two objects are the same
	 * @return returns true if same age, name and weight, false in all other circumstances
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Rat))
			return false;
		Rat other = (Rat) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
	/**
	 * overridden toStrin method that prints out the name, age and weight of the Rat
	 * @return returns a String with the rats name, age and weight
	 */
	@Override
	public String toString() {
		return "Rat name is "+name+" age is "+age+" weight is "+weight;
	}
	/**
	 * overridding the compareTo method of the Comparable interface with type {@code <Rat>}
	 * will compare in order
	 * names and sorts alphabetically
	 * if they have the same name will then sort by
	 * age and sorts age with oldest to youngest order
	 * if they have the same age will then sort by
	 * weight and sorts by heaviest to lightest order
	 * r1 is the rat calling the method, r2 is the rat sent to the method and the method call would be
	 * r1.compareTo(r2)
	 * @param r2 the Rat that is sent to the method and is being compared with the Rat that called the method
	 * @return if r1 is considered "bigger" then a positive number will be returned 
	 * if r1 is considered "smaller" then a negative number will be returned
	 * if r1 and r2 are considered the same then 0 will be returned
	 * 
	 */
	@Override
	public int compareTo(Rat r2) {
		//if they are the same rat or both rats have same age, weight and name
		//then return 0
		if(this.equals(r2))
			return 0;
		/*
		 * compare by names first
		 * if not the same name, use the compareTo method of the String class to 
		 * find out which string comes first
		 * the String class does implement Comparable, so you can use the 
		 * compareTo() method to sort rats
		 */
		if(!(name.equals(r2.name)))
			return name.compareTo(r2.name);
		/*
		 * if same name, sort by age
		 */
		if(age!=r2.age)
			/*
			 * can't use compareTo with age because age is an int, and int is not
			 * a class, so it can't implement Comparable
			 */
			return age-r2.age;
		/*
		 * if both rats are not the same, which we know they are not if we get to this
		 * line of code as 
		 * this.equals(r1) has already returned false if we get to this stage of the code
		 *weight is a Double wrapper object and this class implements comparabled
			so we can use compareTo with this variable
		 */
		return weight.compareTo(r2.weight);
	}
	
	
}
/**
 * Badger class for Usage with Streams. As Badger class implements the Comparable interface, a Badger can be added to 
 * a Treeset of Animals or Badgers and also can be used with the Max() and Min() methods of Stream class @link com.android.Examples#ex5()}
 * this implements the Comparable interface with type {@code <Badger>}
 * @author NoelF
 *
 */
class Badger extends Animal implements Comparable<Badger>{
/**
 * overriding the compareTo() method of the Comparable interface with type Badger. If a Badger, call bad1, was comparing itself with 
 * another badger, bad2, the method call would look like the following
 * bad1.compareTo(bad2)
 * @param bad2 the badger that is being compared to the badger calling the method
 * @return returns 1 if bad1 is said to be greater than bad2, 0 if bad1 is said to be equal to bad2, and -1 if bad1 is said to 
 * be less than bad2
 */
	@Override
	public int compareTo(Badger bad2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
