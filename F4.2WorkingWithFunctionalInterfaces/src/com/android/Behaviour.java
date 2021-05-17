package com.android;
/**
 * we create our own functional interface, which is an interface with only one abstract and has four generic
 * types. this is used in Examples.ex2() method to show a lambda that will implement this functional interface
 * @author NoelF
 * @param <T> type T for our functional interface can be any type of object
 * @param <U> type U for our functional interface can be any type of object
 * @param <V> type V for our functional interface can be any type of object
 * @param <R> type R for our functional interface can be any type of object
 * @see com.android.Examples#ex2()
 */
@FunctionalInterface
public interface Behaviour<T,U,V,R> {
	//only one abstract method allowed for functional interfaces
	/**
	 * lambdas ONLY care about abstract methods and there can only be ONE
	 * so when we create a lambda for this functional interface, we are implmenting THIS method. So a lambda
	 * for this has to define four types (can be all the same type or all different) and has to return
	 * a value of type R and take in values of type T, U and V
	 * i.e{@code
	 * Happy<String,Integer,Double,String>myHappy}
	 * defines a T as a String, U as a Integer, V as a String and R as a String
	 * @param t variable of type T and type defined when creating a lambda for this interface
	 * @param u variable of type U and type defined when creating a lambda for this interface
	 * @param v variable of type V and type defined when creating a lambda for this interface
	 * @return returns a value of type R that will be defined when creating a lambda for htis interface
	 */
	R happy(T t,U u,V v);
	/*
	 * you can have as many static methods as you want in a functional interface
	 * HOWEVER, you can't use any of the generics in a static method
	 * will not recognise type T
	 */
/*	static String crowd(T t) {
		
	}*/
	/**
	 * you can have many static methods in a functional interface, however you CANNOT use any of the generics
	 * used in the abstract method, as those generics are tied to an INSTANCE of a class and statics apply
	 * to the class rather than an object of the class (a static method can have its' own generics though)
	 * @param str just a random string
	 * @param num just a random numbers
	 * @param num2 just a random number
	 * @return reurns a String
	 */
	static String crowd(String str,Integer num,Integer num2) {
		System.out.println("crowd method takes a String, Integer and Integer");
		return "my String";
	}
	/**
	 * you can have as many default methods as you want and you can use the
	 * generics, but you lambda will ONLY CONTAIN IMPLEMENTATION FOR the abstract method and not any of the
	 * default methods, a anonymous class can contain implementation for default methods
	 * @param t is a variable defined when creating a object that implements this interface
	 * @param u is a variable defined when creating a object that implements this interface
	 * @return just a ramdom number that is returned
	 */
	default int riot(T t,U u) {
		System.out.println("default rioting method");
		return 1;
	}
	/**
	 * to show you can have many default methods
	 * @param t paramter ot type T
	 * @param num simple Integer variable
	 * @return just returning any value for illustration purposes
	 */
	default double cheer(T t,Integer num) {
		return 1.0;
	}

}
