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
 * @see com.android.Gorilla
 */
public class Main {
	/**main method*/
	public static void main(String[]args) {
		Gorilla magilla=new Gorilla();
		System.out.println(magilla.myFood);
		
	}

}
