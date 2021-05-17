package com.android;

import java.util.function.Predicate;
/**
 * class where we first come across a method that takes a predicate
  * this is a class which has the name of the species and two boolean
	 * values hop and swim
	 * if the Animal can hop, then the hop boolean value will be true,
	 * otherwise it will be false
	 * if the Animal can swim, then the swim boolean value will be true,
	 * otherwise it will be false
	 * To see video tutorial for this section of code
	 * <a href="https://youtu.be/8cFj6gYDndk">Video tutorial</a>
	 * For all 177 videos, which cover all the topics in this course go to
	 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
public class Animal {
	/**
	 * this boolean value will tell you if the animal can hop or not
	 * if an Animal can hop this will be true, if cannot this will be false
	 */
	private boolean hop;//can the Animal hop, true or false
	/**This boolean value will tell you if the animal can swim or not
	 * if an Animal can swim this will be true, if cannot this will be false
	 */
	private boolean swim;//can the Animal swim, true or false
	private String name;//name of species of Animal
	
	/**
	 * Constructor that takes a String name, a boolean hop and a boolean swim
	 * @param name name of the Animal
	 * @param hop true if the animal can hop, false if not
	 * @param swim true if the animla can swim, false if not
	 */
	Animal(String name,boolean hop,boolean swim){
		this.name=name;
		this.swim=swim;
		this.hop=hop;
	}
	/**method to test if our animal can hop
	 * this will return true or false and will print out, "can hop" if the
	 * animal can hop, and print out "cannot hop" if the Animal cannot hop
	 * @return true if can swim, false if not
	 */
	public boolean canHop() {
		if(hop)
			System.out.println(name+" can hop");
		else
			System.out.println(name+" cannot hop");
		return hop;
	}
	/**
	 * method to test if our animal can swim
	 * @return true if can swim, false if not
	 */
	public boolean canSwim() {
		if(swim)
			System.out.println(name+" can swim");
		else
			System.out.println(name+" cannot swim");
		return swim;
	}
	/**
	 * this takes as parameters a Animal object and a predicate that itslef
	 * takes in an Animal and returns true or false
	 * This method takes an Animal, which will be a fish or a rabbit, and 
	 * a predicate, which will be the implementation of the boolean test(Object obj)
	 * method of the built in functional interface called predicate. 
	 * the test method can take in any object, however here we have said that the
	 * object test takes in, will be a Animal.
	 * the body of the predicate will return true or false, which will be 
	 * an Animal object calling the canHop() or canSwim() method
	 * @param animal a Animal object that will be used the predicate sent as a second parameter
	 * @param trait the predicate that will use the Animal object sent as the first parameter
	 */
	public static void print(Animal animal,Predicate<Animal>trait) {
		trait.test(animal);
	}
	

}
