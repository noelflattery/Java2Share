package com.android;
/**
 * marks this interface as a functional interface which then can be used
 * in a lambda if you want
 * has one abstract method void drive that takes a generic type T, and each class uses a number of techniques to give a type To T
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 * @see com.android.Car
 * @see com.android.Boat
 * @see com.android.Aeroplane
 * @see com.android.Train
 */
@FunctionalInterface
public interface Transport<T> {
/**
 * this is the one abstract method that any class or lambda has to implement
 * @param t is a type that will set when a class or lambda implements this interface
 */
	void drive(T t);
}
/**Car implements Transport and defines type T to be an integer, so the drive method will take a 
 * type of Integer
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>*/
class Car implements Transport<Integer>{
/**
 * from the Class Car defintion, it has defined type T to be an Integer, so the void drive method
 * then will define type T to be an Integer
 * @param t the implementation of this class gives this type to be a Integer
 */
	@Override
	public void drive(Integer t) {
		System.out.println("your are driving your car");
		System.out.println("your speed is "+t);
		
	}	
	/**this is not available to a Transport referenced object*/
	public void commute() {
		
	}
}
/**Boat implements Transport and defines type T to be a String, so the drive method will take a type 
 * of String
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
class Boat implements Transport<String>{
/**
 * From the class Boat definition, it has defined type T to be a String, so the void drive method will
 * define type T to be a String
 * @param t the implementation of this class gives the type to be a Integer
 */
	@Override
	public void drive(String t) {
		System.out.println("you are driving your boat");
		System.out.println("your name is "+t);
		System.out.println("length of name is "+t.length());
		
	}
	/**
	 *this method is OVERLOADED and is a totally different method to 
	 *drive(String t) and is not related to it in any way really
	 *@param t different parameter type to drive(String), so this is overloaded
	 */
	public void drive(int t) {
		
	}
	/**this method is only for Boats and sub classes of boar, if you have a Transport reference to a 
	 * Boat object you will NOT be able to access this method
	 */
	public void sail() {
		System.out.println("boat sailing");
	}
	
}
/**
 * type t is is a Human, Human is a class we created ourself which is
 * in the Animal class. so type T will be a Human
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
class Aeroplane implements Transport<Human>{
/**
 * from the Aeroplane class definition we can see that type T was set to be a human, so this drive method
 * will take a type of Human as t
 *@param t From the class Boat definition, it has defined type T to be a Human
 */
	@Override
	public void drive(Human t) {
		System.out.println("you are driving your aeroplane");
		System.out.println(t+" is driving the aeroplane");
		
	}
	/**this method only available to Aeroplanes and subclasses of Aeroplane and again a Transport reference to a
	 * Aeroplane object will not have access to this method*/
	void fly() {
		System.out.println("aeroplane flying");
	}
	
}
/**
 * Our class also has a generic type T
 * when creating a Train object we can use the Trains Generic to give a value to Type T that is also
 * the Transports Generic which is used in the drive method
 * this class differs for other classes that implement Transport in that we don't supply a type, it will
 * be supplied when creating a Train object
 * To see video tutorial for this section of code
 * <a href="https://youtu.be/y5yyze96L0A">Video tutorial</a>
 * For all 177 videos, which cover all the topics in this course go to
 * <a href="https://youtube.com/playlist?list=PL8PS0RTQpPaeIdTmq935ugrUHQJTavuX-">Complete Course Video Tutorial</a>
 */
class Train<T>implements Transport<T>{
/**
 * type T has not been defined in the Train class definition, this will be provided when we are creating 
 * a Train object
 * @param t will be given a type when we are creating a Train object
 */
	@Override
	public void drive(T t) {
		// TODO Auto-generated method stub
		
	}
	
}