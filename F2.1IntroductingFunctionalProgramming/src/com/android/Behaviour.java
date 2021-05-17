package com.android;
/**here we create our own Function interface
 * lambdas can only created from Functional interfaces (only be created from
 * interfaces with ONE abstract method)
 * this annotation marks your interface as being a functional interface, 
 * similar to Override annotation you don't have to put in this annotation, but it is
 * useful to remember that your code may be modified by other software 
 * developers in the future. So this prevents other coders from changing
 * this functionalInterface to an ordinary interface. i.e you have a load
 * of code that uses a lot of lambdas, to implement this interface. another
 * software developer comes along, and adds another abstract method to this
 * interface, and it breaks ALL of your lambdas.
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/8cFj6gYDndk">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
@FunctionalInterface
public interface Behaviour {
/**
 * Abstract method of the Behaviour Interface, as this has been marked as a Functional interface you can only 
 * have ONE abstract method inside of this interface
 * if you attempt to put in another abstract method in this interface you will get an compilation error
 */
	void sad();
	/*
	 * if you attempt to put in another abstract method, and you have the 
	 * @FunctionalInterface annotation, you wil get an error and your code 
	 * will not compile
	 */
	//void happy();//comment in this to see an error
	/**
	 * default method of the Behaviour interface
	 * you can have as many default methods as you want in an 
	 * functional interface
	 */
	default void happy() 
	{
		
	}
	/**static method of the Behaviour interface
	 * you can have as many static methods as you want in an functional 
	 * interface
	 */
	static void bad() 
	{
		
	}
}
