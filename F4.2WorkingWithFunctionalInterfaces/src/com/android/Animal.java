package com.android;
/**
 * A class that can be used in conjunction with some of the functional interface code in 
 * Examples.ex3, Examples.ex4
 * this is also the super class Hamster and Cat. Any lambda that implements a functional interface and takes
 * as one of it's type an Animal, will also then be able to take a Hamster or a Cat, as already said Hamster and
 * Cat is a sub class of Animal, or to put it another way
 * A Hamster is a Animal
 * A Cat is a Animal
 *@author NoelF
 *@see com.android.Examples#ex3()
 *@see com.android.Examples#ex4()
 *@see com.android.Examples#ex9()
 */
public class Animal {
	/**age of Animal*/
	int age;
	/**name of animal*/
	String name;
	/**
	 * Constructor that takes a int age and String name
	 * @param age is the age of a Animal
	 * @param name is the name of a Animal
	 */
	public Animal(int age, String name) {
		super();
		this.age = age;
		this.name = name;
		System.out.println("animal with age and name created");
	}
	/**
	 * Constructor that takes no arguments
	 */
	Animal(){
		System.out.println("animal with no arguements created");
	}
	/**
	 * Overriden toString method that prints out age and name
	 * @return returns a string that contains the age and name
	 */
	@Override
	public String toString() {
		return "Animal [age=" + age + ", name=" + name + "]";
	}
	/**
	 * method that takes a String and for usage with functional interfaces, for instance a 
	 * {@code Consumer<String>} lambda
	 * @param myStr a simple string variable that can be used in a Consumer
	 */
	static void takeString(String myStr) {
		System.out.println(myStr+" in static method takeString");
	}
	/**
	 * method that takes a string and for usage with functional interfaces, for instance a 
	 * {@code Consumer<String>} lambda
	 * @param food a simple string variable that can be used in a Consumer
	 */
	void eat(String food) {
		System.out.println("i eat "+food);
	}
	/**
	 * method that returns a String and for usage with functional interfaces, for instance a 
	 * {@code Supplier<Integer>} lambda
	 * @return a Integer number that could be returned by a Supplier
	 */
	Integer drink() {
		System.out.println("animal drinking");
		return 1;
	}
	/**
	 * static method that returns a Double and for usage with functional interfaces, for instance a 
	 * {@code Supplier<Double>}
	 * @return a Double number that could be returned by a supplier
	 */
	static Double statMethod() {
		return 12.3;
	}
}
/**
 * subclass of Animal so inherits everything from the Animal class
 * @author NoelF
 */
class Hamster extends Animal{
	
}
/**
 * subclass of Animal so inherits everything from the Animal class
 * @author NoelF
 */
class Cat extends Animal{
	
}
