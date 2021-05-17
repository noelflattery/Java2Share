package com.android;
/**
 * Functional interface with one abstract method void walk and a generic type T
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
@FunctionalInterface
public interface Movement<T> {
	/**Abstract method with a type that will be supplied by the object implementing the interface
	 * when we create a lambda we will be supplying the type, which
	 * will then become t
	 */
	void walk(T t);

}
/**
 * Class that implements Movement and provides a type of Integer, so type T void walk() method will be
 * an integer, or void walk(Integer)T
 * this implements the Movement interface and type T becomes an
 * Integer
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
class Mammal implements Movement<Integer>{
/**
 * method walk has had type t to be an integer with the generic type Integer in the class declaration of 
 * Mammal
 */
	@Override
	public void walk(Integer t) {
		System.out.println("Mammal walk method");
		System.out.println("t is of type "+t.getClass().getSimpleName());
		t=t*t;
		System.out.println(t);
	}
	/**Static method that can take a number of different Movement interface referenced object
	 * this method takes a Movement reference and an object
	 * the movement reference and the object t can only be certain 
	 * combinations
	 * a Movement reference to a Mammal object, has to have a Integer
	 * sent with it
	 * * a Movement reference to a Cow object, has to have a Integer
	 * sent with it
	 * * a Movement reference to a Employee object, has to have a Dog
	 * sent with it
	 * or it can take a Lambda that implements the functional interface
	 */
	static void takeMovement(Movement m1,Object t) {
		m1.walk(t);
	}
	
}
/**Class Fish implements the Movement interface
 * here we implement the Movement interface, without specifying what
 * type T will be. In that case type T, is inferred to be an Object
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
class Fish implements Movement{
/**
 * for the walk method we have not supplied a type, so "t" will be assumed to be an
 * Object
 * @param t as we did'nt provide a type when this class implements {@code Movement<V>}, the type wil said to be a object
 */
	@Override
	public void walk(Object t) {
		System.out.println("fish Walk method");
		System.out.println("t is of type "+t.getClass().getSimpleName());
		
	}
	
}
/**Class Cow extends Mammal so it takes everything from the super Mammal class and as Mammal implements
 * Movement so does Cow, so you can have a Movement reference to a Cow class object
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
class Cow extends Mammal{
	
}
/**class Employee implements Movement with type T said to be a dog
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
class Employee implements Movement<Dog>{
/**
 * For the walk method we have supplied the type to be a Dog, as that was the generic specified in the 
 * declaration of the Employee class when implementing the Movement interface
 * @param t this has been given a type of Dog by the classes implementation of Movement
 */
	@Override
	public void walk(Dog t) {
		System.out.println("employee walk method");
		System.out.println("type t is "+t.getClass().getSimpleName());
		t.bark();
		
	}
	
}
