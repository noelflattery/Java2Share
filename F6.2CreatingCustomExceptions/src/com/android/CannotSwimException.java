package com.android;
/*
 * this is our own CHECKED exception class, which means when we create an object of this class
 * we have to put that in a try/catch block
 * this exception class will have three constructors
 * this will mean that this exception can provide three different functions
 */
public class CannotSwimException extends Exception{
	//no arguments constructor
	public CannotSwimException() {
		super();//calling constructor in exception class that takes no arguements
		System.out.println("cannotSwim exception that takes no arguements");
	}
	//a constructor that takes an exception as an arguement
	public CannotSwimException(Exception e) {
		super(e);//calling constructor in exception class that takes an exception
		System.out.println("constructor that takes an exception as an arguement");
	}
	//a constructor that takes a string as a argument
	public CannotSwimException(String message) {
		super(message);//calling constructor in exception class that takes a string
//		System.out.println("constructor that takes a string which is "+message);
	}

}
/*
 * this is creating our own runtimeException class
 */
class DangerInTheWater extends RuntimeException{
	
}
/*
 * this is a subclass of our checked exception CannotSwimException, so this is also a checked
 * exception
 */
class DrowningException extends Exception{
	
}
/*
 * this is a subclass of our runtimeException DangerInTheWater, so this is also a RuntimeException
 */
class SharkInTheWater extends DangerInTheWater{
	
}
class Animal{
	String name;
	void swim()throws CannotSwimException{
		System.out.println("this type of Animal can swim");
	}
	
	Animal(){
		
	}
	
	Animal(String name){
		this.name=name;
	}
	
	public String toString() {
		return "animal name is "+name;
	}
}
class Person extends Animal{
	/*
	 * this method has to be in try/catch or whatever method is calling this has to "throws 
	 * CannotSwimException" 
	 */
	@Override
	void swim()throws CannotSwimException{
		System.out.println("help i can't swim");
		throw new CannotSwimException();
	}
}



