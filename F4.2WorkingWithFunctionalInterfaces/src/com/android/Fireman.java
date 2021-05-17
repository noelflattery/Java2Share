package com.android;

import java.util.function.UnaryOperator;
/**
 * class Fireman implements the UnaryOperator interface, so it has to provide implementation for the apply method
 * of the UnaryOperator interface. when we create an Fireman{@code
 * 	Fireman<Integerl>myFireman=new Fireman<Integer>()}
 * we are setting type T to be an Integer which means the UnaryOperator type T will also be a Integer
 * @author NoelF
 * @param <T> this is the type that will be supplied when creating a Fireman and will apply to the generic type of the UnaryOperator
 * @see com.android.Examples#ex10() 
 */
public class Fireman<T> implements UnaryOperator<T>{
	/**
	 * Overriding the apply method with Type T, which will be the return type and the type of Parameter
	 * @return returns an object of type T
	 */
	@Override
	public T apply(T t) {
		// TODO Auto-generated method stub
		return null;
	}

}
