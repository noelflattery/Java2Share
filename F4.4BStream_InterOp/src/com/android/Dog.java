package com.android;
/**
 * This class implements Comparable with a Dog object and will be used to illustrate the intermediate sorted() operation
 *  for video tutorial of this code go to 
 * <a href="https://www.youtube.com/watch?v=UNu8I-eu40Y&list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-&index=60">video Tutorial</a>
 * @author NoelF
 * @see com.android.Examples#ex4()
 * @see com.android.Examples#ex6()
 * @author NoelF
 */
public class Dog implements Comparable<Dog>{
	/**age of Dog*/
	int age;
	/**weight of Dog*/
	int weight;
	/**
	 * Constructor that takes a int age and int weight
	 * @param age this is the age of the Dog
	 * @param weight this is the weight of the Dog
	 */
	public Dog(int age, int weight) {
		super();
		this.age = age;
		this.weight=weight;
	}
	/**a method that returns a new Cat that will be used in conjunction with the intermediate Map() operation
	 * @return returns a new Cat based on the weight and age of the Cat calling this method
	 * @see com.android.Examples#ex4()
	 */
	Cat makeCat() {
		return new Cat(age,weight);
	}
	/**overridden toString method that prints the age and weight of the Dog
	 * @return returns a string that contains the age and weight of the dog
	 */
	@Override
	public String toString() {
		return "Dog [age=" + age + ", weight=" + weight + "]";
	}
	/**
	 * this is overriding the compareTo() method of the comparable interface. This means that you can have a 
	 * TreeSet of Dogs and also can use the intermediate sorted() operation with a stream of Dogs
	 * {@link com.android.Examples#ex6()}
	 * this sorts first by age of Dog, and then if two dogs have the same age it will sort them by weight
	 * @param d is the Dog the dog calling this method is being compared with
	 * @return two dogs, d1 and d2, d1.comapreTo(d2). if d1 is bigger than d2, then return 1. if d1 same as d2 then 
	 * return 0. If d1 smaller than d2, then return -1
	 */
	@Override
	public int compareTo(Dog d) {
		int result=age-d.age;
		if(result!=0)
			return result;
		result=weight-d.weight;
		return result;
	}
	
	

}
