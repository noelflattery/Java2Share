package com.android;
/**
 * class that contains our main method
 * Annotating Overriden methods
 * A way to indicate explicitly in the code that a method is being
 * overriden is using the @Override annotation.
 * you do not HAVE TO USE THIS, if you use this and your method is
 * not overriding, it will cause a compilation error
 * the @Override annotation checks if a a method is:
 * Implementing a method from an interface
 * Overriding a superclass method of the current sub class
 * overriding a method declared in the object class, such as 
 * hashcode, equals or toString
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/OSxvxj2O__A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @see com.android.Animal
 * @see com.android.Cat
 * @see com.android.Behaviour
 * @see com.android.Dog
 * @author NoelF
 */
public class Main {
/**
 * Main method but not used in this example as we merely have annotations of the various classes in this project
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
/**
 * super class for Dog and Cat
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/OSxvxj2O__A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @see com.android.Dog
 * @see com.android.Cat
 * @author NoelF
 */
class Animal{
	/**
	 * will be overriden in Cat class, but not in Dog class
	 * @see com.android.Cat#drink()
	 */
	void drink() {
		System.out.println("I am a Animal drinking");
	}
	/**
	 * method that will be OVERLOADED not overriden in Cat class, but not in Dog
	 * @see com.android.Cat#reproduce()
	 */
	void reproduce() {
		System.out.println("I am a Animal reproducing");
	}
	/**
	 * method that will not be overriden by Dog or Cat, so both Dog and Cat will use this 
	 * implementation
	 * @see com.android.Cat
	 */
	void eat() {
		System.out.println("I am a Animal eating");
	}
}
/**
 * Sub class of Animal which overrides the drink() method of the Animal class and overloads the 
 * reproduce method and will use the eat() method from the Animal class
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/OSxvxj2O__A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @see com.android.Animal
 * @author NoelF
 *
 */
class Cat extends Animal{
	/**
	 * I am telling the compiler explicitly that i am overriding the 
	 * drink method from the base Animal class. If we do not correctly
	 * override the drink method (i.e we overload it instead) the code
	 * will NOT COMPILE
	 * @see com.android.Animal#drink()
	 */
	@Override
	void drink() {
		System.out.println("I am a cat drinking");
	}
	/**
	 * this is a overloaded reproduce method, it has a different
	 * parameter list from the reproduce method in the Animal class.
	 * if we put in the {@code @Override} annotation we will get a compilation
	 * errors as this method is overloading and NOT overriding
	 * uncomment {@code @Override} to see error
	 */
	//@Override
	int reproduce(int num) {
		
		return 1;
	}
	/*
	 * we have a void eat(){} in the super Animal class, so if we have
	 * a eat() method in the Cat class it has to be either overriden
	 * or overloaded, this method is neither. It's not overriden as it
	 * has a different return type, int
	 * it's not overloaded as it has the same parameter list
	 */
/*	int eat() {
		return 1;
	}*/
}
/**
 * Behaviour interface that will be implemented by the Dog class
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/OSxvxj2O__A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @see com.android.Dog
 * @author NoelF
 *
 */
interface Behaviour{
	/**
	 * abstract method will be implemented in Dog class
	 * @see com.android.Dog#sad()
	 */
	void sad();
	/**
	 * abstract method will be implemented in Dog class
	 * @see com.android.Dog#mad()
	 */
	void mad();
	/**
	 * abstract method will be implemented in Dog class
	 * @see com.android.Dog#happy()
	 */
	void happy();
}
/**
 * sub class of Animal that does not override any method of the Animal class so will use all
 * Implementations of methods from the Animal class
 * As this class the Behaviour interface, it HAS to override all the abstract methods from that 
 * class
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/OSxvxj2O__A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @see com.android.Behaviour
 * @see com.android.Animal
 * @author Owner
 *
 */
class Dog implements Behaviour{
/**
 * when you are implemening the Behaviour interface you are overriding
 * all of the abstract methods contained within the Behaviour Interface.
 * Removing the @Override annotation will not cause an error as the
 * Override annotation is only a check to ensure that the method is
 * overriding
 * @see com.android.Behaviour#sad()
 */
	@Override
	public void sad() {
		// TODO Auto-generated method stub
		
	}
/**
 * overriding the void mad() abstract method from the Behaviour interface
 * @see com.android.Behaviour#mad()
 */
	@Override
	public void mad() {
		// TODO Auto-generated method stub
		
	}
/**
 * Overriding the void happy() abstract method from the behaviour interface
 * @see com.android.Behaviour#happy()
 */
	@Override
	public void happy() {
		// TODO Auto-generated method stub
		
	}	
}
/**
 * class Cow does not implement the behavior interface or does not extend Animal
 * it does however override the toString() method of the Object class
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/OSxvxj2O__A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @author NoelF
 */
class Cow{
	/**
	 * here we are overriding one of the methods from the Object
	 * superclass, the 
	 * public String toString() method
	 * again it's not an oerror to have not @Overriden annotation as 
	 * this is merely a check that enforces overriding
	 * @return returns a string that just prints out a message overriding the toString method of the Object class
	 */
	@Override
	public String toString() {
		return "overriding the toString method of the Object class";
	}
}
