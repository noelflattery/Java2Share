package com.android;
/**
 * class that implements the Behaviour interface, specifically the Sad and Mad() method
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 *
 */
public class Animal implements Behaviour{
/**abstract method in Behaviour interface*/
	@Override
	public void sad() {
		System.out.println("Animal sad");
		
	}
/**abstract method in Behaviour interface*/
	@Override
	public void mad() {
		System.out.println("Animal mad");
		
	}
	/**
	 * this method can take a Animal, a Human or a Dog, as all of these
	 * classes implement the Behaviour interface OR it could be an
	 * anonymous class implementation of the Behaviour interface. IT
	 * CANNOT BE A LAMBDA, as lambdas only work with functional intefaces
	 * (only one abstract method) and Behaviour has 2 abstract methods
	 */
	static void takeAny(Behaviour behave) {
		/*
		 * different types of objects, will have different implemenation
		 * of these methods, so you will have different outcomes 
		 * thats polymorphism
		 */
		behave.sad();
		behave.mad();
	}

}//end of Animal class
/**
 * call that implements the Behaviour interface, specifically the sad() and mad() method
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoeF
 *
 */
class Human implements Behaviour{
/**abstract method in Behaviour interface*/
	@Override
	public void sad() {
		System.out.println("Human  sad method");
		
	}
/**abstract method in Behaviour interface*/
	@Override
	public void mad() {
		System.out.println("Human mad method");
		
	}
/**this is a ordinary concrete method of the Human class so this method will not be available to a 
 * Behaviour referenced object */	
	public void talk() {
		System.out.println("human talking");
	}
	/**name of the Human*/
	public String name;
	/**toString method just prints out the name of the Human
	 * @return returns a string with just the name of hte HUman*/
	public String toString() {
		return name;
	}
	
}
/**Dog class extends Animal so that means it also implements the Behaviour Interface as the Animal
 * class implements Behaviour
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
class Dog extends Animal{
	/**Dog bark method that is method only avaiable to A dog reference object or a subclass of Dog
	 * reference. A Behaviour interface reference to a Dog object will not have access to this method
	 */
	void bark() {
		System.out.println("Dog barking");
	}
	/**
	 * this is overriding the mad() method in the Animal, and it 
	 * also has a sad() method as the Dog class extends the Animal
	 * class
	 */
	@Override
	public void mad() {
		System.out.println("Dog mad method");
	}
}
