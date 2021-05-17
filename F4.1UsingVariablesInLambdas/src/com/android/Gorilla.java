package com.android;
/**
 * rules for accessing variables in lambdas
 * Lambdas can access fields of a class, as they always have a default value even
 * if none are give (i.e String has a default value of null, int has a default
 * value of 0,etc)
 * lambdas can access method parameters, as long as the method parameters values
 * do not change inside the method
 * lambdas can access local variables that have been given a value and are 
 * effectively final, however if you change the value of a local variable a lambda
 * can no longer access this variable
 * in this class we will go through the various types of variables and point out what can and 
 * cannot be accessed by a lambda
 * @author NoelF
 */
public class Gorilla {
	/**name of Groilla
	 * any lambda will be able to access this variable, as its a field of a class
	 */
	String name="magilla";
	{
		name="george";
	}
	/**age of Gorilla
	 * any lambda can access this variable, as age will be given the 
	 * default value of 0 if none are supplied
	 */
	int age;
	/**
	 * weight of Gorilla
	 * any lambda can access this variable, as weight will be given a default value of 0.0 if none are 
	 * supplied
	 */
	double weight;
	/**
	 * an enum type which all types of food a Gorilla will eat
	 * any lambda can access this variable, as food will be given a default value of null if none are
	 * supplied
	 *
	 */
	enum Food{
		BANANAS,MANGO,BAMBOO,COCONUT;
	}
	/**food Gorilla eats
	 *any lambda can access this variable, as food will be given a default value of null if none are
	 * supplied
	 */
	Food myFood;
	/** a static variable to show a lambda can access this variable
	 * any lambda can also acess this variable
	 */
	static int statInt;
	/**
	 * this method takes a method parameter of true or false which 
	 * a lambda can access as long as you don't change the parameter
	 * a method parameter has to be final or EFFECTIVELY final to be 
	 * accessed inside a lamba
	 * the lambdas in this method can access all the fields of the Gorilla class
	 * the lambdas in this method can access LOCAL VARIABLES as long as they are EFFECTIVELY FINAL
	 * Effectively final is variable that once given a value has not been changed, as is the case with num, number
	 * and check. Even if you change a variable AFTER a lambda uses it, the code will NOT compile. As that would mean
	 * that variable is NOT effectively final.
	 * @param baby this is parameter which a lambda inside the method will be able to access as long as
	 * we do not change the parameter inside the method, if we change the parameter inside the method the
	 * parameter is NO LONGER EFFECTIVELY FINAL, and hence cannot be accessed by a lambda in this method
	 */
	void everyOneMove(boolean baby) {
		//baby=true;//comment out this to see we cannot then access in lambda
		/*
		 * play method  takes an object that implements the Movement interface
		 * this can be object of a class that implements the Movement interface
		 * a anoymous class that implements the interface
		 * or a LAMBDA
		 */
		System.out.println("accessing method parameters *****");
		play(
				()->{
					System.out.println("can access method parameters");
					/*
					 * if we changet the value of the variable "baby" anywhere
					 * inside this method, the lambda will no longer be able
					 * to access this method parameter
					 */
					System.out.println("baby is "+baby);
					//baby=true;
					return "baby is "+baby;
				}
				);//end of lambda
	//	baby=true;//comment out to see we cann then access in lambda
		System.out.println("accessing fields ***");
		/*
		 * a lambda in a method in a class, can access ALL fields of the object
		 * here can access name, age,statInt.
		 * also it does not matter if any of these variables are changed anywhere
		 *, the lambda will still be able to access them
		 */
		age=120;
		play(
				()->{
					System.out.println("access name "+name);
					System.out.println("access age "+age);
					System.out.println("access statInt "+statInt);
					age=45;
					System.out.println("age is now "+age);
					System.out.println("accessing weight "+weight);
					System.out.println(myFood);
					return "play lambda can access all fields of a object";
				}
				);//end of lambda
		name="georgina";
		int num=230;
		double number;
		boolean check=true;
		check=false;
		System.out.println("accessing local variables");
		/*
		 * a lambda can only access local variables that are final or 
		 * effectively
		 */
		play(
				()->{
					//num is effectively final, given value and value does not change
					System.out.println("acessing num "+num);
					/*
					 * local variables are NOT given a default value, so this 
					 * cannot accessed
					 */
				//	System.out.println(number);//cannot access
					/*
					 * we cannot access the local variable "check" as we initially
					 * give it a value of true and then change it to false, so this
					 * variable is NOT effectively final
					 */
				//	System.out.println(check);
					return "accessing local variables in a lambda";
				}
				);
		/*
		 * uncomment this line to see that num is now no longer effectively final
		 * so would not be able to access num in lamda
		 */
		//num=89;//
		
	}
	/**
	 * this method can take a object of a class that impelements the Movement interface
	 * OR a lambda that implements the Movement interface
	 * OR A anonymous class object that implements the Movement interface
	 * @param m can be a object of class that implements Movement, a Anonymous class that implements Movement or
	 * a lambda that implements the Movement interface
	 * @return returns the implementation of the Move method from object m
	 */
	String play(Movement m) {
		return m.move();
	}
}
/**
 * a functional interface is an interface that has only ONE abstract method and 
 * you can create lambdas from this interface
 * the lamdba for this has not arguements and returns a String
 * this is the simpliest form of lambda we could have
 * {@code ()->"this is returned"};
 */
@FunctionalInterface
interface Movement{
	String move();
}
