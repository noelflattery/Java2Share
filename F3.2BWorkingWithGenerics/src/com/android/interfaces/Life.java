package com.android.interfaces;
/**
 * This is Functional Interface, which means it has only ONE abstract method (it can have as many default or static
 * methods as you like). So as well as classes and anonymous classes being able to implement this interface, we can
 * also use lambdas to implement this interface.
 * the {@code @FunctionalInterface} notation is a check to ensure that the interface adheres to the "only one abstract
 * method" rule of functional interfaces. It will not be an error if {@code @FunctionalInterface} is not included, but
 * it will be an error if we have this notation and we try to include another abstract method in the class
 * @author NoelF
 */
@FunctionalInterface
public interface Life {
	/**
	 * our single abstract method that any lambda will have to implement this method an example of which could be
	 * {@code ()->System.out.println("this is a lambda")}
	 */
	void grow();
	/**
	 * does not matter how many  default or static methods are contained within a 
	 * functional interface, all that matters is that you have only ONE abstract
	 * method
	 */
	default void defMethod() {
		
	}
	/**dummy default method of Life interface to show that functional interfaces can have many default methods*/
	default void defMethod2() {
		
	}
	/**dummy static method of life interface to show that functional interfaces can have many static methods*/
	static void statMethod() {
		
	}
	/**dummy static method of life interface to show that functional interfaces can have many static methods*/
	static void statMethod2() {
		
	}

}
